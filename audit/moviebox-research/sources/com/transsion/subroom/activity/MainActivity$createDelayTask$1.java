package com.transsion.subroom.activity;

import android.app.Application;
import androidx.core.view.PointerIconCompat;
import androidx.lifecycle.Lifecycle;
import com.cloud.tupdate.TUpdate;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tn.lib.util.device.TNDeviceHelper;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsion.push.helper.PushPermanentManager;
import com.transsion.push.utils.NotificationUtil;
import com.transsion.startup.pref.al.UpdateUtils;
import com.transsion.usercenter.setting.labelsfeedback.sender.FBSender;
import com.transsnet.downloader.manager.DownloadInterceptManager;
import com.transsnet.downloader.notification.DownloadNotificationUtils;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.DiffUpdateResultEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.r0;
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
@DebugMetadata(c = "com.transsion.subroom.activity.MainActivity$createDelayTask$1", f = "MainActivity.kt", l = {1005, PointerIconCompat.TYPE_GRABBING}, m = "invokeSuspend")
@SourceDebugExtension
public final class MainActivity$createDelayTask$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MainActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$createDelayTask$1(MainActivity mainActivity, Continuation<? super MainActivity$createDelayTask$1> continuation) {
        super(2, continuation);
        this.this$0 = mainActivity;
    }

    public static final void i(MainActivity mainActivity) {
        mainActivity.l0().j(mainActivity);
    }

    public static final void j() {
        DownloadInterceptManager.f61008a.a().g();
    }

    public static final void k() {
        DownloadNotificationUtils.f61068a.C();
    }

    public static final void l(MainActivity mainActivity) {
        PushPermanentManager.f56895a.o();
        NotificationUtil.v(NotificationUtil.f57032a, mainActivity, null, null, false, 14, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivity$createDelayTask$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((MainActivity$createDelayTask$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String value;
        Boolean boolY0;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 != 0) {
            if (i11 == 1) {
                ResultKt.b(obj);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            com.tn.lib.thread.d dVar = com.tn.lib.thread.d.f49437a;
            dVar.b(new Runnable() { // from class: com.transsion.subroom.activity.j
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity$createDelayTask$1.j();
                }
            });
            dVar.b(new Runnable() { // from class: com.transsion.subroom.activity.k
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity$createDelayTask$1.k();
                }
            });
            final MainActivity mainActivity = this.this$0;
            dVar.b(new Runnable() { // from class: com.transsion.subroom.activity.l
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity$createDelayTask$1.l(mainActivity);
                }
            });
            FBSender fBSender = FBSender.f59746a;
            Application application = this.this$0.getApplication();
            Intrinsics.f(application, "application");
            fBSender.f(application);
            this.this$0.f58005q = true;
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        com.tn.lib.thread.d dVar2 = com.tn.lib.thread.d.f49437a;
        final MainActivity mainActivity2 = this.this$0;
        dVar2.b(new Runnable() { // from class: com.transsion.subroom.activity.i
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity$createDelayTask$1.i(mainActivity2);
            }
        });
        this.label = 1;
        if (r0.a(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS, this) == objE) {
            return objE;
        }
        UpdateUtils updateUtils = UpdateUtils.f57967a;
        if (updateUtils.c()) {
            UpdateUtils.g(updateUtils, "main_page", null, 2, null);
            final MainActivity mainActivity3 = this.this$0;
            Function1<DiffUpdateResultEvent, Unit> function1 = new Function1<DiffUpdateResultEvent, Unit>() { // from class: com.transsion.subroom.activity.MainActivity$createDelayTask$1.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DiffUpdateResultEvent diffUpdateResultEvent) {
                    invoke2(diffUpdateResultEvent);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DiffUpdateResultEvent it) {
                    Intrinsics.g(it, "it");
                    mainActivity3.H0(it.getHasUpdate());
                }
            };
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = DiffUpdateResultEvent.class.getName();
            Intrinsics.f(name, "T::class.java.name");
            flowEventBus.observeEvent(mainActivity3, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
        } else {
            ConfigBean configBeanB = ConfigManager.f53111c.a().b("key_auto_update_dialog", true);
            if (configBeanB != null && (value = configBeanB.getValue()) != null && (boolY0 = StringsKt__StringsKt.Y0(value)) != null && boolY0.booleanValue()) {
                TUpdate.f32174c.c(this.this$0).f(TNDeviceHelper.f49455a.g()).g();
            }
        }
        this.label = 2;
        if (r0.a(3000L, this) == objE) {
            return objE;
        }
        com.tn.lib.thread.d dVar3 = com.tn.lib.thread.d.f49437a;
        dVar3.b(new Runnable() { // from class: com.transsion.subroom.activity.j
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity$createDelayTask$1.j();
            }
        });
        dVar3.b(new Runnable() { // from class: com.transsion.subroom.activity.k
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity$createDelayTask$1.k();
            }
        });
        final MainActivity mainActivity4 = this.this$0;
        dVar3.b(new Runnable() { // from class: com.transsion.subroom.activity.l
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity$createDelayTask$1.l(mainActivity4);
            }
        });
        FBSender fBSender2 = FBSender.f59746a;
        Application application2 = this.this$0.getApplication();
        Intrinsics.f(application2, "application");
        fBSender2.f(application2);
        this.this$0.f58005q = true;
        return Unit.f68710a;
    }
}
