package OooO0o0;

import OooO0o0.o000000;
import android.app.UiModeManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.BidiFormatter;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.app.NotificationCompat;
import androidx.core.widget.NestedScrollView;
import com.applovin.sdk.AppLovinEventTypes;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.point.PermissionDialogPoint;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.c0;
import com.cloud.tmc.integration.utils.f0;
import com.cloud.tmc.integration.utils.q;
import com.cloud.tmc.integration.utils.u;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.utils.e;
import com.cloud.tmc.miniapp.R$color;
import com.cloud.tmc.miniapp.R$drawable;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniapp.bridge.PrivacyBridge;
import com.cloud.tmc.miniapp.ui.WebViewActivity;
import com.cloud.tmc.miniutils.util.c;
import com.cloud.tmc.miniutils.util.x;
import com.google.gson.JsonObject;
import com.transsion.gslb.Utils;
import id.h;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import mb.d;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class o000000 extends OooO0o0.OooO0OO.OooO00o<o000000> {
    public final int A;
    public final int B;
    public final String C;
    public final String D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;
    public final Lazy H;
    public final Lazy I;
    public final Lazy J;
    public final Lazy K;
    public final Lazy L;
    public final Lazy M;
    public final Lazy N;
    public final Lazy O;
    public final Lazy P;
    public final Lazy Q;
    public final Lazy R;
    public final Lazy S;
    public final Lazy T;
    public final Lazy U;
    public final Lazy V;
    public final Lazy W;
    public final Lazy X;
    public final Lazy Y;
    public final Lazy Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final Lazy f93a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final Lazy f94b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final Lazy f95c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final Lazy f96d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final Lazy f97e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final Lazy f98f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final Lazy f99g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final Lazy f100h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public boolean f101i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public boolean f102j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f103k0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final App f104t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final bc.a f105u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f106v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f107w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f108x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f109y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f110z;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO extends Lambda implements Function0<Group> {
        public OooO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Group invoke() {
            return (Group) o000000.this.findViewById(R$id.group_addhome_btn);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0OO extends Lambda implements Function0<ConstraintLayout> {
        public OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ConstraintLayout invoke() {
            return (ConstraintLayout) o000000.this.findViewById(R$id.tv_privacy_agreement_container);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0o extends Lambda implements Function0<ConstraintLayout> {
        public OooO0o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ConstraintLayout invoke() {
            View viewY = o000000.y(o000000.this);
            if (viewY != null) {
                return (ConstraintLayout) viewY.findViewById(R$id.cl_two_in_one_container);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOO0 extends Lambda implements Function0<Group> {
        public OooOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Group invoke() {
            return (Group) o000000.this.findViewById(R$id.group_privacy_btn);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOO0O extends Lambda implements Function0<Group> {
        public OooOO0O() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Group invoke() {
            return (Group) o000000.this.findViewById(R$id.group_privacy_tv);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOOO extends Lambda implements Function0<ImageView> {
        public OooOOO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ImageView invoke() {
            View viewY = o000000.y(o000000.this);
            if (viewY != null) {
                return (ImageView) viewY.findViewById(R$id.iv_first_privacy_checkbox);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOOO0 extends Lambda implements Function0<Group> {
        public OooOOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Group invoke() {
            return (Group) o000000.this.findViewById(R$id.group_add_home_layout);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOOOO extends Lambda implements Function0<ImageView> {
        public OooOOOO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ImageView invoke() {
            return (ImageView) o000000.this.findViewById(R$id.iv_logo);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOo extends Lambda implements Function0<NestedScrollView> {
        public OooOo() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public NestedScrollView invoke() {
            View viewY = o000000.y(o000000.this);
            if (viewY != null) {
                return (NestedScrollView) viewY.findViewById(R$id.ns_two_in_one_layout);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOo00 extends Lambda implements Function0<ImageView> {
        public OooOo00() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ImageView invoke() {
            View viewY = o000000.y(o000000.this);
            if (viewY != null) {
                return (ImageView) viewY.findViewById(R$id.iv_second_privacy_checkbox);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class Oooo0 extends Lambda implements Function0<TextView> {
        public Oooo0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o000000.this.findViewById(R$id.tv_agree);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class Oooo000 extends Lambda implements Function0<TextView> {
        public Oooo000() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o000000.this.findViewById(R$id.tv_addhome_exit);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a implements OooO0o0.OooO0OO.j {
        public a() {
        }

        @Override // OooO0o0.OooO0OO.j
        public void b(OooO0o0.OooO0OO oooO0OO) {
            o000000 o000000Var = o000000.this;
            if (Intrinsics.b(o000000Var.f106v, o000000Var.C)) {
                PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
                App app = o000000.this.f104t;
                String appId = app != null ? app.getAppId() : null;
                Bundle bundle = new Bundle();
                App app2 = o000000.this.f104t;
                bundle.putString("miniappid", app2 != null ? app2.getAppId() : null);
                Unit unit = Unit.f68710a;
                performanceAnalyseProxy.recordForCommon(appId, "miniapp_agreemix_popup_ex", bundle);
                return;
            }
            o000000 o000000Var2 = o000000.this;
            if (Intrinsics.b(o000000Var2.f106v, o000000Var2.D)) {
                PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
                App app3 = o000000.this.f104t;
                String appId2 = app3 != null ? app3.getAppId() : null;
                Bundle bundle2 = new Bundle();
                App app4 = o000000.this.f104t;
                bundle2.putString("miniappid", app4 != null ? app4.getAppId() : null);
                Unit unit2 = Unit.f68710a;
                performanceAnalyseProxy2.recordForCommon(appId2, "miniapp_agree_popup_ex", bundle2);
                return;
            }
            if (o000000.this.f107w) {
                PerformanceAnalyseProxy performanceAnalyseProxy3 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
                App app5 = o000000.this.f104t;
                performanceAnalyseProxy3.recordForCommon(app5 != null ? app5.getAppId() : null, "privacy_ex", new Bundle());
            }
            o000000 o000000Var3 = o000000.this;
            if (o000000Var3.f108x) {
                if (o000000Var3.f109y) {
                    PerformanceAnalyseProxy performanceAnalyseProxy4 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
                    App app6 = o000000.this.f104t;
                    String appId3 = app6 != null ? app6.getAppId() : null;
                    Bundle bundle3 = new Bundle();
                    App app7 = o000000.this.f104t;
                    bundle3.putString("miniappid", app7 != null ? app7.getAppId() : null);
                    bundle3.putString("type", "2");
                    Unit unit3 = Unit.f68710a;
                    performanceAnalyseProxy4.recordForCommon(appId3, "appstart_add_ex", bundle3);
                    return;
                }
                ReportProxy reportProxy = (ReportProxy) tc.a.a(ReportProxy.class);
                App app8 = o000000.this.f104t;
                String appId4 = app8 != null ? app8.getAppId() : null;
                if (appId4 == null) {
                    appId4 = "";
                }
                Bundle bundle4 = new Bundle();
                App app9 = o000000.this.f104t;
                bundle4.putString("miniappid", app9 != null ? app9.getAppId() : null);
                bundle4.putString("type", "1");
                Unit unit4 = Unit.f68710a;
                reportProxy.forceAthenaReport(appId4, "appstart_add_ex", 3755, bundle4);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements OooO0o0.OooO0OO.f {
        public b() {
        }

        @Override // OooO0o0.OooO0OO.f
        public void a(OooO0o0.OooO0OO oooO0OO) {
            tb.b appContext;
            try {
                App app = o000000.this.f104t;
                Context context = (app == null || (appContext = app.getAppContext()) == null) ? null : appContext.getContext();
                com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO2 = context instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) context : null;
                if (oooO0OO2 != null) {
                    oooO0OO2.i0(true);
                }
            } catch (Throwable th2) {
                TmcLogger.h(o000000.this.f110z, th2);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class o0000 extends Lambda implements Function0<View> {
        public o0000() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public View invoke() {
            ViewStub viewStub = (ViewStub) o000000.this.findViewById(R$id.view_stub_two_in_one);
            if (viewStub != null) {
                return viewStub.inflate();
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class o00000 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ o000000 OooO0O0;
        public final /* synthetic */ boolean OooO0OO;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o00000(String str, o000000 o000000Var, boolean z11) {
            super(1);
            this.OooO00o = str;
            this.OooO0O0 = o000000Var;
            this.OooO0OO = z11;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(View view) {
            View it = view;
            Intrinsics.g(it, "it");
            String strA = TextUtils.isEmpty(this.OooO00o) ? "https://h5.dlight-app.com/outside/user-agreement?lang=" : this.OooO00o;
            WebViewActivity.a aVar = WebViewActivity.f31752h;
            Context context = this.OooO0O0.f27a;
            if (!this.OooO0OO) {
                strA = d.a(strA, context);
            }
            WebViewActivity.a.a(aVar, context, strA, null, null, 12);
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: OooO0o0.o000000$o000000, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0009o000000 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ o000000 OooO0O0;
        public final /* synthetic */ boolean OooO0OO;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0009o000000(String str, o000000 o000000Var, boolean z11) {
            super(1);
            this.OooO00o = str;
            this.OooO0O0 = o000000Var;
            this.OooO0OO = z11;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(View view) {
            View it = view;
            Intrinsics.g(it, "it");
            String strA = TextUtils.isEmpty(this.OooO00o) ? "https://h5.dlight-app.com/outside/user-agreement?lang=" : this.OooO00o;
            WebViewActivity.a aVar = WebViewActivity.f31752h;
            Context context = this.OooO0O0.f27a;
            if (!this.OooO0OO) {
                strA = d.a(strA, context);
            }
            WebViewActivity.a.a(aVar, context, strA, null, null, 12);
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class o000000O extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ o000000 OooO0O0;
        public final /* synthetic */ boolean OooO0OO;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o000000O(String str, o000000 o000000Var, boolean z11) {
            super(1);
            this.OooO00o = str;
            this.OooO0O0 = o000000Var;
            this.OooO0OO = z11;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(View view) {
            View it = view;
            Intrinsics.g(it, "it");
            String strA = TextUtils.isEmpty(this.OooO00o) ? "https://h5.dlight-app.com/outside/privacy-policy?lang=" : this.OooO00o;
            WebViewActivity.a aVar = WebViewActivity.f31752h;
            Context context = this.OooO0O0.f27a;
            if (!this.OooO0OO) {
                strA = d.a(strA, context);
            }
            WebViewActivity.a.a(aVar, context, strA, null, null, 12);
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class o00000O extends Lambda implements Function0<View> {
        public o00000O() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public View invoke() {
            View viewY = o000000.y(o000000.this);
            if (viewY != null) {
                return viewY.findViewById(R$id.view_first_click);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class o00000O0 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ o000000 OooO0O0;
        public final /* synthetic */ boolean OooO0OO;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o00000O0(String str, o000000 o000000Var, boolean z11) {
            super(1);
            this.OooO00o = str;
            this.OooO0O0 = o000000Var;
            this.OooO0OO = z11;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(View view) {
            View it = view;
            Intrinsics.g(it, "it");
            String strA = TextUtils.isEmpty(this.OooO00o) ? "https://h5.dlight-app.com/outside/privacy-policy?lang=" : this.OooO00o;
            WebViewActivity.a aVar = WebViewActivity.f31752h;
            Context context = this.OooO0O0.f27a;
            if (!this.OooO0OO) {
                strA = d.a(strA, context);
            }
            WebViewActivity.a.a(aVar, context, strA, null, null, 12);
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class o00000OO extends Lambda implements Function0<View> {
        public o00000OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public View invoke() {
            return o000000.this.findViewById(R$id.view_navigetion_bar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class o0000Ooo extends Lambda implements Function0<View> {
        public o0000Ooo() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public View invoke() {
            View viewY = o000000.y(o000000.this);
            if (viewY != null) {
                return viewY.findViewById(R$id.view_second_click);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class o000OOo extends Lambda implements Function0<TextView> {
        public o000OOo() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            View viewY = o000000.y(o000000.this);
            if (viewY != null) {
                return (TextView) viewY.findViewById(R$id.tv_two_in_one_title);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class o000oOoO extends Lambda implements Function0<TextView> {
        public o000oOoO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o000000.this.findViewById(R$id.tv_app_name);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class o00O0O extends Lambda implements Function0<TextView> {
        public o00O0O() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            View viewY = o000000.y(o000000.this);
            if (viewY != null) {
                return (TextView) viewY.findViewById(R$id.tv_first_privacy_title);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class o00Oo0 extends Lambda implements Function0<TextView> {
        public o00Oo0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o000000.this.findViewById(R$id.tv_privacy_agree);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class o00Ooo extends Lambda implements Function0<TextView> {
        public o00Ooo() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o000000.this.findViewById(R$id.tv_privacy_agreement_please_read);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class o00oO0o extends Lambda implements Function0<TextView> {
        public o00oO0o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o000000.this.findViewById(R$id.tv_privacy_cancel);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class o0O0O00 extends Lambda implements Function0<TextView> {
        public o0O0O00() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            View viewY = o000000.y(o000000.this);
            if (viewY != null) {
                return (TextView) viewY.findViewById(R$id.tv_two_in_one_gdpr_content);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class o0OO00O extends Lambda implements Function0<TextView> {
        public o0OO00O() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            View viewY = o000000.y(o000000.this);
            if (viewY != null) {
                return (TextView) viewY.findViewById(R$id.tv_two_in_one_agree);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class o0OOO0o extends Lambda implements Function0<TextView> {
        public o0OOO0o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            View viewY = o000000.y(o000000.this);
            if (viewY != null) {
                return (TextView) viewY.findViewById(R$id.tv_second_privacy_content);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class o0Oo0oo extends Lambda implements Function0<TextView> {
        public o0Oo0oo() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            View viewY = o000000.y(o000000.this);
            if (viewY != null) {
                return (TextView) viewY.findViewById(R$id.tv_second_privacy_title);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class o0OoOo0 extends Lambda implements Function0<TextView> {
        public o0OoOo0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            View viewY = o000000.y(o000000.this);
            if (viewY != null) {
                return (TextView) viewY.findViewById(R$id.tv_first_privacy_content);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class o0ooOOo extends Lambda implements Function0<TextView> {
        public o0ooOOo() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o000000.this.findViewById(R$id.tv_privacy_gdpr_content);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class oo000o extends Lambda implements Function0<TextView> {
        public oo000o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o000000.this.findViewById(R$id.tv_privacy_agreement_title);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class oo0o0Oo extends Lambda implements Function0<TextView> {
        public oo0o0Oo() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            View viewY = o000000.y(o000000.this);
            if (viewY != null) {
                return (TextView) viewY.findViewById(R$id.tv_two_in_one_cancel);
            }
            return null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o000000(Context context, App app, bc.a aVar) {
        super(context);
        Intrinsics.g(context, "context");
        this.f104t = app;
        this.f105u = aVar;
        this.f106v = "";
        this.f110z = "PrivacyAgreementDialog";
        this.A = 1;
        this.B = 2;
        this.C = "1";
        this.D = "2";
        this.E = LazyKt__LazyJVMKt.b(new OooO0OO());
        this.F = LazyKt__LazyJVMKt.b(new oo000o());
        this.G = LazyKt__LazyJVMKt.b(new o00Ooo());
        this.H = LazyKt__LazyJVMKt.b(new OooOOO0());
        this.I = LazyKt__LazyJVMKt.b(new OooOOOO());
        this.J = LazyKt__LazyJVMKt.b(new Oooo0());
        this.K = LazyKt__LazyJVMKt.b(new Oooo000());
        this.L = LazyKt__LazyJVMKt.b(new o000oOoO());
        this.M = LazyKt__LazyJVMKt.b(new OooOO0O());
        this.N = LazyKt__LazyJVMKt.b(new OooOO0());
        this.O = LazyKt__LazyJVMKt.b(new o0ooOOo());
        this.P = LazyKt__LazyJVMKt.b(new o00Oo0());
        this.Q = LazyKt__LazyJVMKt.b(new o00oO0o());
        this.R = LazyKt__LazyJVMKt.b(new o00000OO());
        this.S = LazyKt__LazyJVMKt.b(new OooO());
        this.T = LazyKt__LazyJVMKt.b(new o0000());
        this.U = LazyKt__LazyJVMKt.b(new OooO0o());
        this.V = LazyKt__LazyJVMKt.b(new OooOo());
        this.W = LazyKt__LazyJVMKt.b(new o000OOo());
        this.X = LazyKt__LazyJVMKt.b(new o0OO00O());
        this.Y = LazyKt__LazyJVMKt.b(new oo0o0Oo());
        this.Z = LazyKt__LazyJVMKt.b(new OooOOO());
        this.f93a0 = LazyKt__LazyJVMKt.b(new o00O0O());
        this.f94b0 = LazyKt__LazyJVMKt.b(new o0OoOo0());
        this.f95c0 = LazyKt__LazyJVMKt.b(new OooOo00());
        this.f96d0 = LazyKt__LazyJVMKt.b(new o0Oo0oo());
        this.f97e0 = LazyKt__LazyJVMKt.b(new o0OOO0o());
        this.f98f0 = LazyKt__LazyJVMKt.b(new o0O0O00());
        this.f99g0 = LazyKt__LazyJVMKt.b(new o00000O());
        this.f100h0 = LazyKt__LazyJVMKt.b(new o0000Ooo());
        try {
            j(R$layout.mini_layout_privacy_agreement_dialog);
            g(true);
            k(true);
            TextView textViewS = S();
            if (textViewS != null) {
                textViewS.setOnClickListener(new View.OnClickListener() { // from class: j.o
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        o000000.z(this.f67784a, view);
                    }
                });
            }
            TextView textViewU = U();
            if (textViewU != null) {
                textViewU.setOnClickListener(new View.OnClickListener() { // from class: j.p
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        o000000.I(this.f67785a, view);
                    }
                });
            }
            TextView textViewV = v();
            if (textViewV != null) {
                textViewV.setOnClickListener(new View.OnClickListener() { // from class: j.q
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        o000000.J(this.f67786a, view);
                    }
                });
            }
            TextView textViewQ = Q();
            if (textViewQ != null) {
                textViewQ.setOnClickListener(new View.OnClickListener() { // from class: j.r
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        o000000.K(this.f67787a, view);
                    }
                });
            }
            e(new a());
            c(new b());
        } catch (Throwable th2) {
            TmcLogger.g(this.f110z, "updateDialogLayout", th2);
        }
    }

    public static final void G(Ref.BooleanRef autoSelect, o000000 this$0) {
        Intrinsics.g(autoSelect, "$autoSelect");
        Intrinsics.g(this$0, "this$0");
        if (autoSelect.element) {
            this$0.f101i0 = true;
            this$0.f102j0 = true;
            ImageView imageViewL = this$0.L();
            if (imageViewL != null) {
                imageViewL.setImageResource(R$drawable.mini_sel_privacy_checkbox_checked);
            }
            ImageView imageViewO = this$0.O();
            if (imageViewO != null) {
                imageViewO.setImageResource(R$drawable.mini_sel_privacy_checkbox_checked);
            }
        }
        this$0.X();
    }

    public static final void H(final o000000 this$0) {
        Intrinsics.g(this$0, "this$0");
        try {
            String strG = c0.g(this$0.f27a);
            TmcLogger.c(this$0.f110z, "initAutoCheckStatus mcc:" + strG);
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            if (strG.length() == 0) {
                booleanRef.element = true;
            } else {
                if (!StringsKt__StringsKt.Q("310,311,312,313,314,315,316,302,232,206,284,280,230,219,238,248,244,208,262,202,216,272,222,247,246,270,278,204,260,268,231,293,214,240,234,235,286,274,242,228,259,250,404,405", strG, false, 2, null)) {
                    booleanRef.element = true;
                }
                MiniAppConfigHelper miniAppConfigHelper = MiniAppConfigHelper.f30370a;
                String strE = miniAppConfigHelper.e("privacyAutoBlackCountry", "");
                if (strE.length() <= 0 || !StringsKt__StringsKt.Q(strE, strG, false, 2, null)) {
                    String strE2 = miniAppConfigHelper.e("privacyAutoWhiteCountry", "");
                    if (strE2.length() > 0 && StringsKt__StringsKt.Q(strE2, strG, false, 2, null)) {
                        booleanRef.element = true;
                    }
                } else {
                    booleanRef.element = false;
                }
            }
            e.a(ExecutorType.UI, new Runnable() { // from class: j.n
                @Override // java.lang.Runnable
                public final void run() {
                    o000000.G(booleanRef, this$0);
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static final void I(o000000 this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        try {
            bc.a aVar = this$0.f105u;
            if (aVar != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty(NotificationCompat.CATEGORY_STATUS, "cancel");
                jsonObject.addProperty("clickBtn", "2");
                aVar.d(jsonObject);
            }
            bc.a aVar2 = this$0.f105u;
            if (aVar2 != null) {
                aVar2.close();
            }
            try {
                if (Intrinsics.b(this$0.f106v, this$0.D)) {
                    PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
                    App app = this$0.f104t;
                    String appId = app != null ? app.getAppId() : null;
                    Bundle bundle = new Bundle();
                    App app2 = this$0.f104t;
                    bundle.putString("miniappid", app2 != null ? app2.getAppId() : null);
                    bundle.putString(AppLovinEventTypes.USER_VIEWED_CONTENT, "0");
                    Unit unit = Unit.f68710a;
                    performanceAnalyseProxy.recordForCommon(appId, "miniapp_agree_popup_click", bundle);
                }
            } catch (Throwable unused) {
            }
            this$0.l();
        } catch (Throwable th2) {
            TmcLogger.g(this$0.f110z, "tvPrivacyCancel error", th2);
        }
    }

    public static final void J(o000000 this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.C(this$0.f104t, this$0.f105u, this$0.A);
    }

    public static final void K(o000000 this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        try {
            bc.a aVar = this$0.f105u;
            if (aVar != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty(NotificationCompat.CATEGORY_STATUS, "cancel");
                jsonObject.addProperty("clickBtn", "4");
                aVar.d(jsonObject);
            }
            bc.a aVar2 = this$0.f105u;
            if (aVar2 != null) {
                aVar2.close();
            }
            this$0.l();
        } catch (Throwable th2) {
            TmcLogger.g(this$0.f110z, "tvPrivacyCancel error", th2);
        }
    }

    public static final void M(o000000 this_apply, View view) {
        Intrinsics.g(this_apply, "$this_apply");
        if (this_apply.f102j0) {
            ImageView imageViewO = this_apply.O();
            if (imageViewO != null) {
                imageViewO.setImageResource(R$drawable.mini_sel_privacy_checkbox_unchecked);
            }
        } else {
            ImageView imageViewO2 = this_apply.O();
            if (imageViewO2 != null) {
                imageViewO2.setImageResource(R$drawable.mini_sel_privacy_checkbox_checked);
            }
        }
        this_apply.f102j0 = !this_apply.f102j0;
        this_apply.X();
    }

    public static final void N(o000000 this_apply, View view) {
        Intrinsics.g(this_apply, "$this_apply");
        if (this_apply.f101i0) {
            ImageView imageViewL = this_apply.L();
            if (imageViewL != null) {
                imageViewL.setImageResource(R$drawable.mini_sel_privacy_checkbox_unchecked);
            }
        } else {
            ImageView imageViewL2 = this_apply.L();
            if (imageViewL2 != null) {
                imageViewL2.setImageResource(R$drawable.mini_sel_privacy_checkbox_checked);
            }
        }
        this_apply.f101i0 = !this_apply.f101i0;
        this_apply.X();
    }

    public static final void P(o000000 this_apply, View view) {
        Intrinsics.g(this_apply, "$this_apply");
        if (this_apply.f101i0 && this_apply.f102j0) {
            this_apply.C(this_apply.f104t, this_apply.f105u, this_apply.B);
        }
    }

    public static final void R(o000000 this_apply, View view) {
        Intrinsics.g(this_apply, "$this_apply");
        try {
            bc.a aVar = this_apply.f105u;
            if (aVar != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty(NotificationCompat.CATEGORY_STATUS, "cancel");
                jsonObject.addProperty("clickBtn", "2");
                aVar.d(jsonObject);
            }
            bc.a aVar2 = this_apply.f105u;
            if (aVar2 != null) {
                aVar2.close();
            }
            this_apply.l();
        } catch (Throwable th2) {
            TmcLogger.g(this_apply.f110z, "tvPrivacyCancel error", th2);
        }
    }

    public static final View y(o000000 o000000Var) {
        return (View) o000000Var.T.getValue();
    }

    public static final void z(o000000 this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.C(this$0.f104t, this$0.f105u, this$0.B);
    }

    public final void A(Window window) {
        Intrinsics.g(window, "window");
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 29) {
            window.setNavigationBarContrastEnforced(false);
        }
        window.clearFlags(ASTNode.NOJIT);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 512);
        window.setNavigationBarColor(0);
        Object systemService = this.f27a.getSystemService("uimode");
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.app.UiModeManager");
        ((UiModeManager) systemService).getNightMode();
        Intrinsics.g(window, "window");
        if (i11 >= 26) {
            window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 16);
        }
    }

    public final void B(TextView textView, String str, int i11, String str2, String str3, int i12, int i13, String str4, String str5, int i14, boolean z11) {
        if (textView != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            try {
                spannableStringBuilder.append(str.subSequence(0, i11));
            } catch (Throwable unused) {
            }
            xb.d.b(spannableStringBuilder, BidiFormatter.getInstance().unicodeWrap(str4), Integer.valueOf(h.a.a(this, R$color.mini_color_primary)), false, new o00000(str5, this, z11));
            try {
                spannableStringBuilder.setSpan(new StyleSpan(1), i11, str4.length() + i11, 33);
            } catch (Throwable unused2) {
            }
            try {
                spannableStringBuilder.append(str.subSequence(i12 + 1, i13));
            } catch (Throwable unused3) {
            }
            xb.d.b(spannableStringBuilder, BidiFormatter.getInstance().unicodeWrap(str2), Integer.valueOf(h.a.a(this, R$color.mini_color_primary)), false, new o00000O0(str3, this, z11));
            try {
                int length = (str4.length() + i13) - 4;
                spannableStringBuilder.setSpan(new StyleSpan(1), length, str2.length() + length, 33);
            } catch (Throwable unused4) {
            }
            try {
                spannableStringBuilder.append(str.subSequence(i14 + 1, str.length()));
            } catch (Throwable unused5) {
            }
            textView.setText(new SpannedString(spannableStringBuilder));
        }
        if (textView != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        if (textView != null) {
            xb.h.b(textView);
        }
    }

    public final void C(App app, bc.a aVar, int i11) {
        tb.b appContext;
        AppModel appModel;
        if (u.a()) {
            return;
        }
        try {
            try {
                if (this.f107w) {
                    ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).recordForCommon(app != null ? app.getAppId() : null, "privacy_click", new Bundle());
                    q.f31091a.r("");
                }
                boolean z11 = this.f108x;
                if (z11) {
                    if (z11) {
                        q.f31091a.r(app != null ? app.getAppId() : null);
                    }
                    PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
                    String appId = app != null ? app.getAppId() : null;
                    Bundle bundle = new Bundle();
                    bundle.putString("miniappid", app != null ? app.getAppId() : null);
                    bundle.putString("type", this.f109y ? "2" : "1");
                    Unit unit = Unit.f68710a;
                    performanceAnalyseProxy.recordForCommon(appId, "appstart_add_click", bundle);
                }
            } catch (Throwable th2) {
                try {
                    TmcLogger.g(this.f110z, "callback error", th2);
                    return;
                } finally {
                    l();
                }
            }
        } catch (Throwable th3) {
            TmcLogger.h(this.f110z, th3);
        }
        try {
            f0.f31050a.j((app == null || (appModel = app.getAppModel()) == null) ? null : appModel.getAppId());
            if (app != null && (appContext = app.getAppContext()) != null && appContext.getContext() != null) {
                PrivacyBridge.Companion.getClass();
                if (PrivacyBridge.OooO0O0.containsKey(app.getAppId())) {
                    PrivacyBridge.OooO0O0.remove(app.getAppId());
                    PermissionDialogPoint permissionDialogPoint = (PermissionDialogPoint) ib.a.b(PermissionDialogPoint.class).d();
                    String appId2 = app.getAppId();
                    Intrinsics.f(appId2, "app.appId");
                    permissionDialogPoint.privacyDialogDismiss(appId2, app.getStartToken());
                }
            }
        } catch (Throwable th4) {
            TmcLogger.g(this.f110z, "privacyDialogDismiss", th4);
        }
        if (i11 == this.A) {
            if (aVar != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty(NotificationCompat.CATEGORY_STATUS, "agreeClick");
                jsonObject.addProperty("clickBtn", "3");
                aVar.d(jsonObject);
            }
            if (aVar != null) {
                aVar.close();
            }
        } else if (i11 == this.B) {
            if (aVar != null) {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty(NotificationCompat.CATEGORY_STATUS, "agreeClick");
                jsonObject2.addProperty("clickBtn", "1");
                aVar.d(jsonObject2);
            }
            if (aVar != null) {
                aVar.close();
            }
        }
        if (Intrinsics.b(this.f106v, this.D)) {
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            String appId3 = app != null ? app.getAppId() : null;
            Bundle bundle2 = new Bundle();
            bundle2.putString("miniappid", app != null ? app.getAppId() : null);
            bundle2.putString(AppLovinEventTypes.USER_VIEWED_CONTENT, "1");
            Unit unit2 = Unit.f68710a;
            performanceAnalyseProxy2.recordForCommon(appId3, "miniapp_agree_popup_click", bundle2);
        }
        l();
    }

    public final void D(String str, int i11, String str2, String str3, int i12, int i13, String str4, String str5, int i14, boolean z11) {
        TextView textViewT = T();
        if (textViewT == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(str.subSequence(0, i11));
        xb.d.b(spannableStringBuilder, BidiFormatter.getInstance().unicodeWrap(str4), Integer.valueOf(h.a.a(this, R$color.mini_color_primary)), false, new C0009o000000(str5, this, z11));
        try {
            spannableStringBuilder.setSpan(new StyleSpan(1), i11, str4.length() + i11, 33);
        } catch (Throwable unused) {
        }
        try {
            spannableStringBuilder.append(str.subSequence(i12 + 1, i13));
        } catch (Throwable unused2) {
        }
        xb.d.b(spannableStringBuilder, BidiFormatter.getInstance().unicodeWrap(str2), Integer.valueOf(h.a.a(this, R$color.mini_color_primary)), false, new o000000O(str3, this, z11));
        try {
            int length = (str4.length() + i13) - 4;
            spannableStringBuilder.setSpan(new StyleSpan(1), length, str2.length() + length, 33);
        } catch (Throwable unused3) {
        }
        try {
            spannableStringBuilder.append(str.subSequence(i14 + 1, str.length()));
        } catch (Throwable unused4) {
        }
        textViewT.setText(new SpannedString(spannableStringBuilder));
    }

    /* JADX WARN: Code duplicated, block: B:74:0x013e A[PHI: r1
  0x013e: PHI (r1v9 java.lang.String) = (r1v8 java.lang.String), (r1v11 java.lang.String) binds: [B:78:0x0149, B:72:0x013b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:86:0x015b A[PHI: r1
  0x015b: PHI (r1v14 java.lang.String) = (r1v13 java.lang.String), (r1v16 java.lang.String) binds: [B:88:0x0163, B:84:0x0158] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:96:0x0175 A[PHI: r1
  0x0175: PHI (r1v19 java.lang.String) = (r1v18 java.lang.String), (r1v21 java.lang.String) binds: [B:98:0x017d, B:94:0x0172] A[DONT_GENERATE, DONT_INLINE]] */
    public final void E(String title, int i11, String baseContent, String privacyPolocyContent, String userAgreementContent, String buttonText, String privacyPolocyUrl, String userAgreementUrl, boolean z11, boolean z12, boolean z13, boolean z14, String str, String str2, String str3, String str4, App app, boolean z15, boolean z16) {
        int i12;
        String strD;
        String str5;
        String strD2;
        String str6;
        String strD3;
        String str7;
        String strD4;
        AppModel appModel;
        TextView textView;
        Unit unit;
        AppModel appModel2;
        String logo;
        Unit unit2;
        Intrinsics.g(title, "title");
        Intrinsics.g(baseContent, "baseContent");
        Intrinsics.g(privacyPolocyContent, "privacyPolocyContent");
        Intrinsics.g(userAgreementContent, "userAgreementContent");
        Intrinsics.g(buttonText, "buttonText");
        Intrinsics.g(privacyPolocyUrl, "privacyPolocyUrl");
        Intrinsics.g(userAgreementUrl, "userAgreementUrl");
        if (z11 && app != null) {
            app.updateAddHomeShowStatus(100);
        }
        this.f107w = z12;
        this.f108x = z11;
        this.f109y = z13;
        if (z11) {
            Group group = (Group) this.H.getValue();
            if (group != null) {
                group.setVisibility(0);
            }
            if (app == null || (appModel2 = app.getAppModel()) == null || (logo = appModel2.getLogo()) == null) {
                unit = null;
            } else {
                ImageView imageView = (ImageView) this.I.getValue();
                if (imageView != null) {
                    try {
                        ((ImageLoaderProxy) tc.a.a(ImageLoaderProxy.class)).loadImgRoundCorners(this.f27a, logo, imageView, x.a(14.0f));
                    } catch (Throwable th2) {
                        TmcLogger.g(this.f110z, "showAddhomeLayout", th2);
                    }
                    unit2 = Unit.f68710a;
                } else {
                    unit2 = null;
                }
                if (unit2 == null) {
                    TmcLogger.c(this.f110z, "privacy dialog add home ,ivLogo is null");
                }
                unit = Unit.f68710a;
            }
            if (unit == null) {
                TmcLogger.c(this.f110z, "privacy dialog add home ,logoUrl is null");
            }
        } else {
            TmcLogger.c(this.f110z, "privacy dialog add home ,showAddHome is false");
            Group group2 = (Group) this.H.getValue();
            if (group2 != null) {
                group2.setVisibility(8);
            }
        }
        TextView textView2 = (TextView) this.F.getValue();
        if (textView2 != null) {
            textView2.setText(title);
        }
        if (i11 != 0 && (textView = (TextView) this.F.getValue()) != null) {
            textView.setMaxLines(i11);
        }
        TextView textView3 = (TextView) this.L.getValue();
        if (textView3 != null) {
            textView3.setText((app == null || (appModel = app.getAppModel()) == null) ? null : appModel.getName());
        }
        try {
            if (this.f107w) {
                Group group3 = (Group) this.N.getValue();
                if (group3 == null) {
                    i12 = 0;
                } else {
                    i12 = 0;
                    group3.setVisibility(0);
                }
                Group group4 = (Group) this.M.getValue();
                if (group4 != null) {
                    group4.setVisibility(i12);
                }
                Group group5 = (Group) this.S.getValue();
                if (group5 != null) {
                    group5.setVisibility(8);
                }
                if (z14) {
                    str5 = baseContent;
                } else if (z16) {
                    strD = h.a.d(this, R$string.mini_privacy_reading_notice_only_en);
                    if (strD == null) {
                        str5 = "";
                    } else {
                        str5 = strD;
                    }
                } else {
                    strD = h.a.d(this, R$string.mini_privacy_reading_notice);
                    if (strD == null) {
                        str5 = "";
                    } else {
                        str5 = strD;
                    }
                }
                if (z14) {
                    str6 = privacyPolocyContent;
                } else if (z16) {
                    strD2 = h.a.d(this, R$string.mini_privacy_privacy_policy_only_en);
                    if (strD2 == null) {
                        str6 = "";
                    } else {
                        str6 = strD2;
                    }
                } else {
                    strD2 = h.a.d(this, R$string.mini_privacy_privacy_policy);
                    if (strD2 == null) {
                        str6 = "";
                    } else {
                        str6 = strD2;
                    }
                }
                if (z14) {
                    str7 = userAgreementContent;
                } else if (z16) {
                    strD3 = h.a.d(this, R$string.mini_privacy_user_agreement_only_en);
                    if (strD3 == null) {
                        str7 = "";
                    } else {
                        str7 = strD3;
                    }
                } else {
                    strD3 = h.a.d(this, R$string.mini_privacy_user_agreement);
                    if (strD3 == null) {
                        str7 = "";
                    } else {
                        str7 = strD3;
                    }
                }
                D(str5, StringsKt__StringsKt.d0(str5, Utils.SEPARATOR, 0, false, 6, null), str6, privacyPolocyUrl, StringsKt__StringsKt.j0(str5, Utils.SEPARATOR, 0, false, 6, null), StringsKt__StringsKt.d0(str5, "*", 0, false, 6, null), str7, userAgreementUrl, StringsKt__StringsKt.j0(str5, "*", 0, false, 6, null), z15);
                TextView textView4 = (TextView) this.O.getValue();
                if (textView4 != null) {
                    if (str != null && str.length() > 0) {
                        strD4 = str;
                    } else if (z16) {
                        strD4 = h.a.d(this, R$string.mini_gdpr_privacy_only_en);
                        if (strD4 == null) {
                            strD4 = "";
                        }
                    } else {
                        strD4 = h.a.d(this, R$string.mini_gdpr_privacy);
                        if (strD4 == null) {
                            strD4 = "";
                        }
                    }
                    textView4.setText(strD4);
                }
                TextView textView5 = (TextView) this.O.getValue();
                if (textView5 != null) {
                    textView5.setMovementMethod(ScrollingMovementMethod.getInstance());
                }
                TextView textView6 = (TextView) this.P.getValue();
                if (textView6 != null) {
                    textView6.setText(str3);
                }
                TextView textView7 = (TextView) this.Q.getValue();
                if (textView7 != null) {
                    textView7.setText(str2);
                }
                TextView textViewT = T();
                if (textViewT != null) {
                    textViewT.setMovementMethod(LinkMovementMethod.getInstance());
                }
                TextView textViewT2 = T();
                if (textViewT2 != null) {
                    xb.h.b(textViewT2);
                }
            } else {
                Group group6 = (Group) this.N.getValue();
                if (group6 != null) {
                    group6.setVisibility(8);
                }
                Group group7 = (Group) this.M.getValue();
                if (group7 != null) {
                    group7.setVisibility(8);
                }
                Group group8 = (Group) this.S.getValue();
                if (group8 != null) {
                    group8.setVisibility(0);
                }
                TmcLogger.c(this.f110z, "privacy dialog add home ,showPrivacy is false");
            }
        } catch (Throwable th3) {
            TmcLogger.g(this.f110z, "privacy dialog add home error", th3);
        }
        TextView textView8 = (TextView) this.J.getValue();
        if (textView8 != null) {
            textView8.setText(buttonText);
        }
        TextView textView9 = (TextView) this.K.getValue();
        if (textView9 == null) {
            return;
        }
        textView9.setText(str4);
    }

    public final void F(String privacyDialogType, String title, int i11, String baseContent, String privacyPolocyContent, String userAgreementContent, String buttonText, String privacyPolocyUrl, String userAgreementUrl, boolean z11, String str, String str2, String str3, String str4, boolean z12, App app) {
        Intrinsics.g(privacyDialogType, "privacyDialogType");
        Intrinsics.g(title, "title");
        Intrinsics.g(baseContent, "baseContent");
        Intrinsics.g(privacyPolocyContent, "privacyPolocyContent");
        Intrinsics.g(userAgreementContent, "userAgreementContent");
        Intrinsics.g(buttonText, "buttonText");
        Intrinsics.g(privacyPolocyUrl, "privacyPolocyUrl");
        Intrinsics.g(userAgreementUrl, "userAgreementUrl");
        this.f106v = privacyDialogType;
        ConstraintLayout constraintLayout = (ConstraintLayout) this.E.getValue();
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        ConstraintLayout constraintLayout2 = (ConstraintLayout) this.U.getValue();
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(8);
        }
        E(title, i11, baseContent, privacyPolocyContent, userAgreementContent, buttonText, privacyPolocyUrl, userAgreementUrl, false, true, false, z11, str, str2, str3, str4, app, true, z12);
    }

    public final ImageView L() {
        return (ImageView) this.Z.getValue();
    }

    public final ImageView O() {
        return (ImageView) this.f95c0.getValue();
    }

    public final TextView Q() {
        return (TextView) this.K.getValue();
    }

    public final TextView S() {
        return (TextView) this.P.getValue();
    }

    public final TextView T() {
        return (TextView) this.G.getValue();
    }

    public final TextView U() {
        return (TextView) this.Q.getValue();
    }

    public final void V() {
        Window window;
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                int iC = c.c();
                if (iC <= 50) {
                    this.f103k0 = x.a(28.0f);
                    return;
                }
                OooO0o0.OooO0OO oooO0OO = this.f28b;
                if (oooO0OO == null || (window = oooO0OO.getWindow()) == null) {
                    return;
                }
                A(window);
                View view = (View) this.R.getValue();
                ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
                int iA = iC + x.a(16.0f);
                this.f103k0 = iA;
                if (layoutParams != null) {
                    layoutParams.height = iA;
                }
                View view2 = (View) this.R.getValue();
                if (view2 != null) {
                    view2.setLayoutParams(layoutParams);
                }
            }
        } catch (Throwable th2) {
            TmcLogger.h(this.f110z, th2);
        }
    }

    public final void W() {
        try {
            e.a(ExecutorType.IO, new Runnable() { // from class: j.w
                @Override // java.lang.Runnable
                public final void run() {
                    o000000.H(this.f67792a);
                }
            });
        } catch (Throwable unused) {
        }
    }

    public final void X() {
        try {
            Drawable drawableB = h.a.b(this, R$drawable.mini_privacy_button_unclick_bg);
            GradientDrawable gradientDrawable = drawableB instanceof GradientDrawable ? (GradientDrawable) drawableB : null;
            int iA = (this.f101i0 && this.f102j0) ? h.a.a(this, R$color.mini_color_primary) : h.a.a(this, R$color.mini_two_in_one_agree_unchecked_bg);
            if (gradientDrawable != null) {
                gradientDrawable.setColor(iA);
            }
            TextView textView = (TextView) this.X.getValue();
            if (textView == null) {
                return;
            }
            textView.setBackground(gradientDrawable);
        } catch (Throwable th2) {
            TmcLogger.h(this.f110z, th2);
        }
    }

    public final TextView v() {
        return (TextView) this.J.getValue();
    }

    public final o000000 w(String title, int i11, String baseContent, String privacyPolocyContent, String userAgreementContent, String buttonText, String privacyPolocyUrl, String userAgreementUrl, boolean z11, boolean z12, boolean z13, boolean z14, String str, String str2, String str3, String str4, boolean z15, boolean z16) {
        Intrinsics.g(title, "title");
        Intrinsics.g(baseContent, "baseContent");
        Intrinsics.g(privacyPolocyContent, "privacyPolocyContent");
        Intrinsics.g(userAgreementContent, "userAgreementContent");
        Intrinsics.g(buttonText, "buttonText");
        Intrinsics.g(privacyPolocyUrl, "privacyPolocyUrl");
        Intrinsics.g(userAgreementUrl, "userAgreementUrl");
        E(title, i11, baseContent, privacyPolocyContent, userAgreementContent, buttonText, privacyPolocyUrl, userAgreementUrl, z11, z12, z13, z14, str, str2, str3, str4, this.f104t, z15, z16);
        return this;
    }

    public final o000000 x(String privacyDialogType, String title, String privacyTitle, String str, String privacyPolocyContent, String userAgreementContent, String str2, String str3, String secondPrivacyTitle, String secondBaseContent, String str4, String secondUserAgreementContent, String secondPrivacyPolocyUrl, String secondUserAgreementUrl, String gdprNoticeContent, String highlightContent, String privacyCancelTv, String privacyAgreeTv, int i11, boolean z11, boolean z12) {
        String str5;
        String str6;
        String str7;
        int i12;
        String strD;
        String strD2;
        TextView textView;
        TextView textView2;
        TextView textView3;
        Intrinsics.g(privacyDialogType, "privacyDialogType");
        Intrinsics.g(title, "title");
        Intrinsics.g(privacyTitle, "privacyTitle");
        String baseContent = str;
        Intrinsics.g(baseContent, "baseContent");
        Intrinsics.g(privacyPolocyContent, "privacyPolocyContent");
        Intrinsics.g(userAgreementContent, "userAgreementContent");
        String privacyPolocyUrl = str2;
        Intrinsics.g(privacyPolocyUrl, "privacyPolocyUrl");
        String userAgreementUrl = str3;
        Intrinsics.g(userAgreementUrl, "userAgreementUrl");
        Intrinsics.g(secondPrivacyTitle, "secondPrivacyTitle");
        Intrinsics.g(secondBaseContent, "secondBaseContent");
        String secondPrivacyPolocyContent = str4;
        Intrinsics.g(secondPrivacyPolocyContent, "secondPrivacyPolocyContent");
        Intrinsics.g(secondUserAgreementContent, "secondUserAgreementContent");
        Intrinsics.g(secondPrivacyPolocyUrl, "secondPrivacyPolocyUrl");
        Intrinsics.g(secondUserAgreementUrl, "secondUserAgreementUrl");
        Intrinsics.g(gdprNoticeContent, "gdprNoticeContent");
        Intrinsics.g(highlightContent, "highlightContent");
        Intrinsics.g(privacyCancelTv, "privacyCancelTv");
        Intrinsics.g(privacyAgreeTv, "privacyAgreeTv");
        this.f106v = privacyDialogType;
        if (Intrinsics.b(privacyDialogType, "") || Intrinsics.b(privacyDialogType, this.D)) {
            w(title, i11, str, privacyPolocyContent, userAgreementContent, "", str2, str3, false, true, false, z11, gdprNoticeContent, privacyCancelTv, privacyAgreeTv, "", true, z12);
            return this;
        }
        if (!Intrinsics.b(privacyDialogType, this.C)) {
            return this;
        }
        this.f107w = true;
        this.f108x = false;
        this.f109y = true;
        ConstraintLayout constraintLayout = (ConstraintLayout) this.E.getValue();
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
        if (title.length() > 0 && (textView3 = (TextView) this.W.getValue()) != null) {
            textView3.setText(title);
        }
        if (privacyTitle.length() > 0 && (textView2 = (TextView) this.f93a0.getValue()) != null) {
            textView2.setText(privacyTitle);
        }
        if (secondPrivacyTitle.length() > 0 && (textView = (TextView) this.f96d0.getValue()) != null) {
            textView.setText(secondPrivacyTitle);
        }
        try {
            int iA = (this.f27a.getResources().getDisplayMetrics().heightPixels - x.a(260.0f)) - this.f103k0;
            NestedScrollView nestedScrollView = (NestedScrollView) this.V.getValue();
            ViewGroup.LayoutParams layoutParams = nestedScrollView != null ? nestedScrollView.getLayoutParams() : null;
            Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            ((ViewGroup.MarginLayoutParams) bVar).height = -2;
            TmcLogger.c(this.f110z, " two in one maxPrivacyHeight:" + iA);
            bVar.U = iA;
            NestedScrollView nestedScrollView2 = (NestedScrollView) this.V.getValue();
            if (nestedScrollView2 != null) {
                nestedScrollView2.setLayoutParams(bVar);
            }
        } catch (Throwable unused) {
        }
        String strD3 = str.length() == 0 ? h.a.d(this, R$string.mini_two_in_one_first_check_content) : baseContent;
        if (userAgreementContent.length() == 0) {
            String strD4 = h.a.d(this, R$string.mini_two_in_one_first_check_user_agreement);
            str5 = strD4 == null ? "" : strD4;
        } else {
            str5 = userAgreementContent;
        }
        if (privacyPolocyContent.length() == 0) {
            String strD5 = h.a.d(this, R$string.mini_two_in_one_first_check_privacy_policy);
            str6 = strD5 == null ? "" : strD5;
        } else {
            str6 = privacyPolocyContent;
        }
        if (str3.length() == 0) {
            userAgreementUrl = "https://h5.dlight-app.com/outside/user-agreement?lang=";
        }
        if (str2.length() == 0) {
            privacyPolocyUrl = "https://h5.dlight-app.com/outside/privacy-policy?lang=";
        }
        if (strD3 != null) {
            try {
                int iD0 = StringsKt__StringsKt.d0(strD3, Utils.SEPARATOR, 0, false, 6, null);
                int iJ0 = StringsKt__StringsKt.j0(strD3, Utils.SEPARATOR, 0, false, 6, null);
                int iD1 = StringsKt__StringsKt.d0(strD3, "*", 0, false, 6, null);
                int iJ1 = StringsKt__StringsKt.j0(strD3, "*", 0, false, 6, null);
                String str8 = strD3;
                str7 = "";
                String str9 = userAgreementUrl;
                i12 = 1;
                try {
                    B((TextView) this.f94b0.getValue(), str8, iD0, str6, privacyPolocyUrl, iJ0, iD1, str5, str9, iJ1, false);
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
                str7 = "";
                i12 = 1;
            }
        } else {
            str7 = "";
            i12 = 1;
        }
        if (str.length() == 0) {
            baseContent = h.a.d(this, R$string.mini_two_in_one_secondt_check_content);
        }
        if (secondUserAgreementContent.length() == 0) {
            strD = h.a.d(this, R$string.mini_two_in_one_second_check_user_agreement);
            if (strD == null) {
                strD = str7;
            }
        } else {
            strD = secondUserAgreementContent;
        }
        if (str4.length() == 0) {
            String strD6 = h.a.d(this, R$string.mini_two_in_one_second_check_privacy_policy);
            secondPrivacyPolocyContent = strD6 == null ? str7 : strD6;
        }
        String str10 = secondUserAgreementUrl.length() != 0 ? secondUserAgreementUrl : "https://h5.dlight-app.com/outside/user-agreement?lang=";
        String str11 = secondPrivacyPolocyUrl.length() != 0 ? secondPrivacyPolocyUrl : "https://h5.dlight-app.com/outside/privacy-policy?lang=";
        if (baseContent != null) {
            try {
                B((TextView) this.f97e0.getValue(), baseContent, StringsKt__StringsKt.d0(baseContent, Utils.SEPARATOR, 0, false, 6, null), secondPrivacyPolocyContent, str11, StringsKt__StringsKt.j0(baseContent, Utils.SEPARATOR, 0, false, 6, null), StringsKt__StringsKt.d0(baseContent, "*", 0, false, 6, null), strD, str10, StringsKt__StringsKt.j0(baseContent, "*", 0, false, 6, null), true);
            } catch (Throwable unused4) {
            }
        }
        if (gdprNoticeContent.length() == 0) {
            strD2 = h.a.d(this, R$string.mini_two_in_one_gdpr_notice_content);
            if (strD2 == null) {
                strD2 = str7;
            }
        } else {
            strD2 = gdprNoticeContent;
        }
        if (highlightContent.length() == 0) {
            String strD7 = h.a.d(this, R$string.mini_two_in_one_gdpr_highlight);
            if (strD7 != null) {
                str7 = strD7;
            }
        } else {
            str7 = highlightContent;
        }
        TextView textView4 = (TextView) this.f98f0.getValue();
        if (textView4 != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) strD2);
            try {
                int iD2 = StringsKt__StringsKt.d0(strD2, str7, 0, false, 6, null);
                int length = str7.length() + iD2;
                if (length > iD2) {
                    spannableStringBuilder.setSpan(new StyleSpan(i12), iD2, length, 33);
                }
            } catch (Throwable unused5) {
            }
            textView4.setText(new SpannedString(spannableStringBuilder));
        }
        View view = (View) this.f99g0.getValue();
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: j.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    o000000.N(this.f67788a, view2);
                }
            });
        }
        View view2 = (View) this.f100h0.getValue();
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: j.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    o000000.M(this.f67789a, view3);
                }
            });
        }
        W();
        TextView textView5 = (TextView) this.X.getValue();
        if (textView5 != null) {
            textView5.setOnClickListener(new View.OnClickListener() { // from class: j.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    o000000.P(this.f67790a, view3);
                }
            });
        }
        TextView textView6 = (TextView) this.Y.getValue();
        if (textView6 == null) {
            return this;
        }
        textView6.setOnClickListener(new View.OnClickListener() { // from class: j.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                o000000.R(this.f67791a, view3);
            }
        });
        return this;
    }
}
