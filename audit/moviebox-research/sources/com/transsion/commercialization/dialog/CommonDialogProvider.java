package com.transsion.commercialization.dialog;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.h0;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.n;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.ad.bidding.base.o;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.bean.HomePopupEntity;
import com.transsion.bean.HomePopupInfo;
import com.transsion.bean.HomePopupRequestEntity;
import com.transsion.commercializationapi.ICommonDialogApi;
import com.transsion.fissionapi.IFissionProvider;
import com.transsion.memberapi.IMemberApi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import xq.k;
import xq.l;

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
@Route(path = "/commercialize/CommonDialogProvider")
@Metadata
@SourceDebugExtension
public final class CommonDialogProvider implements ICommonDialogApi {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f51624e = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TrendingFloatView f51625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f51626b = LazyKt__LazyJVMKt.b(new Function0<d>() { // from class: com.transsion.commercialization.dialog.CommonDialogProvider$service$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final d invoke() {
            return (d) NetServiceGenerator.f49399d.a().i(d.class);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<ViewGroup> f51627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f51628d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final void K1(ViewGroup it, CommonDialogProvider this$0, HomePopupEntity homePopupEntity) {
        Intrinsics.g(it, "$it");
        Intrinsics.g(this$0, "this$0");
        it.setVisibility(0);
        it.removeAllViews();
        if (this$0.f51625a == null) {
            Context context = it.getContext();
            Intrinsics.f(context, "it.context");
            this$0.f51625a = new TrendingFloatView(context);
        }
        TrendingFloatView trendingFloatView = this$0.f51625a;
        if (trendingFloatView != null) {
            l.f80683a.b(trendingFloatView);
            trendingFloatView.showData(homePopupEntity);
            it.addView(trendingFloatView, -1, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String L1() {
        String simpleName = CommonDialogProvider.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public static /* synthetic */ List N1(CommonDialogProvider commonDialogProvider, HomePopupEntity homePopupEntity, boolean z11, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        if ((i11 & 4) != 0) {
            str = "popup";
        }
        return commonDialogProvider.M1(homePopupEntity, z11, str);
    }

    public static final void S1(HomePopupEntity homePopupEntity, Function1 callback, Activity it) {
        Intrinsics.g(callback, "$callback");
        Intrinsics.g(it, "$it");
        new TaskCommonDialog().x0(homePopupEntity).w0(callback).j0(it, "TaskCommonDialog");
    }

    @Override // com.transsion.commercializationapi.ICommonDialogApi
    public void B0(final HomePopupEntity homePopupEntity, final Function1<? super Boolean, Unit> callback) {
        Intrinsics.g(callback, "callback");
        final Activity activityB = com.blankj.utilcode.util.a.b();
        if (activityB != null) {
            activityB.runOnUiThread(new Runnable() { // from class: com.transsion.commercialization.dialog.a
                @Override // java.lang.Runnable
                public final void run() {
                    CommonDialogProvider.S1(homePopupEntity, callback, activityB);
                }
            });
        }
    }

    @Override // com.transsion.commercializationapi.ICommonDialogApi
    public void G() {
        P1();
    }

    public final void I1(final HomePopupEntity homePopupEntity) {
        HomePopupInfo popup;
        uo.b.a aVar = uo.b.f78622a;
        uo.b.a.f(aVar, "zxb_popup", L1() + " --> analysisDialog() --> homePopup = " + homePopupEntity, false, 4, null);
        RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
        roomAppMMKV.a().putInt("global_dialog_request_interval_time", homePopupEntity != null ? homePopupEntity.getRequestInterval() : 3600);
        roomAppMMKV.a().putLong("global_dialog_request_time", System.currentTimeMillis() / ((long) 1000));
        Integer numValueOf = (homePopupEntity == null || (popup = homePopupEntity.getPopup()) == null) ? null : Integer.valueOf(popup.getType());
        if (numValueOf != null && numValueOf.intValue() == 1) {
            ((ICommonDialogApi) com.alibaba.android.arouter.launcher.a.d().h(ICommonDialogApi.class)).B0(homePopupEntity, new Function1<Boolean, Unit>() { // from class: com.transsion.commercialization.dialog.CommonDialogProvider$analysisDialog$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.f68710a;
                }

                public final void invoke(boolean z11) {
                    this.this$0.R1(homePopupEntity, z11, "TaskCommonDialog");
                }
            });
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 2) {
            IMemberApi iMemberApi = (IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class);
            if (iMemberApi.e1()) {
                iMemberApi.W(4, new Function2<Boolean, Boolean, Unit>() { // from class: com.transsion.commercialization.dialog.CommonDialogProvider$analysisDialog$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2) {
                        invoke(bool.booleanValue(), bool2.booleanValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(boolean z11, boolean z12) {
                        if (z11) {
                            this.this$0.Q1(homePopupEntity, "popup");
                        } else {
                            this.this$0.R1(homePopupEntity, z12, "MemberTaskCheckInDialog");
                        }
                    }
                });
                return;
            } else {
                Q1(homePopupEntity, "popup");
                return;
            }
        }
        if (numValueOf != null && numValueOf.intValue() == 3) {
            ((IFissionProvider) com.alibaba.android.arouter.launcher.a.d().h(IFissionProvider.class)).H(new Function2<Boolean, Boolean, Unit>() { // from class: com.transsion.commercialization.dialog.CommonDialogProvider$analysisDialog$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2) {
                    invoke(bool.booleanValue(), bool2.booleanValue());
                    return Unit.f68710a;
                }

                public final void invoke(boolean z11, boolean z12) {
                    if (z11) {
                        this.this$0.Q1(homePopupEntity, "popup");
                    } else {
                        this.this$0.R1(homePopupEntity, z12, "PalmPayActivityDialog");
                    }
                }
            });
            return;
        }
        uo.b.a.j(aVar, "zxb_popup", L1() + " --> analysisDialog() --> 当前类型没有实现", false, 4, null);
    }

    public final void J1(final HomePopupEntity homePopupEntity) {
        final ViewGroup viewGroup;
        if (homePopupEntity == null) {
            uo.b.a.j(uo.b.f78622a, "zxb_popup", L1() + " --> analysisWidget() --> widget = null --> return", false, 4, null);
            return;
        }
        uo.b.a aVar = uo.b.f78622a;
        uo.b.a.f(aVar, "zxb_popup", L1() + " --> analysisWidget() --> widget = " + homePopupEntity.getWidget(), false, 4, null);
        WeakReference<ViewGroup> weakReference = this.f51627c;
        if (weakReference != null && (viewGroup = weakReference.get()) != null) {
            viewGroup.post(new Runnable() { // from class: com.transsion.commercialization.dialog.b
                @Override // java.lang.Runnable
                public final void run() {
                    CommonDialogProvider.K1(viewGroup, this, homePopupEntity);
                }
            });
            return;
        }
        uo.b.a.j(aVar, "zxb_popup", L1() + " --> analysisWidget() --> mWidgetGroup?.get() = null", false, 4, null);
    }

    public final List<HomePopupRequestEntity> M1(HomePopupEntity homePopupEntity, boolean z11, String str) {
        RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
        String string = roomAppMMKV.a().getString("global_dialog_date", "");
        String strB = k.b(k.f80682a, Long.valueOf((homePopupEntity != null ? homePopupEntity.getTs() : 0L) * 1000), null, 2, null);
        if (TextUtils.equals(strB, string) || !z11) {
            String string2 = Intrinsics.b(str, "popup") ? roomAppMMKV.a().getString("global_dialog_history", null) : roomAppMMKV.a().getString("global_widget_history", null);
            if (string2 == null) {
                return new ArrayList();
            }
            Object objE = n.e(string2, n.g(HomePopupRequestEntity.class));
            Intrinsics.f(objE, "fromJson(\n              …class.java)\n            )");
            return (List) objE;
        }
        uo.b.a.j(uo.b.f78622a, "zxb_popup", L1() + " --> getDialogRecord() --> 不是同一天数据，return mutableListOf() --> currentDate = " + strB + " -- globalDialogDate = " + string + " --> 不是同一天数据，需要清空本地保存的数据", false, 4, null);
        if (Intrinsics.b(str, "popup")) {
            roomAppMMKV.a().putString("global_dialog_history", null);
        } else {
            roomAppMMKV.a().putString("global_widget_history", null);
        }
        return new ArrayList();
    }

    public final d O1() {
        return (d) this.f51626b.getValue();
    }

    public final void P1() {
        uo.b.a aVar = uo.b.f78622a;
        uo.b.a.g(aVar, "CommonDialogProvider getGlobalDialogStrategy() --> 已请求过策略,直接返回", false, 2, null);
        if (this.f51628d) {
            uo.b.a.f(aVar, "zxb_popup", L1() + " --> innerGetGlobalDialogStrategy() --> isShow = true --> 如果当前已经有弹窗了，那就不重复触发", false, 4, null);
            return;
        }
        if (!o.f50331a.b()) {
            j.d(l0.a(w0.b()), null, null, new CommonDialogProvider$innerGetGlobalDialogStrategy$1(this, null), 3, null);
            return;
        }
        uo.b.a.f(aVar, "zxb_popup", L1() + " --> innerGetGlobalDialogStrategy() --> 插屏广告 || 激励视频广告 正在展示 --> 当前不处理", false, 4, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final void Q1(HomePopupEntity homePopupEntity, String str) {
        HomePopupInfo widget;
        HomePopupInfo homePopupInfo;
        if (Intrinsics.b(str, "popup")) {
            if (homePopupEntity != null) {
                widget = homePopupEntity.getPopup();
                homePopupInfo = widget;
            } else {
                homePopupInfo = null;
            }
        } else if (homePopupEntity != null) {
            widget = homePopupEntity.getWidget();
            homePopupInfo = widget;
        } else {
            homePopupInfo = null;
        }
        if (homePopupInfo == null) {
            uo.b.a.j(uo.b.f78622a, "zxb_popup", L1() + " --> saveDialogRecord() --> popup == null --> 保存数据异常 -- type = " + str, false, 4, null);
            return;
        }
        List<HomePopupRequestEntity> listN1 = N1(this, homePopupEntity, false, str, 2, null);
        HomePopupRequestEntity homePopupRequestEntity = null;
        for (HomePopupRequestEntity homePopupRequestEntity2 : listN1) {
            if (homePopupRequestEntity2 != null && homePopupRequestEntity2.getId() == homePopupInfo.getId()) {
                homePopupRequestEntity = homePopupRequestEntity2;
            }
        }
        if (homePopupRequestEntity == null) {
            listN1.add(new HomePopupRequestEntity(homePopupInfo.getId(), Long.valueOf(homePopupEntity != null ? homePopupEntity.getTs() : 0L), 1));
        } else {
            homePopupRequestEntity.setCount(homePopupRequestEntity.getCount() + 1);
            homePopupRequestEntity.setTs(homePopupEntity != null ? Long.valueOf(homePopupEntity.getTs()) : null);
        }
        RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
        roomAppMMKV.a().putString(Intrinsics.b(str, "popup") ? "global_dialog_history" : "global_widget_history", n.j(listN1));
        roomAppMMKV.a().putString("global_dialog_date", k.b(k.f80682a, Long.valueOf((homePopupEntity != null ? homePopupEntity.getTs() : 0L) * 1000), null, 2, null));
        uo.b.a.f(uo.b.f78622a, "zxb_popup", L1() + " --> saveDialogRecord() --> type = " + str + " --> 展示记录保存 --> homePopup = " + homePopupEntity, false, 4, null);
    }

    public final void R1(HomePopupEntity homePopupEntity, boolean z11, String str) {
        this.f51628d = z11;
        uo.b.a.f(uo.b.f78622a, "zxb_popup", L1() + " --> setShowState() --> showState = " + z11 + " -- dialogName = " + str, false, 4, null);
        if (z11) {
            Q1(homePopupEntity, "popup");
        }
        oq.a.f72510a.c(this.f51628d);
    }

    @Override // com.transsion.commercializationapi.ICommonDialogApi
    public void b0(HomePopupEntity homePopupEntity) {
        Q1(homePopupEntity, "widget");
    }

    @Override // com.transsion.commercializationapi.ICommonDialogApi
    public void i0(FrameLayout frameLayout) {
        this.f51627c = new WeakReference<>(frameLayout);
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
    }

    @Override // com.transsion.commercializationapi.ICommonDialogApi
    public void onDestroy() {
        this.f51625a = null;
        WeakReference<ViewGroup> weakReference = this.f51627c;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f51627c = null;
    }

    @Override // com.transsion.commercializationapi.ICommonDialogApi
    public void v0() {
        uo.b.a.f(uo.b.f78622a, "zxb_popup", L1() + " --> addAppObserver() --> 监听App前后台状态 --> 全局弹窗控制", false, 4, null);
        h0.f8724j.a().getLifecycle().a(new MainAppLifecycleObserver());
    }
}
