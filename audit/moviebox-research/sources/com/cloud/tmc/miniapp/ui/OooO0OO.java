package com.cloud.tmc.miniapp.ui;

import OooO0o0.OooOOO;
import OooO0o0.o0O0O00;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.cloud.tmc.ad.IAdManagerProxy;
import com.cloud.tmc.integration.ActivityHelper;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.activity.LoadStepAction;
import com.cloud.tmc.integration.activity.StartClientBundle;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.CSMKBean;
import com.cloud.tmc.integration.model.EntryInfo;
import com.cloud.tmc.integration.model.MiniAppConfigModel;
import com.cloud.tmc.integration.model.MiniAppUpdateMessageStore;
import com.cloud.tmc.integration.model.PrepareData;
import com.cloud.tmc.integration.performanceanalyse.screen.IScreenInspectProxy;
import com.cloud.tmc.integration.proxy.IUpdateLoadingStepProxy;
import com.cloud.tmc.integration.proxy.OfflineAppProxy;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.integration.proxy.StartActivityProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppLoadResult;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.structure.VirtualAppManager;
import com.cloud.tmc.integration.structure.node.AppNode;
import com.cloud.tmc.integration.ui.fragment.TmcFragment;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.LatestUseUtils;
import com.cloud.tmc.integration.utils.PopWindowManager;
import com.cloud.tmc.integration.utils.e0;
import com.cloud.tmc.integration.utils.f0;
import com.cloud.tmc.integration.utils.o;
import com.cloud.tmc.integration.utils.u;
import com.cloud.tmc.kernel.constants.MiniAppType;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.DefaultExtensionManager;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.kernel.proxy.network.INetWorkProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.LogEProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceImprovesProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.renderprocess.IOnRenderProcessGoneProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniapp.NewTaskManager;
import com.cloud.tmc.miniapp.R$anim;
import com.cloud.tmc.miniapp.R$dimen;
import com.cloud.tmc.miniapp.R$drawable;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniapp.TmcInitializer;
import com.cloud.tmc.miniapp.base.BaseAdapter;
import com.cloud.tmc.miniapp.base.MiniAppBaseActivity;
import com.cloud.tmc.miniapp.base.MiniAppBaseFragment;
import com.cloud.tmc.miniapp.bridge.PrivacyBridge;
import com.cloud.tmc.miniapp.dialog.BottomDialog$MenuItem;
import com.cloud.tmc.miniapp.point.CreateBottomMenuPoint;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prepare.steps.r;
import com.cloud.tmc.miniapp.proxy.IClientStarter;
import com.cloud.tmc.miniapp.ui.OooO0OO;
import com.cloud.tmc.miniapp.utils.MessageBubbleUtils;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.miniapp.widget.CapsuleView;
import com.cloud.tmc.miniapp.widget.StatusLayout;
import com.cloud.tmc.miniapp.widget.popupview.AddHomeCustom1PopUpWindowView;
import com.cloud.tmc.miniapp.widget.popupview.AddHomeCustom2PopUpWindowView;
import com.cloud.tmc.miniapp.widget.popupview.AddHomeCustomBottomTipView;
import com.cloud.tmc.miniapp.widget.popupview.AddHomeCustomTopTipView;
import com.cloud.tmc.miniapp.widget.popupview.MiniAddHomeTipDialogView;
import com.cloud.tmc.miniapp.widget.popupview.MsgBubblePopUpWindowView;
import com.cloud.tmc.miniutils.util.NetworkUtils;
import com.cloud.tmc.miniutils.util.j0;
import com.cloud.tmc.miniutils.util.x;
import com.cloud.tmc.miniutils.util.z;
import com.cloud.tmc.offline.download.OfflineManager;
import com.cloud.tmc.render.proxy.SessionUtilProxy;
import com.cloud.tmc.worker.WorkerManager;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import e0.q;
import e0.s;
import e0.t;
import h0.k;
import id.i;
import id.j;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import okhttp3.HttpUrl;
import p010OooOooo.o0000oo;
import p011Oooo00o.o00Ooo;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SourceDebugExtension
public class OooO0OO extends MiniAppBaseActivity implements i, j, r, IOnRenderProcessGoneProxy.a, rb.b, ua.f, StatusLayout.a, ua.c, OfflineAppProxy.b, ua.i {
    public static final /* synthetic */ int R = 0;
    public boolean A;
    public PrepareException B;
    public String C;
    public String D;
    public final Lazy E;
    public PrepareController F;
    public PrepareController G;
    public String H;
    public String I;
    public String J;
    public String K;
    public boolean L;
    public boolean M;
    public String N;
    public lb.g O;
    public final PopWindowManager.a P;
    public Runnable Q;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f31717b = LazyKt__LazyJVMKt.b(new OooOo());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final wa.a f31718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ActivityHelper f31719d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f31720f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f31721g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f31722h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f31723i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f31724j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f31725k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f31726l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f31727m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f31728n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public AtomicBoolean f31729o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f31730p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f31731q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Long f31732r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f31733s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f31734t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f31735u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f31736v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f31737w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f31738x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public uc.b f31739y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ArrayList<Function0<Unit>> f31740z;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO extends Lambda implements Function0<OooOOO> {

        /* JADX INFO: compiled from: source.java */
        public static final class a implements BaseAdapter.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ OooOOO f31741a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ OooO0OO f31742b;

            public a(OooOOO oooOOO, OooO0OO oooO0OO) {
                this.f31741a = oooOOO;
                this.f31742b = oooO0OO;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // com.cloud.tmc.miniapp.base.BaseAdapter.d
            public void onItemClick(RecyclerView recyclerView, View view, int i11) {
                AppModel appModel;
                AppModel appModel2;
                String configString = "1000391591855976448";
                if (u.a()) {
                    return;
                }
                List<BottomDialog$MenuItem> listV = this.f31741a.f65y.v();
                if (i11 >= listV.size()) {
                    return;
                }
                String id2 = listV.get(i11).getId();
                int iHashCode = id2.hashCode();
                String appId = null;
                appId = null;
                if (iHashCode == -517618225) {
                    if (id2.equals("permission")) {
                        try {
                            if (Intrinsics.b("1000886706715795456", this.f31742b.H)) {
                                OooO0OO oooO0OO = this.f31742b;
                                Bundle bundle = new Bundle();
                                bundle.putString("page", "pages/index/index");
                                bundle.putBoolean("extraMiniClearAllPages", true);
                                Unit unit = Unit.f68710a;
                                ByteAppManager.launchMiniAppForId$default(oooO0OO, "1000550440273772544", null, bundle, 4, null);
                            } else {
                                OooO0OO oooO0OO2 = this.f31742b;
                                Bundle bundle2 = new Bundle();
                                OooO0OO oooO0OO3 = this.f31742b;
                                bundle2.putString("page", "pages/settings/settings");
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("setting_miniappId%3D");
                                App app = oooO0OO3.f31719d.getApp();
                                if (app != null && (appModel = app.getAppModel()) != null) {
                                    appId = appModel.getAppId();
                                }
                                sb2.append(appId);
                                bundle2.putString("query", sb2.toString());
                                Unit unit2 = Unit.f68710a;
                                ByteAppManager.launchMiniAppForId$default(oooO0OO2, "1000550440273772544", null, bundle2, 4, null);
                            }
                            this.f31742b.s0().l();
                            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f31742b.H, PointAnalyseType.POINT_CLICK_AUTH, "");
                            return;
                        } catch (Throwable th2) {
                            TmcLogger.h("MiniAppActivity", th2);
                            return;
                        }
                    }
                    return;
                }
                if (iHashCode == -321864378) {
                    if (id2.equals("refreshApp")) {
                        try {
                            this.f31742b.R0();
                            return;
                        } catch (Throwable th3) {
                            TmcLogger.e("refresh fail!!,msg:" + th3);
                            return;
                        }
                    }
                    return;
                }
                if (iHashCode == -191501435) {
                    if (id2.equals("feedback")) {
                        OooO0OO oooO0OO4 = this.f31742b;
                        int i12 = OooO0OO.R;
                        oooO0OO4.s0().l();
                        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).recordForCommon(this.f31742b.H, "feedback_enter", new Bundle());
                        try {
                            configString = ((ConfigService) tc.a.a(ConfigService.class)).getConfigString("miniFeedbackId", "1000391591855976448");
                        } catch (Throwable unused) {
                        }
                        String str = configString;
                        OooO0OO oooO0OO5 = this.f31742b;
                        Bundle bundle3 = new Bundle();
                        OooO0OO oooO0OO6 = this.f31742b;
                        App app2 = oooO0OO6.f31719d.getApp();
                        bundle3.putString("feedback_miniappId", (app2 == null || (appModel2 = app2.getAppModel()) == null) ? null : appModel2.getAppId());
                        MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
                        App app3 = oooO0OO6.f31719d.getApp();
                        bundle3.putString("feedback_miniappVersion", miniAppLaunch.O(app3 != null ? app3.getAppModel() : null));
                        Unit unit3 = Unit.f68710a;
                        ByteAppManager.launchMiniAppForId$default(oooO0OO5, str, null, bundle3, 4, null);
                        return;
                    }
                    return;
                }
                if (iHashCode == 954925063 && id2.equals("message")) {
                    try {
                        if (MessageBubbleUtils.f31780a.b()) {
                            if (Intrinsics.b("1000886706715795456", this.f31742b.H)) {
                                OooO0OO oooO0OO7 = this.f31742b;
                                Bundle bundle4 = new Bundle();
                                bundle4.putString("page", "pages/notification/notification");
                                bundle4.putString("query", "entrance%3Dlayer");
                                Unit unit4 = Unit.f68710a;
                                ByteAppManager.launchMiniAppForId(oooO0OO7, "1000886706715795456", "", bundle4);
                                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f31742b.H, PointAnalyseType.POINT_CLICK_MESSAGE, "");
                            } else {
                                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f31742b.H, PointAnalyseType.POINT_CLICK_MC, "");
                                OooO0OO oooO0OO8 = this.f31742b;
                                Bundle bundle5 = new Bundle();
                                bundle5.putString("page", "pages/index/index");
                                bundle5.putBoolean("extraMiniClearAllPages", true);
                                Unit unit5 = Unit.f68710a;
                                ByteAppManager.launchMiniAppForId(oooO0OO8, "1000886706715795456", "120010", bundle5);
                            }
                            OooO0OO context = this.f31742b;
                            Intrinsics.g(context, "context");
                            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putBoolean(context, "miniMsgKvId", "miniNewMsgStatus", false);
                            this.f31742b.s0().l();
                        }
                    } catch (Throwable th4) {
                        TmcLogger.h("MiniAppActivity", th4);
                    }
                }
            }
        }

        public OooO() {
            super(0);
        }

        public static final void OooO00o(OooO0OO this$0, View view) {
            AppModel appModel;
            Intrinsics.g(this$0, "this$0");
            Integer numValueOf = view != null ? Integer.valueOf(view.getId()) : null;
            int i11 = R$id.tv_btn;
            String str = "";
            if (numValueOf != null && numValueOf.intValue() == i11) {
                int i12 = OooO0OO.R;
                this$0.s0().l();
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this$0.H, PointAnalyseType.POINT_MORE_EXIT, "");
                return;
            }
            int i13 = R$id.layer_app_brand;
            if (numValueOf != null && numValueOf.intValue() == i13) {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this$0.H, PointAnalyseType.POINT_ENTER_DEVELOP, "");
                App app = this$0.f31719d.getApp();
                if (app == null || (appModel = app.getAppModel()) == null) {
                    return;
                }
                this$0.s0().l();
                String appId = appModel.getAppId();
                if (appId != null) {
                    AppBrandProfileActivity.a aVar = AppBrandProfileActivity.f31662t;
                    Bundle bundle = new Bundle();
                    try {
                        String name = appModel.getName();
                        if (name == null) {
                            name = "";
                        }
                        bundle.putString("miniAppName", name);
                        String strO = MiniAppLaunch.f31784a.O(appModel);
                        if (strO != null) {
                            str = strO;
                        }
                        bundle.putString("version", str);
                        bundle.putString("appinfoDesc", appModel.getDesc());
                        bundle.putString("appinfoLogo", appModel.getLogo());
                        bundle.putString("appinfoRegisterType", appModel.getRegisterType());
                        bundle.putString("appinfoDeveloper", appModel.getDeveloper());
                        bundle.putLong("appinfoReleaseTime", appModel.getReleaseTime());
                    } catch (Throwable unused) {
                    }
                    aVar.a(this$0, appId, bundle);
                }
            }
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: OooO00o, reason: merged with bridge method [inline-methods] */
        public final OooOOO invoke() {
            Object next;
            OooOOO oooOOO = new OooOOO(OooO0OO.this);
            final OooO0OO oooO0OO = OooO0OO.this;
            boolean z11 = false;
            boolean z12 = false;
            int i11 = 24;
            DefaultConstructorMarker defaultConstructorMarker = null;
            ArrayList arrayListH = kotlin.collections.g.h(Intrinsics.b("1000886706715795456", oooO0OO.H) ? new BottomDialog$MenuItem("message", R$drawable.mini_ic_message, id.h.a.d(oooOOO, R$string.mini_dialog_message), false, false, 24, null) : new BottomDialog$MenuItem("message", R$drawable.mini_icon_bottom_dialog_btn_notification, id.h.a.d(oooOOO, R$string.mini_miniapp_center), false, false, 24, null), new BottomDialog$MenuItem("permission", R$drawable.mini_ic_permission_icon, id.h.a.d(oooOOO, R$string.mini_permission_manager_title), z11, z12, i11, defaultConstructorMarker), new BottomDialog$MenuItem("feedback", R$drawable.mini_ic_feedback, id.h.a.d(oooOOO, R$string.mini_dialog_feedback), z11, z12, i11, defaultConstructorMarker), new BottomDialog$MenuItem("refreshApp", R$drawable.mini_ic_refresh, id.h.a.d(oooOOO, R$string.mini_dialog_reopen), z11, z12, i11, defaultConstructorMarker));
            try {
                if (!MessageBubbleUtils.f31780a.b()) {
                    Iterator it = arrayListH.iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!Intrinsics.b(((BottomDialog$MenuItem) next).getId(), "message"));
                    BottomDialog$MenuItem bottomDialog$MenuItem = (BottomDialog$MenuItem) next;
                    if (bottomDialog$MenuItem != null) {
                        arrayListH.remove(bottomDialog$MenuItem);
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.h("BottomDialog", th2);
            }
            oooOOO.f65y.x(arrayListH);
            oooOOO.A = new a(oooOOO, oooO0OO);
            id.d.a.b(oooOOO, new View.OnClickListener() { // from class: qd.n0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OooO0OO.OooO.OooO00o(oooO0OO, view);
                }
            }, R$id.tv_btn, R$id.layer_app_brand);
            return oooOOO;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO00o extends Lambda implements Function0<MiniAddHomeTipDialogView> {
        public OooO00o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public MiniAddHomeTipDialogView invoke() {
            return (MiniAddHomeTipDialogView) OooO0OO.this.findViewById(R$id.add_home_dialog_view);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 extends Lambda implements Function0<CapsuleView> {
        public OooO0O0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public CapsuleView invoke() {
            return (CapsuleView) OooO0OO.this.findViewById(R$id.capsule);
        }
    }

    /* JADX INFO: renamed from: com.cloud.tmc.miniapp.ui.OooO0OO$OooO0OO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0346OooO0OO extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int OooO00o;
        public final /* synthetic */ OooO0OO OooO0O0;
        public final /* synthetic */ String OooO0OO;

        /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
        public final /* synthetic */ String f31743OooO0Oo;

        /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
        public final /* synthetic */ long f31744OooO0o0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0346OooO0OO(int i11, OooO0OO oooO0OO, String str, String str2, long j11) {
            super(0);
            this.OooO00o = i11;
            this.OooO0O0 = oooO0OO;
            this.OooO0OO = str;
            this.f31743OooO0Oo = str2;
            this.f31744OooO0o0 = j11;
        }

        public static final void OooO00o(OooO0OO this$0) {
            Intrinsics.g(this$0, "this$0");
            int i11 = OooO0OO.R;
            AddHomeCustom1PopUpWindowView addHomeCustom1PopUpWindowViewA0 = this$0.A0();
            if (addHomeCustom1PopUpWindowViewA0 != null) {
                xb.i.c(addHomeCustom1PopUpWindowViewA0);
            }
        }

        public static final void OooO00o(final OooO0OO this$0, String str, String str2, long j11) {
            Intrinsics.g(this$0, "this$0");
            int i11 = OooO0OO.R;
            AddHomeCustom1PopUpWindowView addHomeCustom1PopUpWindowViewA0 = this$0.A0();
            if (addHomeCustom1PopUpWindowViewA0 != null) {
                xb.i.e(addHomeCustom1PopUpWindowViewA0.OooO00o(str).OooO00o(this$0.H, str2));
            }
            this$0.postDelayed(this$0.A0(), j11, new Runnable() { // from class: qd.q0
                @Override // java.lang.Runnable
                public final void run() {
                    OooO0OO.C0346OooO0OO.OooO00o(this$0);
                }
            });
        }

        public static final void OooO0O0(OooO0OO this$0) {
            Intrinsics.g(this$0, "this$0");
            int i11 = OooO0OO.R;
            AddHomeCustom2PopUpWindowView addHomeCustom2PopUpWindowViewC0 = this$0.C0();
            if (addHomeCustom2PopUpWindowViewC0 != null) {
                xb.i.c(addHomeCustom2PopUpWindowViewC0);
            }
        }

        public static final void OooO0O0(final OooO0OO this$0, String str, String str2, long j11) {
            Intrinsics.g(this$0, "this$0");
            int i11 = OooO0OO.R;
            AddHomeCustom2PopUpWindowView addHomeCustom2PopUpWindowViewC0 = this$0.C0();
            if (addHomeCustom2PopUpWindowViewC0 != null) {
                xb.i.e(addHomeCustom2PopUpWindowViewC0.OooO00o(str).OooO00o(this$0.H, str2));
            }
            this$0.postDelayed(this$0.C0(), j11, new Runnable() { // from class: qd.r0
                @Override // java.lang.Runnable
                public final void run() {
                    OooO0OO.C0346OooO0OO.OooO0O0(this$0);
                }
            });
        }

        public final void OooO00o() {
            int i11 = this.OooO00o;
            if (i11 == 1) {
                OooO0OO oooO0OO = this.OooO0O0;
                oooO0OO.removeCallbacksAndMessages(oooO0OO.A0());
                final OooO0OO oooO0OO2 = this.OooO0O0;
                final String str = this.OooO0OO;
                final String str2 = this.f31743OooO0Oo;
                final long j11 = this.f31744OooO0o0;
                oooO0OO2.post(new Runnable() { // from class: qd.p0
                    @Override // java.lang.Runnable
                    public final void run() {
                        OooO0OO.C0346OooO0OO.OooO00o(oooO0OO2, str, str2, j11);
                    }
                });
                return;
            }
            if (i11 != 2) {
                return;
            }
            OooO0OO oooO0OO3 = this.OooO0O0;
            oooO0OO3.removeCallbacksAndMessages(oooO0OO3.C0());
            final OooO0OO oooO0OO4 = this.OooO0O0;
            final String str3 = this.OooO0OO;
            final String str4 = this.f31743OooO0Oo;
            final long j12 = this.f31744OooO0o0;
            oooO0OO4.post(new Runnable() { // from class: qd.o0
                @Override // java.lang.Runnable
                public final void run() {
                    OooO0OO.C0346OooO0OO.OooO0O0(oooO0OO4, str3, str4, j12);
                }
            });
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            OooO00o();
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public /* synthetic */ class OooO0o extends FunctionReferenceImpl implements Function3<String, String, String, Unit> {
        public OooO0o(Object obj) {
            super(3, obj, OooO0OO.class, "showOpenAppDialog", "showOpenAppDialog(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public Unit invoke(String str, String str2, String str3) {
            String p11 = str;
            String p12 = str2;
            String p13 = str3;
            Intrinsics.g(p11, "p0");
            Intrinsics.g(p12, "p1");
            Intrinsics.g(p13, "p2");
            OooO0OO oooO0OO = (OooO0OO) this.receiver;
            if (!oooO0OO.A) {
                o0O0O00 o0o0o00 = new o0O0O00(oooO0OO, p13);
                try {
                    ImageView imageView = (ImageView) o0o0o00.f137v.getValue();
                    if (imageView != null) {
                        ImageLoaderProxy imageLoaderProxy = (ImageLoaderProxy) tc.a.a(ImageLoaderProxy.class);
                        Context context = o0o0o00.f135t;
                        if (p11 == null) {
                            p11 = "";
                        }
                        imageLoaderProxy.loadImgRoundCorners(context, new File(p11), imageView, x.a(12.0f), R$drawable.mini_icon_placeholder);
                    }
                } catch (Throwable unused) {
                }
                o0o0o00.e(new t(oooO0OO)).d(new e0.x(oooO0OO)).q();
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOO0O extends Lambda implements Function0<Unit> {
        public OooOO0O() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            AppModel appModel;
            OooO0OO activity = OooO0OO.this;
            if (!activity.isLoadStatusLoadingOrError()) {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(activity.H, PointAnalyseType.POINT_MORE_ENTER, "");
                App app = activity.f31719d.getApp();
                if (app != null && (appModel = app.getAppModel()) != null) {
                    activity.s0().q();
                    OooOOO oooOOOS0 = activity.s0();
                    oooOOOS0.getClass();
                    Intrinsics.g(appModel, "appModel");
                    if (TextUtils.isEmpty(appModel.getDeveloper())) {
                        TextView textViewX = oooOOOS0.x();
                        if (textViewX != null) {
                            textViewX.setVisibility(8);
                        }
                    } else {
                        TextView textViewX2 = oooOOOS0.x();
                        if (textViewX2 != null) {
                            textViewX2.setVisibility(0);
                        }
                        TextView textViewX3 = oooOOOS0.x();
                        if (textViewX3 != null) {
                            textViewX3.setText(appModel.getDeveloper());
                        }
                    }
                    TextView textView = (TextView) oooOOOS0.f61u.getValue();
                    if (textView != null) {
                        textView.setText(appModel.getName());
                    }
                    oooOOOS0.f66z = appModel.getAppId();
                    AppCompatImageView appCompatImageView = (AppCompatImageView) oooOOOS0.f60t.getValue();
                    if (appCompatImageView != null) {
                        ImageLoaderProxy imageLoaderProxy = (ImageLoaderProxy) tc.a.a(ImageLoaderProxy.class);
                        Context context = oooOOOS0.f27a;
                        String logo = appModel.getLogo();
                        String str = logo == null ? "" : logo;
                        int iB = xb.a.b(6);
                        int i11 = R$drawable.drawable_app_icon_place_holder;
                        imageLoaderProxy.loadImgRoundCorners(context, str, appCompatImageView, iB, i11, i11);
                    }
                    OooOOO oooOOOS1 = activity.s0();
                    oooOOOS1.getClass();
                    Intrinsics.g(activity, "activity");
                    ((CreateBottomMenuPoint) ib.a.b(CreateBottomMenuPoint.class).d()).buildBottomDialog(activity, oooOOOS1);
                }
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOOO0 extends Lambda implements Function0<Unit> {
        public OooOOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            OooO0OO.this.i0(false);
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOo extends Lambda implements Function0<StatusLayout> {
        public OooOo() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public StatusLayout invoke() {
            return (StatusLayout) OooO0OO.this.findViewById(R$id.sl_status);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOo00 extends Lambda implements Function0<d0.a> {
        public static final OooOo00 OooO00o = new OooOo00();

        public OooOo00() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public d0.a invoke() {
            return new d0.a();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class Oooo0 extends Lambda implements Function0<AddHomeCustomBottomTipView> {
        public Oooo0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AddHomeCustomBottomTipView invoke() {
            return (AddHomeCustomBottomTipView) OooO0OO.this.findViewById(R$id.pv_add_home_bottom_tip);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class Oooo000 extends Lambda implements Function0<String> {
        public Oooo000() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public String invoke() {
            return OooO0OO.this.H + '_' + OooO0OO.this.f31733s;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a implements i0.c {
        public a() {
        }

        @Override // i0.c
        public void d(String appId, String str) {
            int configInt;
            if (appId != null) {
                OooO0OO context = OooO0OO.this;
                if (str == null) {
                    str = "";
                }
                context.getClass();
                Intrinsics.g(str, "<set-?>");
                context.f31731q = str;
                MessageBubbleUtils messageBubbleUtils = MessageBubbleUtils.f31780a;
                String miniAppPopWindowToken = context.y0();
                PopWindowManager.a controller = context.P;
                Intrinsics.g(context, "context");
                Intrinsics.g(appId, "appId");
                Intrinsics.g(miniAppPopWindowToken, "miniAppPopWindowToken");
                Intrinsics.g(controller, "controller");
                if (appId.length() == 0) {
                    return;
                }
                TmcLogger.c("MessageBubbleUtils", "checkAndShowMsgBubble");
                if (messageBubbleUtils.c(appId)) {
                    return;
                }
                long j11 = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getLong(context, appId, "showMsgBubbleTime");
                TmcLogger.c("MessageBubbleUtils", "checkAndShowMsgBubble showAddHomeTime->" + j11 + " currentTimeMillis->" + System.currentTimeMillis() + " diff ->" + (System.currentTimeMillis() - j11));
                int configInt2 = 43200000;
                try {
                    configInt2 = ((ConfigService) tc.a.a(ConfigService.class)).getConfigInt("miniShowMsgBubbleInterval", 43200000);
                } catch (Throwable th2) {
                    TmcLogger.h("MessageBubbleUtils", th2);
                }
                if (System.currentTimeMillis() - j11 >= configInt2 && (configInt = ((ConfigService) tc.a.a(ConfigService.class)).getConfigInt("miniShowMsgBubbleDelay", 60000)) > 0) {
                    TmcLogger.c("MessageBubbleUtils", "addPopWindow msg bubble:->" + configInt);
                    PopWindowManager.f31020a.a(miniAppPopWindowToken, new PopWindowManager.PopWindowData(appId, (long) configInt, 2, controller, false, 16, null));
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements StatusLayout.b {
        public b() {
        }

        @Override // com.cloud.tmc.miniapp.widget.StatusLayout.b
        public void a(StatusLayout statusLayout) {
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            String str = OooO0OO.this.H;
            Bundle bundle = new Bundle();
            bundle.putInt("type", 1);
            Unit unit = Unit.f68710a;
            performanceAnalyseProxy.recordForCommon(str, "uncon_retry_click", bundle);
            OooO0OO.h0(OooO0OO.this, false, null, 3, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements StatusLayout.b {
        public c() {
        }

        @Override // com.cloud.tmc.miniapp.widget.StatusLayout.b
        public void a(StatusLayout statusLayout) {
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            String str = OooO0OO.this.H;
            Bundle bundle = new Bundle();
            bundle.putInt("type", 3);
            Unit unit = Unit.f68710a;
            performanceAnalyseProxy.recordForCommon(str, "uncon_retry_click", bundle);
            OooO0OO.h0(OooO0OO.this, false, null, 3, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements StatusLayout.b {
        public d() {
        }

        @Override // com.cloud.tmc.miniapp.widget.StatusLayout.b
        public void a(StatusLayout statusLayout) {
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            String str = OooO0OO.this.H;
            Bundle bundle = new Bundle();
            bundle.putInt("type", 4);
            Unit unit = Unit.f68710a;
            performanceAnalyseProxy.recordForCommon(str, "uncon_retry_click", bundle);
            OooO0OO.h0(OooO0OO.this, false, null, 3, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e implements PopWindowManager.a {
        public e() {
        }

        @Override // com.cloud.tmc.integration.utils.PopWindowManager.a
        public void a(PopWindowManager.PopWindowData bean) {
            Intrinsics.g(bean, "bean");
            TmcLogger.c("MiniAppActivity", "onRefresh:" + (System.currentTimeMillis() - OooO0OO.this.f31733s));
            OooO0OO.this.k0(bean.getDelayTime() - (System.currentTimeMillis() - OooO0OO.this.f31733s));
        }

        @Override // com.cloud.tmc.integration.utils.PopWindowManager.a
        public void show(String appId) {
            Intrinsics.g(appId, "appId");
            TmcLogger.c("MiniAppActivity", "msgBubbleToast");
            try {
                if (OooO0OO.this.getMResumed()) {
                    OooO0OO.this.S0();
                }
            } catch (Throwable th2) {
                TmcLogger.h("MiniAppActivity", th2);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f implements ua.e {
        public f() {
        }

        @Override // ua.e
        public void a() {
            TmcLogger.c("MiniAppActivity", "showAsyncStatusLoading");
            OooO0OO.this.T0();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g implements ua.d {
        @Override // ua.d
        public boolean a(String path, AppModel appModel, Context context, Bundle startParams, Bundle sceneParams, ua.j loadCheckCallback) {
            Intrinsics.g(path, "path");
            Intrinsics.g(appModel, "appModel");
            Intrinsics.g(context, "context");
            Intrinsics.g(startParams, "startParams");
            Intrinsics.g(sceneParams, "sceneParams");
            Intrinsics.g(loadCheckCallback, "loadCheckCallback");
            return o00Ooo.f(path, appModel, context, startParams, sceneParams, loadCheckCallback);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class h implements uc.c {
        public h() {
        }

        @Override // uc.c
        public boolean O(uc.a aVar) {
            com.cloud.tmc.integration.ui.fragment.a aVarK;
            Set<TmcFragment> setJ;
            OooO0OO oooO0OO = OooO0OO.this;
            if (!oooO0OO.f31729o.getAndSet(true)) {
                App app = oooO0OO.f31719d.getApp();
                tb.b appContext = app != null ? app.getAppContext() : null;
                com.cloud.tmc.integration.structure.app.b bVar = appContext instanceof com.cloud.tmc.integration.structure.app.b ? (com.cloud.tmc.integration.structure.app.b) appContext : null;
                if (bVar != null && (aVarK = bVar.k()) != null && (setJ = aVarK.j()) != null) {
                    int i11 = 0;
                    for (Object obj : setJ) {
                        int i12 = i11 + 1;
                        if (i11 < 0) {
                            kotlin.collections.g.u();
                        }
                        TmcFragment tmcFragment = (TmcFragment) obj;
                        if (i11 == setJ.size() - 1) {
                            break;
                        }
                        if (tmcFragment != null) {
                            Intrinsics.f(tmcFragment, "tmcFragment");
                            if (tmcFragment instanceof o0000oo) {
                                o0000oo o0000ooVar = (o0000oo) tmcFragment;
                                if (!o0000ooVar.U) {
                                    o0000ooVar.U = true;
                                    MiniAppBaseFragment miniAppBaseFragment = tmcFragment instanceof MiniAppBaseFragment ? (MiniAppBaseFragment) tmcFragment : null;
                                    if (miniAppBaseFragment != null) {
                                        MiniAppBaseFragment.V0(miniAppBaseFragment, null, 1, null);
                                    }
                                }
                            }
                        }
                        i11 = i12;
                    }
                }
            }
            uc.b bVar2 = OooO0OO.this.f31739y;
            if (bVar2 != null) {
                StringBuilder sbA = hd.j.a("resendH5PageStack_");
                App app2 = OooO0OO.this.f31719d.getApp();
                sbA.append(app2 != null ? app2.getAppId() : null);
                bVar2.c(sbA.toString(), this);
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class o000oOoO extends Lambda implements Function0<AddHomeCustom1PopUpWindowView> {
        public o000oOoO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AddHomeCustom1PopUpWindowView invoke() {
            return (AddHomeCustom1PopUpWindowView) OooO0OO.this.findViewById(R$id.pv_add_home_custom1);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class o00O0O extends Lambda implements Function0<AddHomeCustomTopTipView> {
        public o00O0O() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AddHomeCustomTopTipView invoke() {
            return (AddHomeCustomTopTipView) OooO0OO.this.findViewById(R$id.pv_add_home_top_tip);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class o00Oo0 extends Lambda implements Function0<MsgBubblePopUpWindowView> {
        public o00Oo0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public MsgBubblePopUpWindowView invoke() {
            return (MsgBubblePopUpWindowView) OooO0OO.this.findViewById(R$id.pv_msg_bubble);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class o0OoOo0 extends Lambda implements Function0<AddHomeCustom2PopUpWindowView> {
        public o0OoOo0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AddHomeCustom2PopUpWindowView invoke() {
            return (AddHomeCustom2PopUpWindowView) OooO0OO.this.findViewById(R$id.pv_add_home_custom2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class oo000o extends Lambda implements Function0<Unit> {
        public final /* synthetic */ EntryInfo OooO00o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public oo000o(EntryInfo entryInfo) {
            super(0);
            this.OooO00o = entryInfo;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            EntryInfo entryInfo = this.OooO00o;
            LatestUseUtils.a(entryInfo.appId, entryInfo.title, entryInfo.iconUrl, entryInfo.desc, entryInfo.getClassificationNames(), this.OooO00o.getExclusiveLogoUrl(), 0);
            return Unit.f68710a;
        }
    }

    public OooO0OO() {
        wa.a aVar = new wa.a();
        this.f31718c = aVar;
        this.f31719d = new ActivityHelper(this, aVar);
        this.f31720f = LazyKt__LazyJVMKt.b(new OooO0O0());
        this.f31721g = LazyKt__LazyJVMKt.b(new o000oOoO());
        this.f31722h = LazyKt__LazyJVMKt.b(new o0OoOo0());
        this.f31723i = LazyKt__LazyJVMKt.b(new o00O0O());
        this.f31724j = LazyKt__LazyJVMKt.b(new Oooo0());
        this.f31725k = LazyKt__LazyJVMKt.b(new o00Oo0());
        this.f31726l = LazyKt__LazyJVMKt.b(new OooO00o());
        this.f31727m = true;
        this.f31728n = true;
        this.f31729o = new AtomicBoolean(false);
        this.f31731q = "";
        this.f31733s = System.currentTimeMillis();
        this.f31737w = LazyKt__LazyJVMKt.b(new Oooo000());
        this.f31738x = LazyKt__LazyJVMKt.b(OooOo00.OooO00o);
        this.f31740z = new ArrayList<>();
        this.C = "";
        this.D = "";
        this.E = LazyKt__LazyJVMKt.b(new OooO());
        this.N = "";
        this.P = new e();
    }

    public static final void B0(OooO0OO this$0) {
        Intrinsics.g(this$0, "this$0");
        PopWindowManager.f31020a.d(this$0.y0(), System.currentTimeMillis() - this$0.f31733s);
    }

    public static final void D0(OooO0OO this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.showLoading();
    }

    public static final void F0(OooO0OO this$0) {
        Intrinsics.g(this$0, "this$0");
        PrepareController prepareControllerCreatePrepareController = ((IClientStarter) tc.a.a(IClientStarter.class)).createPrepareController(this$0.O, new h.c(this$0.O, this$0));
        this$0.F = prepareControllerCreatePrepareController;
        if (prepareControllerCreatePrepareController != null) {
            prepareControllerCreatePrepareController.start();
        }
    }

    public static final void J0() {
    }

    public static final void O0() {
        try {
            o oVar = o.f31082a;
            if (!oVar.c().isEmpty()) {
                Iterator<T> it = oVar.c().iterator();
                while (it.hasNext()) {
                    o.f31082a.f().remove((String) it.next());
                }
                o.f31082a.c().clear();
            }
        } catch (Throwable th2) {
            TmcLogger.g("MiniAppActivity", "onDestroy", th2);
        }
    }

    public static final void Q(OooO0OO this$0) {
        Intrinsics.g(this$0, "this$0");
        MsgBubblePopUpWindowView msgBubblePopUpWindowViewH0 = this$0.H0();
        if (msgBubblePopUpWindowViewH0 != null) {
            xb.i.c(msgBubblePopUpWindowViewH0);
        }
    }

    public static final void S(int i11, OooO0OO this$0) {
        MsgBubblePopUpWindowView msgBubblePopUpWindowViewH0;
        MiniAddHomeTipDialogView miniAddHomeTipDialogViewQ0;
        AddHomeCustomBottomTipView addHomeCustomBottomTipViewO;
        Intrinsics.g(this$0, "this$0");
        if (i11 > 81) {
            try {
                if (this$0.H0() != null && (msgBubblePopUpWindowViewH0 = this$0.H0()) != null) {
                    xb.i.c(msgBubblePopUpWindowViewH0);
                }
                AddHomeCustomTopTipView addHomeCustomTopTipViewE0 = this$0.E0();
                if (addHomeCustomTopTipViewE0 != null) {
                    xb.i.c(addHomeCustomTopTipViewE0);
                }
                AddHomeCustom1PopUpWindowView addHomeCustom1PopUpWindowViewA0 = this$0.A0();
                if (addHomeCustom1PopUpWindowViewA0 != null) {
                    xb.i.c(addHomeCustom1PopUpWindowViewA0);
                }
                AddHomeCustom2PopUpWindowView addHomeCustom2PopUpWindowViewC0 = this$0.C0();
                if (addHomeCustom2PopUpWindowViewC0 != null) {
                    xb.i.c(addHomeCustom2PopUpWindowViewC0);
                }
            } catch (Throwable unused) {
                return;
            }
        }
        if (i11 > 82 && (addHomeCustomBottomTipViewO = this$0.O()) != null) {
            xb.i.c(addHomeCustomBottomTipViewO);
        }
        if (i11 <= 83 || (miniAddHomeTipDialogViewQ0 = this$0.q0()) == null) {
            return;
        }
        miniAddHomeTipDialogViewQ0.OooO00o(false);
    }

    public static final void U(EntryInfo entryInfo, OooO0OO this$0) {
        String string;
        Unit unit;
        Intrinsics.g(this$0, "this$0");
        if (entryInfo != null) {
            try {
                string = this$0.getString(R$string.dialog_loading_tv);
            } catch (Throwable unused) {
                string = "Loading...";
            }
            Intrinsics.f(string, "try {\n                  …ing...\"\n                }");
            String str = entryInfo.title;
            if (str != null) {
                string = str;
            }
            this$0.showLoadingLogo(string, xb.e.a(entryInfo.iconUrl, ""));
            this$0.U0(entryInfo.appId, new oo000o(entryInfo));
            unit = Unit.f68710a;
        } else {
            unit = null;
        }
        if (unit == null) {
            try {
                String string2 = this$0.getString(R$string.dialog_loading_tv);
                Intrinsics.f(string2, "getString(R.string.dialog_loading_tv)");
                this$0.showLoadingLogo(string2, "");
            } catch (Throwable th2) {
                TmcLogger.h("MiniAppActivity", th2);
            }
        }
    }

    public static final void V(AppNode appNode) {
        Intrinsics.g(appNode, "$appNode");
        TmcLogger.c("MiniAppActivity", "startAsyncApp backToPagePath -> " + appNode.getBackToPagePath());
        String backToPagePath = appNode.getBackToPagePath();
        Bundle startParams = appNode.getStartParams();
        Bundle sceneParams = appNode.getSceneParams();
        sceneParams.putString("navigationType", "startAsyncApp");
        Unit unit = Unit.f68710a;
        appNode.relaunchToUrl(backToPagePath, startParams, sceneParams);
        appNode.setBackToPagePath("");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void X(PrepareException prepareException, OooO0OO this$0) {
        Bundle bundle;
        String string;
        String code;
        Intrinsics.g(this$0, "this$0");
        Object code2 = null;
        Integer numValueOf = (prepareException == null || (code = prepareException.getCode()) == null) ? null : Integer.valueOf(Integer.parseInt(code));
        int i11 = Integer.parseInt("3");
        String str = "0";
        if (numValueOf != null && numValueOf.intValue() == i11) {
            String code3 = prepareException != null ? prepareException.getCode() : null;
            if (code3 == null) {
                code3 = "0";
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31208e0, PrepareException.codeToDes(code3));
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            String str2 = this$0.H;
            PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_APP_CHAIN_FAIL;
            performanceAnalyseProxy.record(str2, pointAnalyseType, "appOpenFail", bundle2);
            new cb.a(bundle2).f(this$0.f31718c);
            Bundle extras = this$0.getIntent().getExtras();
            Object obj = extras != null ? extras.get("startBundle") : null;
            StartClientBundle startClientBundle = obj instanceof StartClientBundle ? (StartClientBundle) obj : null;
            if (startClientBundle != null && (bundle = startClientBundle.startParams) != null && (string = bundle.getString("extraData")) != null) {
                Map mapG = TmcGsonUtils.g(string);
                String str3 = mapG != null ? (String) mapG.get("logo") : null;
                String str4 = mapG != null ? (String) mapG.get("name") : null;
                String str5 = mapG != null ? (String) mapG.get(CampaignEx.JSON_KEY_DESC) : null;
                this$0.C = str3 == null ? "" : str3;
                this$0.D = str4 != null ? str4 : "";
                if (str3 == null || str3.length() <= 0 || NetworkUtils.r()) {
                    i.a.s(this$0, new e0.r(this$0), 0, null, this$0.H, k.a(this$0), 6, null);
                } else {
                    code2 = prepareException != null ? prepareException.getCode() : null;
                    if (code2 != null) {
                        Intrinsics.f(code2, "exception?.code ?: \"0\"");
                        str = code2;
                    }
                    Bundle bundle3 = new Bundle();
                    bundle3.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31208e0, PrepareException.codeToDes(str));
                    ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this$0.H, pointAnalyseType, "appOpenFail", bundle3);
                    new cb.a(bundle3).f(this$0.f31718c);
                    this$0.showCustomErrorLayout(str4, str3, str5, new q(this$0), this$0.H, k.a(this$0));
                }
                code2 = Unit.f68710a;
            }
            if (code2 == null) {
                i.a.s(this$0, new s(this$0), 0, null, this$0.H, k.a(this$0), 6, null);
                return;
            }
            return;
        }
        int i12 = Integer.parseInt("4");
        if (numValueOf != null && numValueOf.intValue() == i12) {
            code2 = prepareException != null ? prepareException.getCode() : null;
            str = code2 != null ? code2 : "0";
            Bundle bundle4 = new Bundle();
            bundle4.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31208e0, PrepareException.codeToDes(str));
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this$0.H, PointAnalyseType.POINT_APP_CHAIN_FAIL, "appOpenFail", bundle4);
            new cb.a(bundle4).f(this$0.f31718c);
            if (NetworkUtils.r()) {
                i.a.v(this$0, this$0.new c(), 0, null, this$0.H, k.a(this$0), 6, null);
                return;
            } else {
                i.a.s(this$0, this$0.new b(), 0, null, this$0.H, k.a(this$0), 6, null);
                return;
            }
        }
        if (numValueOf != null && numValueOf.intValue() == 9) {
            code2 = prepareException != null ? prepareException.getCode() : null;
            str = code2 != null ? code2 : "0";
            Bundle bundle5 = new Bundle();
            bundle5.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31208e0, PrepareException.codeToDes(str));
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this$0.H, PointAnalyseType.POINT_APP_CHAIN_FAIL, "appOpenFail", bundle5);
            new cb.a(bundle5).f(this$0.f31718c);
            Integer viewThemeMode = this$0.getViewThemeMode();
            i.a.l(this$0, (viewThemeMode != null && viewThemeMode.intValue() == 2) ? R$drawable.mini_ic_closed_normal_mode : R$drawable.mini_ic_closed, R$string.loading_error_miniapp_closed, null, null, null, 24, null);
            return;
        }
        if (numValueOf == null || numValueOf.intValue() != 30004) {
            try {
                this$0.Y(prepareException, k.a(this$0));
                return;
            } catch (Throwable th2) {
                TmcLogger.h("MiniAppActivity", th2);
                this$0.Y(prepareException, k.a(this$0));
                return;
            }
        }
        code2 = prepareException != null ? prepareException.getCode() : null;
        str = code2 != null ? code2 : "0";
        Bundle bundle6 = new Bundle();
        bundle6.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31208e0, PrepareException.codeToDes(str));
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this$0.H, PointAnalyseType.POINT_APP_CHAIN_FAIL, "appOpenFail", bundle6);
        new cb.a(bundle6).f(this$0.f31718c);
        Integer viewThemeMode2 = this$0.getViewThemeMode();
        i.a.l(this$0, (viewThemeMode2 != null && viewThemeMode2.intValue() == 2) ? R$drawable.mini_ic_no_available_normal_mode : R$drawable.mini_ic_no_available, R$string.loading_error_miniapp_no_longer_available, null, null, null, 24, null);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0083  */
    /* JADX WARN: Code duplicated, block: B:37:0x008b  */
    /* JADX WARN: Code duplicated, block: B:38:0x008c A[Catch: all -> 0x007f, TryCatch #4 {all -> 0x007f, blocks: (B:30:0x007a, B:35:0x0085, B:38:0x008c, B:40:0x0092, B:41:0x009b), top: B:72:0x007a }] */
    /* JADX WARN: Code duplicated, block: B:40:0x0092 A[Catch: all -> 0x007f, TryCatch #4 {all -> 0x007f, blocks: (B:30:0x007a, B:35:0x0085, B:38:0x008c, B:40:0x0092, B:41:0x009b), top: B:72:0x007a }] */
    /* JADX WARN: Code duplicated, block: B:41:0x009b A[Catch: all -> 0x007f, TRY_LEAVE, TryCatch #4 {all -> 0x007f, blocks: (B:30:0x007a, B:35:0x0085, B:38:0x008c, B:40:0x0092, B:41:0x009b), top: B:72:0x007a }] */
    public static final void Z(final OooO0OO this$0) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.showComplete()) {
            String str = this$0.H;
            if (str != null) {
                this$0.f31733s = System.currentTimeMillis();
                String appId = null;
                f0.l(f0.f31050a, str, null, 2, null);
                App app = this$0.f31719d.getApp();
                if (app != null) {
                    app.setAppStartTime(this$0.f31733s);
                }
                App app2 = this$0.f31719d.getApp();
                if (app2 != null) {
                    app2.setAddhomeShowCallback(this$0);
                }
                App app3 = this$0.f31719d.getApp();
                if (app3 != null && !this$0.L) {
                    AppNode appNode = app3 instanceof AppNode ? (AppNode) app3 : null;
                    if (appNode != null) {
                        appNode.setAsyncLaunchStatus(true);
                    }
                }
                this$0.w0().a();
                MessageBubbleUtils messageBubbleUtils = MessageBubbleUtils.f31780a;
                try {
                    if (messageBubbleUtils.e() && MiniAppConfigHelper.f30370a.b("msgBubbleEnable", false)) {
                        App app4 = this$0.f31719d.getApp();
                        a aVar = this$0.new a();
                        if (app4 != null) {
                            try {
                                appId = app4.getAppId();
                                if (appId == null) {
                                    appId = "";
                                }
                                if (!messageBubbleUtils.c(appId)) {
                                    if (NetworkUtils.r()) {
                                        TmcLogger.c("MessageBubbleUtils", "refreshMsgBubble -> requestMsgInfo");
                                        messageBubbleUtils.d(app4, aVar);
                                    } else {
                                        messageBubbleUtils.a(app4, aVar);
                                    }
                                }
                            } catch (Throwable th2) {
                                TmcLogger.h("MessageBubbleUtils", th2);
                            }
                        } else {
                            if (appId == null) {
                                appId = "";
                            }
                            if (!messageBubbleUtils.c(appId)) {
                                if (NetworkUtils.r()) {
                                    TmcLogger.c("MessageBubbleUtils", "refreshMsgBubble -> requestMsgInfo");
                                    messageBubbleUtils.d(app4, aVar);
                                } else {
                                    messageBubbleUtils.a(app4, aVar);
                                }
                            }
                        }
                    }
                } catch (Throwable th3) {
                    TmcLogger.h("MessageBubbleUtils", th3);
                }
            }
            String appId2 = this$0.H;
            if (appId2 != null) {
                c0.a aVar2 = c0.a.f14531a;
                Intrinsics.g(appId2, "appId");
                try {
                    c0.a.f14532b.remove(appId2);
                } catch (Throwable th4) {
                    TmcLogger.g(c0.a.f14533c, "removePreAppinfo", th4);
                }
            }
            try {
                com.cloud.tmc.kernel.utils.e.a(ExecutorType.IDLE, new Runnable() { // from class: qd.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        OooO0OO.l0(this.f74552a);
                    }
                });
            } catch (Throwable th5) {
                TmcLogger.h("MiniAppActivity", th5);
            }
            if (this$0.H != null) {
                try {
                    com.cloud.tmc.kernel.utils.e.a(ExecutorType.IO, new Runnable() { // from class: qd.x
                        @Override // java.lang.Runnable
                        public final void run() {
                            OooO0OO.J0();
                        }
                    });
                } catch (Throwable th6) {
                    TmcLogger.h("MiniAppActivity", th6);
                }
            }
        }
    }

    public static final void a0(OooO0OO this$0, int i11) {
        Intrinsics.g(this$0, "this$0");
        StatusLayout statusLayout = this$0.getStatusLayout();
        if (statusLayout != null) {
            statusLayout.setBackgroundColor(i11);
            TmcLogger.c("MiniAppActivity", "setHostActivityStatusBackground: 设置 activity 的状态布局背景色成功");
        }
        TmcLogger.c("MiniAppActivity", "setHostActivityStatusBackground: 执行完毕");
    }

    public static final void b0(final OooO0OO this$0, Intent intent) {
        Intrinsics.g(this$0, "this$0");
        try {
            TmcLogger.c("MiniAppActivity", "startApp success");
            if (intent != null) {
                intent.putExtra("launchMode", "launchModeReopen");
            } else {
                intent = null;
            }
            this$0.o0(intent);
            this$0.f31728n = false;
            this$0.onResume();
            if (this$0.L) {
                this$0.M = true;
                TmcLogger.c("MiniAppActivity", "quickModeStart complete");
                lb.g gVar = this$0.O;
                if (gVar != null) {
                    gVar.C(this$0.L);
                }
                com.cloud.tmc.kernel.utils.e.a(ExecutorType.IO, new Runnable() { // from class: qd.a0
                    @Override // java.lang.Runnable
                    public final void run() {
                        OooO0OO.F0(this.f74495a);
                    }
                });
            }
        } catch (Throwable th2) {
            TmcLogger.h("MiniAppActivity", th2);
        }
    }

    public static final void c0(OooO0OO this$0, Bundle bundle, boolean z11) {
        Intrinsics.g(this$0, "this$0");
        this$0.f31727m = true;
        if (bundle != null) {
            Intent intent = new Intent();
            intent.putExtras(bundle);
            intent.putExtra("launchMode", "launchModeCold");
            super.onNewIntent(intent);
        }
        if (z11) {
            App app = this$0.f31719d.getApp();
            if (app != null) {
                app.putBooleanValue("miniAppReload", true);
            }
            if (app != null) {
                app.exit();
            }
        }
        this$0.showStatusLoading();
        this$0.setInitDataChannel(1);
        this$0.initData();
    }

    public static final void d0(OooO0OO this$0, LoadStepAction step) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(step, "$step");
        this$0.updateStepAnimation(step);
    }

    public static /* synthetic */ void e0(OooO0OO oooO0OO, TmcFragment.ExitType exitType, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        oooO0OO.W(exitType, z11);
    }

    public static final void g0(OooO0OO this$0, boolean z11) {
        Intrinsics.g(this$0, "this$0");
        this$0.n0(z11);
    }

    public static /* synthetic */ void h0(OooO0OO oooO0OO, boolean z11, Bundle bundle, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        oooO0OO.j0(z11, null);
    }

    public static final void l0(OooO0OO this$0) {
        Intrinsics.g(this$0, "this$0");
        try {
            b0.g gVar = b0.g.f13878a;
            Application application = this$0.getApplication();
            Intrinsics.f(application, "this.application");
            gVar.c(application);
        } catch (Throwable th2) {
            TmcLogger.h("MiniAppActivity", th2);
        }
    }

    public static final void p0(OooO0OO this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.hideStatusLoading();
    }

    public static final void r0(OooO0OO this$0) {
        Intrinsics.g(this$0, "this$0");
        boolean z11 = this$0.L;
        if (z11) {
            PrepareController prepareControllerCreateQuickModePrepareController = ((IClientStarter) tc.a.a(IClientStarter.class)).createQuickModePrepareController(this$0.O, new h.c(this$0.O, this$0));
            this$0.G = prepareControllerCreateQuickModePrepareController;
            if (prepareControllerCreateQuickModePrepareController != null) {
                prepareControllerCreateQuickModePrepareController.start();
                return;
            }
            return;
        }
        lb.g gVar = this$0.O;
        if (gVar != null) {
            gVar.C(z11);
        }
        PrepareController prepareControllerCreatePrepareController = ((IClientStarter) tc.a.a(IClientStarter.class)).createPrepareController(this$0.O, new h.c(this$0.O, this$0));
        this$0.F = prepareControllerCreatePrepareController;
        if (prepareControllerCreatePrepareController != null) {
            prepareControllerCreatePrepareController.start();
        }
    }

    public static final void t0(OooO0OO this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.OooO00o();
    }

    public static final void v0(OooO0OO this$0) {
        Intrinsics.g(this$0, "this$0");
        try {
            StatusLayout statusLayout = this$0.getStatusLayout();
            if (statusLayout == null || !statusLayout.OooOOOo) {
                if (this$0.getMResumed()) {
                    ReportProxy reportProxy = (ReportProxy) tc.a.a(ReportProxy.class);
                    String str = this$0.H;
                    Bundle bundle = new Bundle();
                    bundle.putString("miniappid", this$0.H);
                    Unit unit = Unit.f68710a;
                    reportProxy.report(str, "miniapp_start_suc", bundle);
                } else {
                    TmcLogger.c("MiniAppActivity", "not report miniapp_start_suc ,resume is false");
                }
            }
        } catch (Throwable th2) {
            TmcLogger.g("MiniAppActivity", "report error", th2);
        }
    }

    public static final void x0(OooO0OO this$0) {
        AppModel appModel;
        Intrinsics.g(this$0, "this$0");
        if (this$0.B != null) {
            TmcLogger.c("MiniAppActivity", "showAsyncStatusLoading loadError");
            this$0.z(null, this$0.B);
            this$0.B = null;
            return;
        }
        TmcLogger.c("MiniAppActivity", "showAsyncStatusLoading showLoading");
        this$0.showLoading();
        App app = this$0.f31719d.getApp();
        if (app == null || (appModel = app.getAppModel()) == null) {
            return;
        }
        String name = appModel.getName();
        if (name == null) {
            name = "";
        }
        String logo = appModel.getLogo();
        this$0.showLoadingLogo(name, logo != null ? logo : "");
        this$0.i(LoadStepAction.STEP_START_LOADING);
    }

    public static final void z0(final OooO0OO this$0) {
        long jC;
        Intrinsics.g(this$0, "this$0");
        try {
            if (this$0.H0() == null) {
                TmcLogger.c("MiniAppActivity", "pvMsgBubble is null");
                return;
            }
            MsgBubblePopUpWindowView msgBubblePopUpWindowViewH0 = this$0.H0();
            if (msgBubblePopUpWindowViewH0 != null) {
                xb.i.e(msgBubblePopUpWindowViewH0);
                PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
                Bundle bundle = new Bundle();
                bundle.putString("jump_confi", msgBubblePopUpWindowViewH0.OooO0OO ? "0" : "1");
                Unit unit = Unit.f68710a;
                performanceAnalyseProxy.recordForCommon(null, "Bubble_ex", bundle);
            }
            MsgBubblePopUpWindowView msgBubblePopUpWindowViewH1 = this$0.H0();
            if (msgBubblePopUpWindowViewH1 != null) {
                msgBubblePopUpWindowViewH1.OooO00o(this$0.f31731q);
            }
            TmcLogger.c("MiniAppActivity", "showMsgBubbleToast");
            String str = this$0.H;
            if (str != null) {
                ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putLong(this$0, str, "showMsgBubbleTime", System.currentTimeMillis());
            }
            try {
                jC = MiniAppConfigHelper.f30370a.c("miniPopWindowTime", 5000);
            } catch (Throwable th2) {
                TmcLogger.h("MiniAppActivity", th2);
                jC = 5000;
            }
            this$0.postDelayed(new Runnable() { // from class: qd.d0
                @Override // java.lang.Runnable
                public final void run() {
                    OooO0OO.Q(this.f74502a);
                }
            }, jC);
            Context context = this$0.getContext();
            Intrinsics.g(context, "context");
            Intrinsics.g("", "msgStr");
            try {
                ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(context, "miniMsgProvider", "miniLatestUnreadMsg", "");
                ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putBoolean(context, "miniMsgKvId", "miniNewMsgStatus", !Intrinsics.b("", ""));
            } catch (Throwable th3) {
                TmcLogger.h("MiniappMsgDataProvider", th3);
            }
        } catch (Throwable th4) {
            TmcLogger.g("MiniAppActivity", "showMsgBubbleToast", th4);
        }
    }

    public final AddHomeCustom1PopUpWindowView A0() {
        return (AddHomeCustom1PopUpWindowView) this.f31721g.getValue();
    }

    @Override // ua.f
    public boolean B() {
        return getMResumed();
    }

    public final AddHomeCustom2PopUpWindowView C0() {
        return (AddHomeCustom2PopUpWindowView) this.f31722h.getValue();
    }

    @Override // rb.b
    public void D(LoadStepAction step) {
        Intrinsics.g(step, "step");
        i(step);
    }

    public final AddHomeCustomTopTipView E0() {
        return (AddHomeCustomTopTipView) this.f31723i.getValue();
    }

    public final void G0() {
        if (isLoadStatusLoadingOrError()) {
            return;
        }
        onKeyUp(4, new KeyEvent(1, 4));
    }

    public final MsgBubblePopUpWindowView H0() {
        return (MsgBubblePopUpWindowView) this.f31725k.getValue();
    }

    public final void I0() {
        if (this.L) {
            App app = this.f31719d.getApp();
            AppNode appNode = app instanceof AppNode ? (AppNode) app : null;
            if (appNode != null && !appNode.isAsyncLaunchStatus()) {
                App app2 = this.f31719d.getApp();
                AppNode appNode2 = app2 instanceof AppNode ? (AppNode) app2 : null;
                if (appNode2 != null) {
                    App app3 = this.f31719d.getApp();
                    appNode2.setBackToPagePath(app3 != null ? app3.getHomePagePath() : null);
                }
                T0();
                return;
            }
        }
        if (isLoadStatusLoadingOrError()) {
            return;
        }
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.H, PointAnalyseType.POINT_NAV_HOME_PRESSED, "");
        try {
            App app4 = this.f31719d.getApp();
            if (app4 != null) {
                app4.exitToHomePage();
            }
        } catch (Throwable th2) {
            TmcLogger.e(th2.getMessage());
        }
    }

    public final boolean K0() {
        Page activePage;
        zc.i render;
        String strB;
        try {
            App app = this.f31719d.getApp();
            if (app == null || (activePage = app.getActivePage()) == null || (render = activePage.getRender()) == null || (strB = render.b()) == null) {
                return false;
            }
            return kb.a.f68517a.l(strB);
        } catch (Throwable th2) {
            TmcLogger.h("MiniAppActivity", th2);
            return false;
        }
    }

    public final void L0() {
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        String str;
        Bundle bundleQ;
        Bundle bundleQ2;
        Bundle bundleQ3;
        Bundle bundleQ4;
        Bundle bundle4;
        Bundle bundle5;
        String string;
        if (getSavedInstance() != null) {
            Bundle savedInstance = getSavedInstance();
            if (savedInstance == null || (string = savedInstance.getString("miniAppId")) == null) {
                MiniAppLaunch.f31784a.e0(this.H, "3");
                TmcLogger.c("MiniAppActivity", "savedInstance is not null,appId is null");
                e0(this, TmcFragment.ExitType.CLOSE_APP, false, 2, null);
                return;
            } else {
                this.H = string;
                Bundle savedInstance2 = getSavedInstance();
                this.I = savedInstance2 != null ? savedInstance2.getString("mode") : null;
                Bundle savedInstance3 = getSavedInstance();
                this.J = savedInstance3 != null ? savedInstance3.getString("version") : null;
                Bundle savedInstance4 = getSavedInstance();
                this.K = savedInstance4 != null ? savedInstance4.getString("sign") : null;
            }
        } else {
            try {
                if (MiniAppConfigHelper.f30370a.b("miniEnableNewMiniappInit", true)) {
                    M0();
                } else {
                    P0();
                }
            } catch (Throwable th2) {
                TmcLogger.h("MiniAppActivity", th2);
                P0();
            }
            this.L = getBoolean("enableQuickMode");
        }
        String str2 = this.H;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        NewTaskManager.Companion companion = NewTaskManager.f31301b;
        companion.updateTaskIdByAppId(this.H, getTaskId());
        f0 f0Var = f0.f31050a;
        f0Var.c(this.H, this);
        this.f31719d.setAppId(this.H);
        ((LogEProxy) tc.a.a(LogEProxy.class)).init(this.H);
        IUpdateLoadingStepProxy iUpdateLoadingStepProxy = (IUpdateLoadingStepProxy) tc.a.a(IUpdateLoadingStepProxy.class);
        String str3 = this.H;
        if (str3 == null) {
            str3 = "";
        }
        iUpdateLoadingStepProxy.addUpdateLoadingListener(str3, this);
        OfflineManager.j(this.H, getLifecycle());
        if (companion.getInstance().j(this.H)) {
            String strZ = companion.getInstance().z();
            if (strZ == null) {
                strZ = "";
            }
            this.N = strZ;
            kd.k.a(hd.j.a("tootTaskId:"), this.N, "MiniAppActivity");
        }
        StringBuilder sbA = hd.j.a("initMiniActivityData:checkTaskId:");
        sbA.append(this.H);
        TmcLogger.c("MiniAppActivity", sbA.toString());
        companion.getInstance().i(this.H, getClass());
        StartClientBundle startClientBundle = (StartClientBundle) com.cloud.tmc.kernel.utils.a.d(getBundle(), "startBundle");
        if (startClientBundle != null) {
            try {
                bundle = startClientBundle.startParams;
            } catch (Throwable th3) {
                TmcLogger.g("MiniAppActivity", "", th3);
            }
        } else {
            bundle = null;
        }
        f0Var.d(bundle);
        VirtualAppManager virtualAppManager = (VirtualAppManager) tc.a.a(VirtualAppManager.class);
        String str4 = this.H;
        if (startClientBundle == null || (bundle2 = startClientBundle.startParams) == null) {
            bundle2 = new Bundle();
        }
        if (startClientBundle == null || (bundle3 = startClientBundle.sceneParams) == null) {
            bundle3 = new Bundle();
        }
        virtualAppManager.startApp(str4, bundle2, bundle3);
        q.h.a aVar = q.h.f74093e;
        this.f31732r = Long.valueOf(q.h.f74094f.addAndGet(1L) + (((long) Process.myPid()) * 1000000));
        if (this.M) {
            this.L = false;
        }
        String str5 = this.H;
        if (str5 == null) {
            str5 = "";
        }
        Bundle bundle6 = new Bundle();
        bundle6.putString("uniqueChainID", String.valueOf(this.f31732r));
        if (startClientBundle != null && (bundle5 = startClientBundle.startParams) != null) {
            bundle6.putAll(bundle5);
        }
        Unit unit = Unit.f68710a;
        Bundle bundle7 = new Bundle();
        if (startClientBundle != null && (bundle4 = startClientBundle.sceneParams) != null) {
            bundle7.putAll(bundle4);
        }
        lb.g gVar = new lb.g(this, str5, bundle6, bundle7, false, this.f31718c, this, null, 144, null);
        this.O = gVar;
        gVar.w(this.I);
        lb.g gVar2 = this.O;
        if (gVar2 != null) {
            gVar2.x(this.J);
        }
        lb.g gVar3 = this.O;
        if (gVar3 != null) {
            gVar3.v(this.K);
        }
        lb.g gVar4 = this.O;
        if (gVar4 != null) {
            gVar4.B(this.L);
        }
        if (this.L) {
            ((PerformanceImprovesProxy) tc.a.a(PerformanceImprovesProxy.class)).addPeroformanceImprove(this.H, "quickStart");
        }
        ((SessionUtilProxy) tc.a.a(SessionUtilProxy.class)).updateSession(this.H, false, true);
        if (getInitDataChannel() == 0) {
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            String str6 = this.H;
            PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_LAUNCH_MINIAPP_START;
            Bundle bundle8 = new Bundle();
            bundle8.putString("miniapp_id", this.H);
            bundle8.putString("queryShortcutExist", String.valueOf(AppUtils.f31011a.v(this, this.H)));
            lb.g gVar5 = this.O;
            bundle8.putString("scene", (gVar5 == null || (bundleQ4 = gVar5.q()) == null) ? null : bundleQ4.getString(TrackingKey.SCENE_ID, "100000"));
            lb.g gVar6 = this.O;
            if (gVar6 != null && (bundleQ3 = gVar6.q()) != null) {
                bundleQ3.getString(TrackingKey.SCENE_ID, "100000");
            }
            lb.g gVar7 = this.O;
            bundle8.putString("fis_type", (gVar7 == null || (bundleQ2 = gVar7.q()) == null) ? null : bundleQ2.getString("fis_type", "0"));
            str = "";
            performanceAnalyseProxy.record(str6, pointAnalyseType, str, bundle8);
        } else {
            str = "";
        }
        Bundle bundle9 = new Bundle();
        bundle9.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        String str7 = com.cloud.tmc.kernel.proxy.performanceanalyse.a.M;
        lb.g gVar8 = this.O;
        bundle9.putString(str7, (gVar8 == null || (bundleQ = gVar8.q()) == null) ? null : bundleQ.getString("uniqueChainID", "-1"));
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.H, PointAnalyseType.POINT_CHAIN_START, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31230r, bundle9);
        PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        String str8 = this.H;
        performanceAnalyseProxy2.record(str8, PointAnalyseType.POINT_START, String.valueOf(str8));
        PerformanceAnalyseProxy performanceAnalyseProxy3 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        String str9 = this.H;
        PointAnalyseType pointAnalyseType2 = PointAnalyseType.POINT_PAGE_PV;
        Bundle bundle10 = new Bundle();
        bundle10.putString("miniapp_id", this.H);
        performanceAnalyseProxy3.record(str9, pointAnalyseType2, str, bundle10);
        com.cloud.tmc.kernel.utils.e.a(ExecutorType.IO, new Runnable() { // from class: qd.s
            @Override // java.lang.Runnable
            public final void run() {
                OooO0OO.r0(this.f74548a);
            }
        });
        Q0();
        ((CreateBottomMenuPoint) ib.a.b(CreateBottomMenuPoint.class).d()).requestBottomAbilityConfig();
    }

    public final void M0() {
        String str = this.H;
        if (str == null || str.length() == 0) {
            String string = getString("miniAppId");
            if (string == null) {
                MiniAppLaunch.f31784a.e0(this.H, "5");
                TmcLogger.c("MiniAppActivity", "newDataInitialize appId is null");
                e0(this, TmcFragment.ExitType.CLOSE_APP, false, 2, null);
                return;
            }
            this.H = string;
        }
        String str2 = this.I;
        if (str2 == null || str2.length() == 0) {
            this.I = getString("mode");
        }
        String str3 = this.J;
        if (str3 == null || str3.length() == 0) {
            this.J = getString("version");
        }
        String str4 = this.K;
        if (str4 == null || str4.length() == 0) {
            this.K = getString("sign");
        }
    }

    public final void N0() {
        MiniAppConfigModel miniAppConfigModel;
        List<String> list;
        TmcLogger.c("MiniAppActivity", "Refresh app...");
        try {
            App app = this.f31719d.getApp();
            AppLoadResult appLoadResult = (AppLoadResult) com.cloud.tmc.kernel.utils.a.d(app != null ? app.getSceneParams() : null, "appLoadResult");
            String str = (appLoadResult == null || (miniAppConfigModel = appLoadResult.appConfigModel) == null || (list = miniAppConfigModel.pages) == null) ? null : (String) CollectionsKt___CollectionsKt.g0(list);
            Bundle startParams = app != null ? app.getStartParams() : null;
            Bundle sceneParams = app != null ? app.getSceneParams() : null;
            if (str != null && str.length() != 0 && startParams != null && sceneParams != null) {
                app.putRouteType(str, Page.SOURCE_RELAUNCH);
                sceneParams.putString("navigationType", "refreshApp");
                app.relaunchToUrl(str, startParams, sceneParams);
                return;
            }
            TmcLogger.c("MiniAppActivity", "refreshApp null");
        } catch (Throwable th2) {
            TmcLogger.g("MiniAppActivity", "Refresh fail!", th2);
        }
    }

    public final AddHomeCustomBottomTipView O() {
        return (AddHomeCustomBottomTipView) this.f31724j.getValue();
    }

    public final void OooO00o() {
        WeakHashMap<String, bc.a> onCheckForUpdate;
        bc.a aVar;
        MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
        String str = this.H;
        if (str == null) {
            str = "";
        }
        boolean zU = miniAppLaunch.U(this, str);
        App app = this.f31719d.getApp();
        MiniAppUpdateMessageStore miniAppUpdateMessageStore = app != null ? (MiniAppUpdateMessageStore) app.getData(MiniAppUpdateMessageStore.class) : null;
        if (miniAppUpdateMessageStore == null || (onCheckForUpdate = miniAppUpdateMessageStore.getOnCheckForUpdate()) == null || (aVar = onCheckForUpdate.get(this.H)) == null) {
            return;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("hasUpdate", Boolean.valueOf(zU));
        aVar.d(jsonObject);
    }

    public final void P0() {
        String string = getString("miniAppId");
        if (string == null) {
            MiniAppLaunch.f31784a.e0(this.H, "2");
            TmcLogger.c("MiniAppActivity", "oldDataInitialize appId is null");
            e0(this, TmcFragment.ExitType.CLOSE_APP, false, 2, null);
        } else {
            this.H = string;
            this.I = getString("mode");
            this.J = getString("version");
            this.K = getString("sign");
        }
    }

    public final void Q0() {
        try {
            com.cloud.tmc.kernel.utils.e.g(new Runnable() { // from class: qd.c0
                @Override // java.lang.Runnable
                public final void run() {
                    OooO0OO.v0(this.f74499a);
                }
            }, 1000L);
        } catch (Throwable th2) {
            TmcLogger.g("MiniAppActivity", "report error", th2);
        }
    }

    public final void R(int i11, long j11, long j12, String str, String str2) {
        String configString;
        ArrayList arrayList;
        i0.b bVar = i0.b.f66804a;
        String str3 = this.H;
        String windowToken = y0();
        long j13 = this.f31733s;
        C0346OooO0OO c0346OooO0OO = new C0346OooO0OO(i11, this, str, str2, j12);
        Intrinsics.g(this, "context");
        Intrinsics.g(windowToken, "windowToken");
        if (str3 == null || str3.length() == 0) {
            return;
        }
        boolean zV = AppUtils.f31011a.v(this, str3);
        TmcLogger.c("AddHomeToastUtils", "查询桌面是否存在，status: " + zV);
        if (zV || str3 == null || str3.length() == 0) {
            return;
        }
        try {
            configString = ((ConfigService) tc.a.a(ConfigService.class)).getConfigString("miniAddHomeCustomWhitelist", "[\"1000497027976413184\"]");
        } catch (Throwable th2) {
            TmcLogger.g("AddHomeToastUtils", "checkAddHomeCustomWhiteList failed!", th2);
            configString = "[\"1000497027976413184\"]";
        }
        if (configString != null) {
            try {
                Type type = new TypeToken<ArrayList<String>>() { // from class: com.cloud.tmc.miniapp.utils.AddHomeToastUtils$checkAddHomeCustomWhiteList$whiteList$1
                }.getType();
                Intrinsics.f(type, "object :\n               …ayList<String>>() {}.type");
                arrayList = (ArrayList) TmcGsonUtils.e(configString, type);
            } catch (Throwable th3) {
                TmcLogger.h("AddHomeToastUtils", th3);
                try {
                    Type type2 = new TypeToken<ArrayList<String>>() { // from class: com.cloud.tmc.miniapp.utils.AddHomeToastUtils$checkAddHomeCustomWhiteList$whiteList$2
                    }.getType();
                    Intrinsics.f(type2, "object : TypeToken<ArrayList<String>>() {}.type");
                    arrayList = (ArrayList) TmcGsonUtils.e("[\"1000497027976413184\"]", type2);
                } catch (Throwable th4) {
                    TmcLogger.g("AddHomeToastUtils", "", th4);
                    arrayList = new ArrayList();
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            return;
        }
        StringBuilder sbA = hd.j.a("addHomeCustom: ");
        sbA.append(arrayList.contains(str3));
        sbA.append(" 白名单：");
        sbA.append(arrayList);
        TmcLogger.c("AddHomeToastUtils", sbA.toString());
        if (arrayList.contains(str3)) {
            if (j11 <= 0) {
                TmcLogger.c("AddHomeToastUtils", "添加桌面展示延迟时间小于等于 0");
            } else {
                PopWindowManager.f31020a.a(windowToken, new PopWindowManager.PopWindowData(str3, j11, 10, new i0.b.a(this, windowToken, j13, new p011Oooo00o.OooOo00(str3, c0346OooO0OO)), false, 16, null));
            }
        }
    }

    public final void R0() {
        try {
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.H, PointAnalyseType.POINT_REFRESH, "");
            s0().l();
            N0();
        } catch (Throwable th2) {
            TmcLogger.e("refresh fail!!,msg:" + th2);
        }
    }

    public final void S0() {
        post(new Runnable() { // from class: qd.y
            @Override // java.lang.Runnable
            public final void run() {
                OooO0OO.z0(this.f74553a);
            }
        });
    }

    public final void T(long j11) {
        postDelayed(new Runnable() { // from class: qd.e0
            @Override // java.lang.Runnable
            public final void run() {
                OooO0OO.p0(this.f74503a);
            }
        }, j11);
    }

    public final void T0() {
        getHandler().post(new Runnable() { // from class: qd.k0
            @Override // java.lang.Runnable
            public final void run() {
                OooO0OO.x0(this.f74520a);
            }
        });
    }

    public void U0(String str, Function0<Unit> function0) {
        ua.c.a.a(this, str, function0);
    }

    public void V0(String str, Integer num) {
        j.a.a(this, str, num);
    }

    public final void W(TmcFragment.ExitType exitType, boolean z11) {
        List arrayList;
        tb.b appContext;
        com.cloud.tmc.integration.ui.fragment.a aVarK;
        Set<TmcFragment> setJ;
        Intrinsics.g(exitType, "exitType");
        try {
            App app = this.f31719d.getApp();
            Unit unit = null;
            tb.b appContext2 = app != null ? app.getAppContext() : null;
            com.cloud.tmc.integration.structure.app.b bVar = appContext2 instanceof com.cloud.tmc.integration.structure.app.b ? (com.cloud.tmc.integration.structure.app.b) appContext2 : null;
            if (bVar != null && (aVarK = bVar.k()) != null && (setJ = aVarK.j()) != null) {
                Iterator<T> it = setJ.iterator();
                while (it.hasNext()) {
                    ((TmcFragment) it.next()).i0(exitType);
                }
            }
            App app2 = this.f31719d.getApp();
            if (app2 == null) {
                if (!NewTaskManager.f31301b.getInstance().h(this.H)) {
                    finish();
                    return;
                }
                try {
                    String str = this.H;
                    if (str == null || str.length() == 0) {
                        finishAndRemoveTask();
                    } else {
                        ((StartActivityProxy) tc.a.a(StartActivityProxy.class)).removeMiniAppTask(this.H, this);
                    }
                    return;
                } catch (Throwable unused) {
                    finishAndRemoveTask();
                    return;
                }
            }
            if (z11) {
                app2.exit();
                return;
            }
            MiniAppConfigHelper miniAppConfigHelper = MiniAppConfigHelper.f30370a;
            if (!miniAppConfigHelper.b("enableMoveToBack", true)) {
                TmcLogger.c("MiniAppActivity", "finishMiniActivity enableMoveToBack -> false");
                app2.exit();
                return;
            }
            NewTaskManager.Companion companion = NewTaskManager.f31301b;
            NewTaskManager companion2 = companion.getInstance();
            App app3 = this.f31719d.getApp();
            if (!companion2.h(app3 != null ? app3.getAppId() : null)) {
                TmcLogger.c("MiniAppActivity", "finishMiniActivity checkOpenMutipleTask -> false");
                app2.exit();
                return;
            }
            NewTaskManager companion3 = companion.getInstance();
            App app4 = this.f31719d.getApp();
            if (companion3.j(app4 != null ? app4.getAppId() : null)) {
                TmcLogger.c("MiniAppActivity", "finishMiniActivity feedback -> finish");
                app2.exit();
                return;
            }
            NewTaskManager companion4 = companion.getInstance();
            App app5 = this.f31719d.getApp();
            if (companion4.g(app5 != null ? app5.getAppId() : null)) {
                TmcLogger.c("MiniAppActivity", "finishMiniActivity setting -> finish");
                app2.exit();
                return;
            }
            App app6 = this.f31719d.getApp();
            if (app6 != null && !app6.getMiniAppLoadStatus()) {
                TmcLogger.c("MiniAppActivity", "finishMiniActivity miniAppLoadStatus -> false");
                app2.exit();
                return;
            }
            try {
                try {
                    Object objD = com.cloud.tmc.miniutils.util.k.d(miniAppConfigHelper.e("forceFinishMiniApp", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI), List.class);
                    arrayList = objD instanceof List ? (List) objD : null;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                } catch (Throwable th2) {
                    TmcLogger.h("MiniAppActivity", th2);
                    arrayList = new ArrayList();
                }
                App app7 = this.f31719d.getApp();
                if (CollectionsKt___CollectionsKt.X(arrayList, app7 != null ? app7.getAppId() : null)) {
                    TmcLogger.c("MiniAppActivity", "finishMiniActivity forceFinishList -> finish");
                    app2.exit();
                    return;
                }
            } catch (Throwable unused2) {
            }
            App app8 = this.f31719d.getApp();
            if (app8 != null && (appContext = app8.getAppContext()) != null) {
                boolean zB = appContext.b();
                TmcLogger.f("MiniAppActivity", "mActivityHelper not null, moveToBackground status ->" + zB);
                if (!zB) {
                    app2.exit();
                }
                unit = Unit.f68710a;
            }
            if (unit == null) {
                TmcLogger.f("MiniAppActivity", "app or appContext is null,exit app");
                app2.exit();
            }
        } catch (Throwable th3) {
            TmcLogger.h("miniappactivity", th3);
        }
    }

    public final void Y(PrepareException prepareException, StatusLayout.a aVar) {
        String code = prepareException != null ? prepareException.getCode() : null;
        if (code == null) {
            code = "0";
        }
        Bundle bundle = new Bundle();
        bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31208e0, PrepareException.codeToDes(code));
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.H, PointAnalyseType.POINT_APP_CHAIN_FAIL, "appOpenFail", bundle);
        new cb.a(bundle).f(this.f31718c);
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        String str = this.H;
        Bundle bundle2 = new Bundle();
        bundle2.putInt("type", 4);
        Unit unit = Unit.f68710a;
        performanceAnalyseProxy.recordForCommon(str, "uncon_page_ex", bundle2);
        showError(new d(), R$string.loading_error_tv, prepareException != null ? prepareException.getMessage() : null, this.H, aVar);
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.r
    public void a(String str) {
        V0(str, getViewThemeMode());
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.r
    public void b() {
        TmcLogger.c("NewTaskManager", "kill activity");
        TmcLogger.e("launch step error,finish activity");
        e0(this, TmcFragment.ExitType.CLOSE_APP, false, 2, null);
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.r
    public void c() {
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.r
    public void d(String str, String str2) {
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.r
    public void e(AppModel appModelNew) {
        Intrinsics.g(appModelNew, "appModelNew");
        TmcLogger.c("MiniAppActivity", "refreshAppInfo: miniappStartTime: " + this.f31733s + " appModelNew: " + appModelNew);
        if (this.f31733s != 0) {
            OooO00o();
        } else {
            w0().b(new d0.b("onCheckForUpdate", new Runnable() { // from class: qd.z
                @Override // java.lang.Runnable
                public final void run() {
                    OooO0OO.t0(this.f74554a);
                }
            }));
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.r
    public void f(PrepareData prepareData, PrepareException prepareException) {
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(R$anim.activity_scale_in, R$anim.activity_bottom_out);
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.r
    public void g(AppModel appModelNew, final boolean z11) {
        Intrinsics.g(appModelNew, "appModelNew");
        TmcLogger.c("MiniAppActivity", "backgroundDownloadZipAsync: miniappStartTime: " + this.f31733s + " isSuccess: " + z11 + " appModelNew: " + appModelNew);
        if (this.f31733s != 0) {
            n0(z11);
        } else {
            w0().b(new d0.b("onUpdateApp", new Runnable() { // from class: qd.r
                @Override // java.lang.Runnable
                public final void run() {
                    OooO0OO.g0(this.f74545a, z11);
                }
            }));
        }
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public int getLayoutId() {
        return R$layout.activity_mini_main;
    }

    @Override // id.i
    public StatusLayout getStatusLayout() {
        return (StatusLayout) this.f31717b.getValue();
    }

    @Override // id.i
    public Integer getViewThemeMode() {
        App app = this.f31719d.getApp();
        AppModel appModel = app != null ? app.getAppModel() : null;
        return (appModel != null && (MiniAppType.SHELL.getType() == appModel.getAppinfoCategoryType() || MiniAppType.SHELL_GAME.getType() == appModel.getAppinfoCategoryType())) ? 2 : 1;
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.r
    public void h(final EntryInfo entryInfo) {
        getHandler().post(new Runnable() { // from class: qd.j0
            @Override // java.lang.Runnable
            public final void run() {
                OooO0OO.U(entryInfo, this);
            }
        });
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void hideStatusLoading() {
        App app = this.f31719d.getApp();
        if (app != null) {
            ((IAdManagerProxy) tc.a.a(IAdManagerProxy.class)).onCreate(app);
            app.updateHideMiniappLoadingStatus(true);
        }
        getHandler().post(new Runnable() { // from class: qd.l0
            @Override // java.lang.Runnable
            public final void run() {
                OooO0OO.Z(this.f74525a);
            }
        });
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.r
    public void i(final LoadStepAction step) {
        Intrinsics.g(step, "step");
        getHandler().post(new Runnable() { // from class: qd.m0
            @Override // java.lang.Runnable
            public final void run() {
                OooO0OO.d0(this.f74528a, step);
            }
        });
    }

    public final void i0(boolean z11) {
        Unit unit;
        try {
            try {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.H, PointAnalyseType.POINT_EXIT_CLICK, "");
            } catch (Throwable th2) {
                TmcLogger.h("MiniAppActivity", th2);
            }
            OfflineManager.f32003a.l(this);
            if (z11) {
                W(TmcFragment.ExitType.CLOSE_APP, true);
                return;
            }
            App app = this.f31719d.getApp();
            if (app != null) {
                if (!app.getBackPressedProcessor().startBackPressedInterceptorChain(new qb.a.c(this, this.H, app instanceof AppNode ? (AppNode) app : null, true, 2)).a()) {
                    W(TmcFragment.ExitType.CLOSE_APP, false);
                }
                unit = Unit.f68710a;
            } else {
                unit = null;
            }
            if (unit == null) {
                e0(this, TmcFragment.ExitType.CLOSE_APP, false, 2, null);
            }
        } catch (Throwable th3) {
            TmcLogger.h("MiniAppActivity", th3);
        }
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void initData() {
        if (!ByteAppManager.isInit()) {
            TmcLogger.c("MiniAppActivity", "ByteAppManager is not init");
            MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
            Application application = getApplication();
            Intrinsics.f(application, "this.application");
            miniAppLaunch.p(application);
        }
        L0();
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void initView() {
        CapsuleView capsuleViewU0 = u0();
        if (capsuleViewU0 != null) {
            capsuleViewU0.setTranslationY(capsuleViewU0.getTranslationY() + e0.a());
            capsuleViewU0.setTranslationX(j0.a() ? getResources().getDimension(R$dimen.mini_dp_8) : getResources().getDimension(R$dimen.mini_dp_m_8));
            capsuleViewU0.setOnLeftClickListener(new OooOO0O());
            capsuleViewU0.setOnRightClickListener(new OooOOO0());
        }
        this.f31719d.setOnSetHostActivityStatusBackgroundCallback(new ActivityHelper.b() { // from class: qd.g0
            @Override // com.cloud.tmc.integration.ActivityHelper.b
            public final void a(int i11) {
                OooO0OO.a0(this.f74508a, i11);
            }
        });
    }

    public boolean isLoadStatusLoadingOrError() {
        return i.a.a(this);
    }

    public final void j0(final boolean z11, final Bundle bundle) {
        com.cloud.tmc.integration.ui.fragment.a aVarK;
        Set<TmcFragment> setJ;
        try {
            this.f31719d.reportFailureClickReloadButton();
            App app = this.f31719d.getApp();
            if (app != null) {
                app.updateHideMiniappLoadingStatus(false);
            }
        } catch (Throwable th2) {
            TmcLogger.h("MiniAppActivity", th2);
        }
        App app2 = this.f31719d.getApp();
        tb.b appContext = app2 != null ? app2.getAppContext() : null;
        com.cloud.tmc.integration.structure.app.b bVar = appContext instanceof com.cloud.tmc.integration.structure.app.b ? (com.cloud.tmc.integration.structure.app.b) appContext : null;
        if (bVar != null && (aVarK = bVar.k()) != null && (setJ = aVarK.j()) != null) {
            Iterator<T> it = setJ.iterator();
            while (it.hasNext()) {
                ((TmcFragment) it.next()).i0(TmcFragment.ExitType.REFRESH);
            }
        }
        runOnUiThread(new Runnable() { // from class: qd.i0
            @Override // java.lang.Runnable
            public final void run() {
                OooO0OO.c0(this.f74512a, bundle, z11);
            }
        });
    }

    public final void k0(long j11) {
        Runnable runnable = this.Q;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: qd.t
            @Override // java.lang.Runnable
            public final void run() {
                OooO0OO.B0(this.f74549a);
            }
        };
        this.Q = runnable2;
        postDelayed(runnable2, j11);
    }

    @Override // ua.i
    public void l(final int i11) {
        runOnUiThread(new Runnable() { // from class: qd.f0
            @Override // java.lang.Runnable
            public final void run() {
                OooO0OO.S(i11, this);
            }
        });
    }

    @Override // com.cloud.tmc.integration.proxy.OfflineAppProxy.b
    public void m(String appId) {
        Intrinsics.g(appId, "appId");
        try {
            String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(this, "1000886706715795456_web", "csmk");
            if (string == null) {
                string = "";
            }
            if (((CSMKBean) com.cloud.tmc.miniutils.util.k.d(string, CSMKBean.class)).getContinueShow()) {
                statusLayoutCreateShortCutsSuccess(appId, new OooO0o(this));
            } else {
                PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
                PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_GET_TOAST_ADD_EX;
                Bundle bundle = new Bundle();
                bundle.putString("miniappid", appId);
                Unit unit = Unit.f68710a;
                performanceAnalyseProxy.record("", pointAnalyseType, "", bundle);
                statusLayoutCreateShortCutsSuccess(appId, null);
            }
        } catch (Throwable unused) {
        }
    }

    public final void m0(String location) {
        tb.b appContext;
        Context context;
        AddHomeCustomTopTipView addHomeCustomTopTipViewE0;
        Intrinsics.g(location, "location");
        try {
            if (isLoadStatusLoadingOrError()) {
                return;
            }
            if (Intrinsics.b(location, "0") && (addHomeCustomTopTipViewE0 = E0()) != null && xb.i.a(addHomeCustomTopTipViewE0)) {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).recordForCommon(this.H, "upper_pop_click", new Bundle());
                location = PrepareException.ERROR_MINI_APPID;
            }
            String str = location;
            AddHomeCustomTopTipView addHomeCustomTopTipViewE1 = E0();
            if (addHomeCustomTopTipViewE1 != null) {
                addHomeCustomTopTipViewE1.OooO00o();
            }
            AddHomeCustomBottomTipView addHomeCustomBottomTipViewO = O();
            if (addHomeCustomBottomTipViewO != null) {
                try {
                    if (xb.i.a(addHomeCustomBottomTipViewO)) {
                        addHomeCustomBottomTipViewO.startAnimation(AnimationUtils.loadAnimation(addHomeCustomBottomTipViewO.getContext(), R$anim.mini_view_toast_exit));
                        xb.i.d(addHomeCustomBottomTipViewO);
                    }
                } catch (Throwable th2) {
                    TmcLogger.g(addHomeCustomBottomTipViewO.OooO0oO, "toAddCustomBottomVisible error", th2);
                }
            }
            MiniAddHomeTipDialogView miniAddHomeTipDialogViewQ0 = q0();
            if (miniAddHomeTipDialogViewQ0 != null) {
                miniAddHomeTipDialogViewQ0.OooO00o(false);
            }
            App app = this.f31719d.getApp();
            if (app != null && (appContext = app.getAppContext()) != null && (context = appContext.getContext()) != null) {
                Intrinsics.f(context, "context");
                Class<?> launcherShortCutActivity = ((StartActivityProxy) tc.a.a(StartActivityProxy.class)).getLauncherShortCutActivity();
                Intrinsics.f(launcherShortCutActivity, "get(StartActivityProxy::….launcherShortCutActivity");
                o.a(context, launcherShortCutActivity, app, str, (112 & 16) != 0 ? 0 : 0, (112 & 32) != 0 ? false : false, (112 & 64) != 0);
            }
            try {
                removeCallbacksAndMessages(A0());
                removeCallbacksAndMessages(C0());
                AddHomeCustom1PopUpWindowView addHomeCustom1PopUpWindowViewA0 = A0();
                if (addHomeCustom1PopUpWindowViewA0 != null) {
                    xb.i.c(addHomeCustom1PopUpWindowViewA0);
                }
                AddHomeCustom2PopUpWindowView addHomeCustom2PopUpWindowViewC0 = C0();
                if (addHomeCustom2PopUpWindowViewC0 != null) {
                    xb.i.c(addHomeCustom2PopUpWindowViewC0);
                    return;
                }
                return;
            } catch (Throwable th3) {
                TmcLogger.h("MiniAppActivity", th3);
                return;
            }
            TmcLogger.h("MiniAppActivity", th);
        } catch (Throwable th4) {
            TmcLogger.h("MiniAppActivity", th4);
        }
    }

    public final void n0(boolean z11) {
        WeakHashMap<String, bc.a> onUpdateFailed;
        bc.a aVar;
        WeakHashMap<String, bc.a> onUpdateReady;
        bc.a aVar2;
        App app = this.f31719d.getApp();
        MiniAppUpdateMessageStore miniAppUpdateMessageStore = app != null ? (MiniAppUpdateMessageStore) app.getData(MiniAppUpdateMessageStore.class) : null;
        if (z11) {
            if (miniAppUpdateMessageStore == null || (onUpdateReady = miniAppUpdateMessageStore.getOnUpdateReady()) == null || (aVar2 = onUpdateReady.get(this.H)) == null) {
                return;
            }
            aVar2.g();
            return;
        }
        if (miniAppUpdateMessageStore == null || (onUpdateFailed = miniAppUpdateMessageStore.getOnUpdateFailed()) == null || (aVar = onUpdateFailed.get(this.H)) == null) {
            return;
        }
        aVar.g();
    }

    @Override // ua.c
    public ArrayList<Function0<Unit>> o() {
        return this.f31740z;
    }

    public final void o0(Intent intent) {
        App app;
        Bundle extras;
        if ((intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("launchMode")) && intent != null) {
            intent.putExtra("launchMode", "launchModeHot");
        }
        StringBuilder sbA = hd.j.a("onNewIntent: ");
        sbA.append(this.H);
        TmcLogger.c("MiniAppActivity", sbA.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("startMiniApp:checkTaskId:");
        kd.k.a(sb2, this.H, "MiniAppActivity");
        NewTaskManager.f31301b.getInstance().i(this.H, getClass());
        this.f31719d.onNewIntent(intent);
        uc.b eventCenterInstance = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(this.f31719d.getApp());
        this.f31739y = eventCenterInstance;
        if (eventCenterInstance != null) {
            StringBuilder sbA2 = hd.j.a("resendH5PageStack_");
            App app2 = this.f31719d.getApp();
            sbA2.append(app2 != null ? app2.getAppId() : null);
            eventCenterInstance.b(sbA2.toString(), new h());
        }
        if (this.L && (app = this.f31719d.getApp()) != null) {
            app.setAsyncStartLoadingCallback(new f());
        }
        App app3 = this.f31719d.getApp();
        if (app3 != null) {
            app3.setAppCallback(new g());
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        App app = this.f31719d.getApp();
        tb.b appContext = app != null ? app.getAppContext() : null;
        if (!(appContext instanceof com.cloud.tmc.integration.structure.app.b) || ((com.cloud.tmc.integration.structure.app.b) appContext).k().onBackPressed()) {
            return;
        }
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.g(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        int i11 = newConfig.orientation;
        if (i11 == 1) {
            CapsuleView capsuleViewU0 = u0();
            if (capsuleViewU0 != null) {
                capsuleViewU0.setVisibility(0);
            }
            getWindow().clearFlags(1024);
            getWindow().addFlags(2048);
            return;
        }
        if (i11 != 2) {
            return;
        }
        CapsuleView capsuleViewU1 = u0();
        if (capsuleViewU1 != null) {
            capsuleViewU1.setVisibility(8);
        }
        getWindow().clearFlags(2048);
        getWindow().addFlags(1024);
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.cloud.tmc.integration.e.f(this);
        ((IOnRenderProcessGoneProxy) tc.a.a(IOnRenderProcessGoneProxy.class)).register(this);
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        String appId;
        Bundle startParams;
        Bundle startParams2;
        lb.h hVar;
        String str = "";
        super.onDestroy();
        StringBuilder sbA = hd.j.a("onDestroy invoke..appId:");
        sbA.append(this.H);
        sbA.append(",isDarkMode:");
        sbA.append(z.a(this));
        TmcLogger.c("MiniAppBasePage", sbA.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ondestory:");
        kd.k.a(sb2, this.H, "MiniAppActivity");
        try {
            p011Oooo00o.o000oOoO.f221a.a().f62852a.clear();
        } catch (Throwable th2) {
            TmcLogger.g("NormalTaskQueueUtils", "", th2);
        }
        NewTaskManager.f31301b.getInstance().F(this.H);
        ((LogEProxy) tc.a.a(LogEProxy.class)).destroy(this.H);
        uc.b bVar = this.f31739y;
        if (bVar != null) {
            StringBuilder sbA2 = hd.j.a("resendH5PageStack_");
            App app = this.f31719d.getApp();
            sbA2.append(app != null ? app.getAppId() : null);
            bVar.a(sbA2.toString());
        }
        ((IOnRenderProcessGoneProxy) tc.a.a(IOnRenderProcessGoneProxy.class)).unRegister(this);
        uc.b eventCenterInstance = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(this.f31719d.getApp());
        if (eventCenterInstance != null) {
            eventCenterInstance.a(WorkerManager.f32140n.a());
        }
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        String str2 = this.H;
        PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_CHAIN_CLEAR;
        Bundle bundle = new Bundle();
        bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.L, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.M, String.valueOf(this.f31732r));
        bundle.putString("miniapp_id", this.H);
        bundle.putString("queryShortcutExist", String.valueOf(AppUtils.f31011a.v(this, this.H)));
        Unit unit = Unit.f68710a;
        performanceAnalyseProxy.record(str2, pointAnalyseType, "clear", bundle);
        PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        String str3 = this.H;
        PointAnalyseType pointAnalyseType2 = PointAnalyseType.POINT_APP_CHAIN_CLEAR;
        Bundle bundle2 = new Bundle();
        bundle2.putString("openMiniAppFailedReason", "关闭");
        performanceAnalyseProxy2.record(str3, pointAnalyseType2, "clear", bundle2);
        ((IScreenInspectProxy) tc.a.a(IScreenInspectProxy.class)).appDestroy(this.f31719d.getApp());
        ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).clearDownloadCall();
        PrepareController prepareController = this.F;
        if (prepareController != null) {
            prepareController.finish();
        }
        this.F = null;
        PrepareController prepareController2 = this.G;
        if (prepareController2 != null) {
            prepareController2.finish();
        }
        this.G = null;
        App app2 = this.f31719d.getApp();
        long jA = (app2 == null || (hVar = (lb.h) app2.getData(lb.h.class)) == null) ? 0L : hVar.a();
        if (jA > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - jA;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("[MiniAppActivity]: app usageTime:");
            sb3.append(jElapsedRealtime);
            sb3.append(" ms, appId:");
            App app3 = this.f31719d.getApp();
            sb3.append(app3 != null ? app3.getAppId() : null);
            TmcLogger.b(sb3.toString());
            PerformanceAnalyseProxy performanceAnalyseProxy3 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            String str4 = this.H;
            PointAnalyseType pointAnalyseTypePutData = PointAnalyseType.POINT_EXIT_MINIAPP.putData("usageTime", Long.valueOf(jElapsedRealtime));
            App app4 = this.f31719d.getApp();
            PointAnalyseType pointAnalyseTypePutData2 = pointAnalyseTypePutData.putData("miniappId", app4 != null ? app4.getAppId() : null).putData("miniapp_id", this.H);
            App app5 = this.f31719d.getApp();
            PointAnalyseType pointAnalyseTypePutData3 = pointAnalyseTypePutData2.putData("scene", (app5 == null || (startParams2 = app5.getStartParams()) == null) ? null : startParams2.getString(TrackingKey.SCENE_ID, "100000"));
            App app6 = this.f31719d.getApp();
            performanceAnalyseProxy3.record(str4, pointAnalyseTypePutData3.putData("fis_type", (app6 == null || (startParams = app6.getStartParams()) == null) ? null : startParams.getString("fis_type", "0")), "");
        }
        App app7 = this.f31719d.getApp();
        if (app7 != null && (appId = app7.getAppId()) != null) {
            ((IAdManagerProxy) tc.a.a(IAdManagerProxy.class)).onDestroy(appId);
        }
        this.f31719d.onDestroy();
        PopWindowManager.f31020a.b(y0());
        try {
            TypeIntrinsics.d(o.f31082a.f()).remove(this.H);
            IUpdateLoadingStepProxy iUpdateLoadingStepProxy = (IUpdateLoadingStepProxy) tc.a.a(IUpdateLoadingStepProxy.class);
            String str5 = this.H;
            if (str5 != null) {
                str = str5;
            }
            iUpdateLoadingStepProxy.removeUpdateLoadingListener(str);
            ((TmcResourceManager) tc.a.a(TmcResourceManager.class)).clearDownloadAppMap();
            App app8 = this.f31719d.getApp();
            if (app8 != null) {
                app8.setMiniappLifecycleCallback(null);
            }
            App app9 = this.f31719d.getApp();
            if (app9 != null) {
                app9.setAddhomeShowCallback(null);
            }
            com.cloud.tmc.kernel.utils.e.a(ExecutorType.IO, new Runnable() { // from class: qd.v
                @Override // java.lang.Runnable
                public final void run() {
                    OooO0OO.O0();
                }
            });
        } catch (Throwable th3) {
            TmcLogger.h("MiniAppActivity", th3);
        }
        ((PerformanceImprovesProxy) tc.a.a(PerformanceImprovesProxy.class)).clearPerformanceImproves(this.H);
        Bundle bundle3 = new Bundle();
        bundle3.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31208e0, "关闭");
        new cb.a(bundle3).f(this.f31718c);
        this.f31718c.e(new Bundle());
        ((SessionUtilProxy) tc.a.a(SessionUtilProxy.class)).removeSession(this.H);
        ((VirtualAppManager) tc.a.a(VirtualAppManager.class)).exitApp(((VirtualAppManager) tc.a.a(VirtualAppManager.class)).findApp(this.H));
        String str6 = this.H;
        if (str6 != null) {
            kb.a.f68517a.i(str6);
        }
        f0 f0Var = f0.f31050a;
        f0Var.o(this.H, false);
        f0Var.m(this.H);
        try {
            PrivacyBridge.Companion.getClass();
            if (PrivacyBridge.OooO0O0.containsKey(this.H)) {
                TmcLogger.c("MiniAppActivity", "removePrivacyDialog appId = " + this.H);
                TypeIntrinsics.d(PrivacyBridge.OooO0O0).remove(this.H);
            }
            com.cloud.tmc.kernel.extension.e extensionManager = TmcInitializer.getExtensionManager();
            DefaultExtensionManager defaultExtensionManager = extensionManager instanceof DefaultExtensionManager ? (DefaultExtensionManager) extensionManager : null;
            Map<Node, Map<String, com.cloud.tmc.kernel.extension.c>> mapL = defaultExtensionManager != null ? defaultExtensionManager.l() : null;
            if (mapL != null) {
                for (Node node : mapL.keySet()) {
                    String str7 = this.H;
                    if (str7 != null) {
                        AppNode appNode = node instanceof AppNode ? (AppNode) node : null;
                        if (Intrinsics.b(appNode != null ? appNode.getAppId() : null, str7)) {
                            mapL.remove(node);
                            TmcLogger.c("MiniAppActivity", "nodeExtensionMap remove " + node);
                        }
                    }
                }
                TmcLogger.c("MiniAppActivity", "nodeExtensionMap size ->" + mapL.size());
            }
        } catch (Throwable th4) {
            TmcLogger.g("MiniAppActivity", "privacyDialogMap", th4);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i11, KeyEvent keyEvent) {
        TmcFragment tmcFragmentA;
        com.cloud.tmc.integration.ui.fragment.a aVarK;
        TmcLogger.b("[MiniActivity]：onKeyUp()");
        if (keyEvent == null || keyEvent.getKeyCode() != 4 || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0 && K0()) {
            return true;
        }
        App app = this.f31719d.getApp();
        tb.b appContext = app != null ? app.getAppContext() : null;
        com.cloud.tmc.integration.structure.app.a aVar = appContext instanceof com.cloud.tmc.integration.structure.app.a ? (com.cloud.tmc.integration.structure.app.a) appContext : null;
        if (aVar == null || (aVarK = aVar.k()) == null) {
            tmcFragmentA = null;
        } else {
            App app2 = this.f31719d.getApp();
            tmcFragmentA = aVarK.a(app2 != null ? app2.getActivePage() : null);
        }
        MiniAppBaseFragment miniAppBaseFragment = tmcFragmentA instanceof MiniAppBaseFragment ? (MiniAppBaseFragment) tmcFragmentA : null;
        if (miniAppBaseFragment != null && miniAppBaseFragment.f1()) {
            return true;
        }
        try {
            return this.f31719d.onKeyUp(i11, keyEvent);
        } catch (Throwable th2) {
            TmcLogger.h("MiniAppActivity", th2);
            return false;
        }
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        o0(intent);
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        kd.k.a(hd.j.a("onPause: "), this.H, "MiniAppActivity");
        this.f31719d.onPause();
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f31736v = jCurrentTimeMillis;
        long j11 = this.f31735u;
        if (j11 == 0) {
            this.f31734t = (jCurrentTimeMillis - this.f31733s) + this.f31734t;
        } else {
            this.f31734t = (jCurrentTimeMillis - j11) + this.f31734t;
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.renderprocess.IOnRenderProcessGoneProxy.a
    public void onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        App app;
        StringBuilder sbA = hd.j.a("miniappId=");
        ActivityHelper activityHelper = this.f31719d;
        sbA.append((activityHelper == null || (app = activityHelper.getApp()) == null) ? null : app.getAppId());
        sbA.append(" is Destroy by onRenderProcessGone");
        TmcLogger.f("onRenderProcessGone", sbA.toString());
        MiniAppLaunch.f31784a.e0(this.H, "4");
        e0(this, TmcFragment.ExitType.CLOSE_APP, false, 2, null);
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        String str;
        String str2;
        String str3;
        super.onResume();
        kd.k.a(hd.j.a("onResume: "), this.H, "MiniAppActivity");
        String str4 = this.H;
        if (str4 != null) {
            ((SessionUtilProxy) tc.a.a(SessionUtilProxy.class)).updateSession(str4, this.f31728n, false);
            this.f31728n = true;
            hd.k.a("onResume:checkTaskId:", str4, "MiniAppActivity");
            NewTaskManager.Companion companion = NewTaskManager.f31301b;
            companion.getInstance().i(str4, getClass());
            String str5 = this.H;
            if (str5 == null) {
                str5 = "";
            }
            if (companion.getInstance().j(this.H)) {
                str5 = this.N;
            } else {
                str4 = "";
            }
            companion.getInstance().A(str5, str4);
            companion.getInstance().d(this.H);
        }
        this.f31719d.onResume();
        try {
            p011Oooo00o.o000oOoO.f221a.a().a();
        } catch (Throwable th2) {
            TmcLogger.g("NormalTaskQueueUtils", "", th2);
        }
        Intrinsics.g(this, "<this>");
        try {
            StatusLayout statusLayout = getStatusLayout();
            if (statusLayout != null && statusLayout.OooOOOo) {
                getStatusLayout();
            }
        } catch (Throwable unused) {
        }
        this.f31735u = System.currentTimeMillis();
        try {
            AddHomeCustomTopTipView addHomeCustomTopTipViewE0 = E0();
            if (addHomeCustomTopTipViewE0 != null && (str3 = this.H) != null && addHomeCustomTopTipViewE0.f31921OooO0oo) {
                addHomeCustomTopTipViewE0.f31921OooO0oo = false;
                addHomeCustomTopTipViewE0.OooO00o(str3, addHomeCustomTopTipViewE0.OooO0oO, addHomeCustomTopTipViewE0.f31917OooO);
            }
            AddHomeCustomBottomTipView addHomeCustomBottomTipViewO = O();
            if (addHomeCustomBottomTipViewO != null && (str2 = this.H) != null) {
                TmcLogger.c(addHomeCustomBottomTipViewO.OooO0oO, "checkAddHomeBottomTipStatus");
                if (addHomeCustomBottomTipViewO.f31913OooOO0) {
                    addHomeCustomBottomTipViewO.f31913OooOO0 = false;
                    addHomeCustomBottomTipViewO.OooO00o(str2, addHomeCustomBottomTipViewO.f31908OooO, addHomeCustomBottomTipViewO.OooOO0O);
                }
            }
            MiniAddHomeTipDialogView miniAddHomeTipDialogViewQ0 = q0();
            if (miniAddHomeTipDialogViewQ0 != null && (str = this.H) != null && miniAddHomeTipDialogViewQ0.OooOO0O) {
                miniAddHomeTipDialogViewQ0.OooOO0O = false;
                miniAddHomeTipDialogViewQ0.OooO00o(str, miniAddHomeTipDialogViewQ0.f31929OooOO0, miniAddHomeTipDialogViewQ0.f31930OooOO0o);
            }
        } catch (Throwable th3) {
            TmcLogger.h("MiniAppActivity", th3);
        }
        statusLayoutOnResume();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.g(outState, "outState");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onSaveInstanceState");
        kd.k.a(sb2, this.H, "MiniAppActivity");
        outState.putString("miniAppId", this.H);
        outState.putString("mode", this.I);
        outState.putString("version", this.J);
        outState.putString("sign", this.K);
        super.onSaveInstanceState(outState);
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        lb.c cVar;
        super.onStart();
        StringBuilder sbA = hd.j.a("onStart: ");
        sbA.append(this.H);
        TmcLogger.c("MiniAppActivity", sbA.toString());
        ((OfflineAppProxy) tc.a.a(OfflineAppProxy.class)).addShortCutListener(this);
        App app = this.f31719d.getApp();
        if (app == null || (cVar = (lb.c) app.getData(lb.c.class)) == null) {
            return;
        }
        cVar.d();
        cVar.a();
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Bundle sceneParams;
        Bundle startParams;
        lb.c cVar;
        super.onStop();
        this.f31719d.onStop();
        App app = this.f31719d.getApp();
        if (app != null && (cVar = (lb.c) app.getData(lb.c.class)) != null) {
            try {
                lb.b bVarC = cVar.c();
                PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
                String str = this.H;
                PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_MINIAPP_FOREGROUND_TIME;
                Bundle bundle = new Bundle();
                bundle.putString("foregroundRandomId", bVarC.c());
                bundle.putLong("foregroundStartTime", bVarC.e());
                bundle.putLong("foregroundEndTime", bVarC.b());
                bundle.putLong("foregroundTime", bVarC.a());
                bundle.putInt("foregroundStartCount", bVarC.d());
                App app2 = this.f31719d.getApp();
                String homePagePath = app2 != null ? app2.getHomePagePath() : null;
                if (homePagePath == null) {
                    homePagePath = "";
                }
                bundle.putString("page_path", homePagePath);
                Unit unit = Unit.f68710a;
                performanceAnalyseProxy.record(str, pointAnalyseType, "", bundle);
            } catch (Throwable th2) {
                TmcLogger.g("MiniAppActivity", "Failed to report foreground time", th2);
            }
        }
        App app3 = this.f31719d.getApp();
        if (app3 != null && (startParams = app3.getStartParams()) != null) {
            startParams.remove("openMCScene");
        }
        App app4 = this.f31719d.getApp();
        if (app4 != null && (sceneParams = app4.getSceneParams()) != null) {
            sceneParams.remove("openMCScene");
        }
        ((OfflineAppProxy) tc.a.a(OfflineAppProxy.class)).removeShortCutListener(this);
    }

    @Override // ua.c
    public void p(String str) {
        ua.c.a.c(this, str);
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.r
    public void q(final Intent intent) {
        TmcLogger.c("MiniAppActivity", "startApp");
        runOnUiThread(new Runnable() { // from class: qd.u
            @Override // java.lang.Runnable
            public final void run() {
                OooO0OO.b0(this.f74550a, intent);
            }
        });
    }

    public final MiniAddHomeTipDialogView q0() {
        return (MiniAddHomeTipDialogView) this.f31726l.getValue();
    }

    public final OooOOO s0() {
        return (OooOOO) this.E.getValue();
    }

    public boolean showComplete() {
        return i.a.c(this);
    }

    public void showCustomErrorLayout(String str, String str2, String str3, StatusLayout.b bVar, String str4, StatusLayout.a aVar) {
        i.a.d(this, str, str2, str3, bVar, str4, aVar);
    }

    @Override // id.i
    public void showError(StatusLayout.b bVar, @StringRes int i11, String str, String str2, StatusLayout.a aVar) {
        i.a.e(this, bVar, i11, str, str2, aVar);
    }

    @Override // id.i
    public void showErrorLayout(int i11, @StringRes int i12, @StringRes int i13, StatusLayout.b bVar, boolean z11, boolean z12, StatusLayout.a aVar) {
        i.a.g(this, i11, i12, i13, bVar, z11, z12, aVar);
    }

    @Override // id.i
    public void showErrorLayout(int i11, @StringRes int i12, StatusLayout.b bVar, String str, StatusLayout.a aVar) {
        i.a.h(this, i11, i12, bVar, str, aVar);
    }

    @Override // id.i
    public void showErrorLayout(Drawable drawable, CharSequence charSequence, StatusLayout.b bVar, String str, StatusLayout.a aVar) {
        i.a.i(this, drawable, charSequence, bVar, str, aVar);
    }

    @Override // id.i
    public void showErrorLayout(Drawable drawable, CharSequence charSequence, CharSequence charSequence2, StatusLayout.b bVar, String str, boolean z11, boolean z12, StatusLayout.a aVar) {
        i.a.j(this, drawable, charSequence, charSequence2, bVar, str, z11, z12, aVar);
    }

    public void showLoading() {
        i.a.o(this);
    }

    public void showLoadingLogo(String str, String str2) {
        i.a.p(this, str, str2);
    }

    @Override // id.i
    public void showNoNetwork(StatusLayout.b bVar, @StringRes int i11, String str, String str2, StatusLayout.a aVar) {
        i.a.r(this, bVar, i11, str, str2, aVar);
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void showStatusLoading() {
        getHandler().post(new Runnable() { // from class: qd.b0
            @Override // java.lang.Runnable
            public final void run() {
                OooO0OO.D0(this.f74497a);
            }
        });
    }

    @Override // id.i
    public void showUnstableNetwork(StatusLayout.b bVar, @StringRes int i11, String str, String str2, StatusLayout.a aVar) {
        i.a.u(this, bVar, i11, str, str2, aVar);
    }

    public void statusLayoutCreateShortCutsSuccess(String str, Function3<? super String, ? super String, ? super String, Unit> function3) {
        i.a.w(this, str, function3);
    }

    public void statusLayoutOnResume() {
        i.a.x(this);
    }

    public final CapsuleView u0() {
        return (CapsuleView) this.f31720f.getValue();
    }

    public void updateStepAnimation(LoadStepAction loadStepAction) {
        i.a.y(this, loadStepAction);
    }

    public final d0.a w0() {
        return (d0.a) this.f31738x.getValue();
    }

    @Override // ua.c
    public void x() {
        ua.c.a.b(this);
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.r
    public void y(Intent intent) {
        TmcLogger.c("MiniAppActivity", "startAsyncApp");
        try {
            App app = this.f31719d.getApp();
            if (app != null) {
                StartClientBundle startClientBundle = (StartClientBundle) com.cloud.tmc.kernel.utils.a.d(intent.getExtras(), "startBundle");
                AppModel appModel = (AppModel) com.cloud.tmc.kernel.utils.a.d(intent.getExtras(), "startAppModel");
                if (appModel != null) {
                    app.updateAppModel(appModel);
                }
                final AppNode appNode = app instanceof AppNode ? (AppNode) app : null;
                if (appNode != null) {
                    TmcLogger.c("MiniAppActivity", "startAsyncApp success");
                    appNode.setAsyncLaunchStatus(true);
                    appNode.setmStartParams(startClientBundle.startParams);
                    appNode.setmSceneParams(startClientBundle.sceneParams);
                    AppLoadResult appLoadResult = (AppLoadResult) com.cloud.tmc.kernel.utils.a.d(startClientBundle.sceneParams, "appLoadResult");
                    appNode.setmAppLoadResult(appLoadResult);
                    app.setData(AppLoadResult.class, appLoadResult);
                    String backToPagePath = appNode.getBackToPagePath();
                    Intrinsics.f(backToPagePath, "appNode.backToPagePath");
                    if (backToPagePath.length() > 0) {
                        getHandler().post(new Runnable() { // from class: qd.h0
                            @Override // java.lang.Runnable
                            public final void run() {
                                OooO0OO.V(appNode);
                            }
                        });
                    }
                }
            }
        } catch (Throwable th2) {
            TmcLogger.g("MiniAppActivity", "startAsyncApp", th2);
        }
    }

    public final String y0() {
        return (String) this.f31737w.getValue();
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.r
    public void z(PrepareData prepareData, final PrepareException prepareException) {
        if (this.L && this.M && this.B == null) {
            this.B = prepareException;
            return;
        }
        StringBuilder sbA = hd.j.a("loadError errorCode: ");
        sbA.append(prepareException != null ? prepareException.getCode() : null);
        sbA.append(" errorMessage: ");
        sbA.append(prepareException != null ? prepareException.getMessage() : null);
        sbA.append(", Just print: ");
        sbA.append(Log.getStackTraceString(prepareException));
        TmcLogger.f("MiniAppActivity", sbA.toString());
        App app = this.f31719d.getApp();
        if (app != null) {
            app.setMiniAppLoadStatus(false);
        }
        new ya.a(new Bundle()).f(this.f31718c);
        getHandler().post(new Runnable() { // from class: qd.q
            @Override // java.lang.Runnable
            public final void run() {
                OooO0OO.X(prepareException, this);
            }
        });
    }
}
