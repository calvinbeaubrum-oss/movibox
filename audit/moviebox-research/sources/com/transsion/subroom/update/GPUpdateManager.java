package com.transsion.subroom.update;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.view.View;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.play.core.install.InstallState;
import com.transsion.baselib.report.RoomActivityLifecycleCallbacks;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baselib.report.m;
import com.transsion.baseui.activity.BaseCommonActivity;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsion.subroom.R$string;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.k;

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
public final class GPUpdateManager {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f58070c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.google.android.play.core.appupdate.b f58071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final cj.a f58072b = new cj.a() { // from class: com.transsion.subroom.update.a
        @Override // ej.a
        public final void a(InstallState installState) {
            GPUpdateManager.m(this.f58073a, installState);
        }
    };

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final void k(Function1 tmp0, Object obj) {
        Intrinsics.g(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void l(Exception it) {
        Intrinsics.g(it, "it");
        uo.b.a.f(uo.b.f78622a, "GPUpdateManager", String.valueOf(it.getMessage()), false, 4, null);
    }

    public static final void m(GPUpdateManager this$0, InstallState state) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(state, "state");
        if (state.c() == 11) {
            this$0.o();
        }
    }

    public static final void p(GPUpdateManager this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        com.google.android.play.core.appupdate.b bVar = this$0.f58071a;
        if (bVar != null) {
            bVar.c();
        }
    }

    public static final void q(GPUpdateManager this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        m.f51277a.m("gp_update_dialog", "click", new HashMap());
        com.google.android.play.core.appupdate.b bVar = this$0.f58071a;
        if (bVar != null) {
            bVar.c();
        }
    }

    public final boolean i() {
        String value;
        Long lN;
        String value2;
        Boolean boolY0;
        ConfigManager.a aVar = ConfigManager.f53111c;
        ConfigBean configBeanC = ConfigManager.c(aVar.a(), "app_update_switch", false, 2, null);
        boolean zBooleanValue = (configBeanC == null || (value2 = configBeanC.getValue()) == null || (boolY0 = StringsKt__StringsKt.Y0(value2)) == null) ? false : boolY0.booleanValue();
        uo.b.a aVar2 = uo.b.f78622a;
        uo.b.a.f(aVar2, "GPUpdateManager", "appUpdateSwitch=" + zBooleanValue, false, 4, null);
        if (!zBooleanValue) {
            return false;
        }
        RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
        if (roomAppMMKV.a().getBoolean("k_first_started", true)) {
            roomAppMMKV.a().putBoolean("k_first_started", false);
            return false;
        }
        long jLongValue = 0;
        long j11 = 86400000;
        long j12 = roomAppMMKV.a().getLong("app_update_show_time", 0L) / j11;
        ConfigBean configBeanC2 = ConfigManager.c(aVar.a(), "app_update_interval_days", false, 2, null);
        if (configBeanC2 != null && (value = configBeanC2.getValue()) != null && (lN = k.n(value)) != null) {
            jLongValue = lN.longValue();
        }
        long j13 = jLongValue;
        long jCurrentTimeMillis = System.currentTimeMillis() / j11;
        uo.b.a.f(aVar2, "GPUpdateManager", "appUpdateIntervalDays=" + j13, false, 4, null);
        return jCurrentTimeMillis - j12 > j13;
    }

    public final void j(final Activity activity) {
        Intrinsics.g(activity, "activity");
        com.google.android.play.core.appupdate.b bVarA = com.google.android.play.core.appupdate.c.a(activity);
        this.f58071a = bVarA;
        Task<com.google.android.play.core.appupdate.a> taskD = bVarA != null ? bVarA.d() : null;
        if (taskD != null) {
            final Function1<com.google.android.play.core.appupdate.a, Unit> function1 = new Function1<com.google.android.play.core.appupdate.a, Unit>() { // from class: com.transsion.subroom.update.GPUpdateManager$checkAppUpdate$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.google.android.play.core.appupdate.a aVar) throws IntentSender.SendIntentException {
                    invoke2(aVar);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(com.google.android.play.core.appupdate.a aVar) throws IntentSender.SendIntentException {
                    uo.b.a aVar2 = uo.b.f78622a;
                    uo.b.a.f(aVar2, "GPUpdateManager", "start installStatus=" + aVar.a() + " available=" + aVar.d() + " allow=" + aVar.b(0), false, 4, null);
                    if (aVar.a() == 11) {
                        this.this$0.o();
                        return;
                    }
                    if (aVar.d() == 2 && aVar.b(0) && this.this$0.i()) {
                        uo.b.a.f(aVar2, "GPUpdateManager", "canShow", false, 4, null);
                        m.f51277a.t("gp_update_dialog", "browse", new HashMap());
                        com.google.android.play.core.appupdate.b bVar = this.this$0.f58071a;
                        if (bVar != null) {
                            bVar.e(aVar, 0, activity, 65281);
                        }
                        RoomAppMMKV.f51271a.a().putLong("app_update_show_time", System.currentTimeMillis());
                    }
                }
            };
            taskD.addOnSuccessListener(new OnSuccessListener() { // from class: com.transsion.subroom.update.b
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    GPUpdateManager.k(function1, obj);
                }
            });
        }
        if (taskD != null) {
            taskD.addOnFailureListener(new OnFailureListener() { // from class: com.transsion.subroom.update.c
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    GPUpdateManager.l(exc);
                }
            });
        }
        r();
    }

    public final void n(int i11, int i12, Intent intent) {
    }

    public final void o() {
        Activity activityG = RoomActivityLifecycleCallbacks.f51239a.g();
        if (activityG == null || !(activityG instanceof BaseCommonActivity)) {
            return;
        }
        View root = ((BaseCommonActivity) activityG).getMViewBinding().getRoot();
        Snackbar snackbarN0 = Snackbar.n0(root, root.getContext().getString(R$string.install_tip), -2);
        snackbarN0.q0(root.getContext().getString(R$string.install_update), new View.OnClickListener() { // from class: com.transsion.subroom.update.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GPUpdateManager.p(this.f58075a, view);
            }
        });
        snackbarN0.H().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.subroom.update.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GPUpdateManager.q(this.f58076a, view);
            }
        });
        snackbarN0.X();
    }

    public final void r() {
        com.google.android.play.core.appupdate.b bVar = this.f58071a;
        if (bVar != null) {
            bVar.b(this.f58072b);
        }
    }

    public final void s() {
        com.google.android.play.core.appupdate.b bVar = this.f58071a;
        if (bVar != null) {
            bVar.a(this.f58072b);
        }
    }
}
