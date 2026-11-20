package com.transsion.startup.pref.al;

import com.blankj.utilcode.util.c;
import com.transsion.baselib.report.RoomActivityLifecycleCallbacks;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.lib.diffupdate.DiffUpdateManager;
import com.transsion.lib.diffupdate.b;
import com.transsion.lib.diffupdate.e;
import com.transsion.lib.diffupdate.exception.CancelReason;
import com.transsion.lib.diffupdate.exception.UpdateException;
import com.transsion.lib.diffupdate.exception.UpdateStage;
import com.transsion.version.updatediff.DiffUpdateConfig;
import com.transsion.version.updatediff.DiffUpdateDialog;
import com.transsion.version.updatediff.UpdateConfig;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.DiffUpdateResultEvent;
import java.io.File;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.s;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class UpdateUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final UpdateUtils f57967a = new UpdateUtils();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static k0 f57968b = l0.a(w0.b());

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void g(UpdateUtils updateUtils, String str, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function1 = null;
        }
        updateUtils.f(str, function1);
    }

    public final void a(String fromPage, Function1<? super Boolean, Unit> function1) {
        Intrinsics.g(fromPage, "fromPage");
        if (!DiffUpdateConfig.f59770a.h()) {
            f(fromPage, function1);
            return;
        }
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
        h(fromPage);
    }

    public final void b() {
        e.f53052a.a(new UpdateConfig());
        RoomAppMMKV.f51271a.a().putInt("version_code", c.d());
    }

    public final boolean c() {
        return DiffUpdateConfig.f59770a.e();
    }

    public final k0 d() {
        return f57968b;
    }

    public final boolean e() {
        return DiffUpdateConfig.f59770a.h();
    }

    public final void f(final String fromPage, final Function1<? super Boolean, Unit> function1) {
        Intrinsics.g(fromPage, "fromPage");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        DiffUpdateManager diffUpdateManagerA = DiffUpdateManager.f52998o.a();
        diffUpdateManagerA.x(new b() { // from class: com.transsion.startup.pref.al.UpdateUtils$startCheckDiffUpdate$1$1
            @Override // com.transsion.lib.diffupdate.b
            public void a(final File installFile) {
                Intrinsics.g(installFile, "installFile");
                com.transsion.version.updatediff.c cVar = com.transsion.version.updatediff.c.f59779a;
                cVar.e(s.l(TuplesKt.a("finish_type", "success"), TuplesKt.a("finish_info", objectRef.element)));
                Function1<Boolean, Unit> function2 = function1;
                if (function2 != null) {
                    function2.invoke(Boolean.FALSE);
                }
                String path = installFile.getPath();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onSuccess: ");
                sb2.append(path);
                DiffUpdateConfig diffUpdateConfig = DiffUpdateConfig.f59770a;
                String absolutePath = installFile.getAbsolutePath();
                Intrinsics.f(absolutePath, "installFile.absolutePath");
                diffUpdateConfig.a(absolutePath);
                DiffUpdateResultEvent diffUpdateResultEvent = new DiffUpdateResultEvent(true);
                FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                String name = DiffUpdateResultEvent.class.getName();
                Intrinsics.f(name, "T::class.java.name");
                flowEventBus.postEvent(name, diffUpdateResultEvent, 0L);
                DiffUpdateDialog.a aVar = DiffUpdateDialog.f59771f;
                final String str = fromPage;
                DiffUpdateDialog diffUpdateDialogA = aVar.a(new Function1<Boolean, Unit>() { // from class: com.transsion.startup.pref.al.UpdateUtils$startCheckDiffUpdate$1$1$onSuccess$1
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
                        com.transsion.version.updatediff.c.f59779a.a(str, z11);
                        if (z11) {
                            DiffUpdateConfig.f59770a.g(installFile, str);
                        }
                    }
                });
                String str2 = fromPage;
                diffUpdateDialogA.j0(RoomActivityLifecycleCallbacks.f51239a.g(), DiffUpdateDialog.class.getSimpleName());
                cVar.g(str2);
            }

            @Override // com.transsion.lib.diffupdate.b
            public void b(com.transsion.lib.diffupdate.c remoteVersionInfo, Function1<? super Boolean, Unit> checkCall) {
                Intrinsics.g(remoteVersionInfo, "remoteVersionInfo");
                Intrinsics.g(checkCall, "checkCall");
                j.d(UpdateUtils.f57967a.d(), null, null, new UpdateUtils$startCheckDiffUpdate$1$1$blockUpdate$1(remoteVersionInfo, checkCall, null), 3, null);
            }

            /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.String] */
            @Override // com.transsion.lib.diffupdate.b
            public void c(UpdateStage stage) {
                Intrinsics.g(stage, "stage");
                objectRef.element = stage.toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onUpdateStageChange: ");
                sb2.append(stage);
            }

            @Override // com.transsion.lib.diffupdate.b
            public void d(UpdateException exception) {
                Intrinsics.g(exception, "exception");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onError: ");
                sb2.append(exception);
                Function1<Boolean, Unit> function2 = function1;
                if (function2 != null) {
                    function2.invoke(null);
                }
                com.transsion.version.updatediff.c.f59779a.c(s.l(TuplesKt.a("finish_type", "error"), TuplesKt.a("finish_info", String.valueOf(exception))));
            }

            @Override // com.transsion.lib.diffupdate.b
            public void e(CancelReason reason) {
                Intrinsics.g(reason, "reason");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onCancel: ");
                sb2.append(reason);
                com.transsion.version.updatediff.c.f59779a.c(s.l(TuplesKt.a("abort_type", "cancel"), TuplesKt.a("abort_reason", String.valueOf(reason))));
                Function1<Boolean, Unit> function2 = function1;
                if (function2 != null) {
                    function2.invoke(Boolean.TRUE);
                }
                if (reason == CancelReason.REASON_BLOCK) {
                    DiffUpdateResultEvent diffUpdateResultEvent = new DiffUpdateResultEvent(DiffUpdateConfig.f59770a.h());
                    FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                    String name = DiffUpdateResultEvent.class.getName();
                    Intrinsics.f(name, "T::class.java.name");
                    flowEventBus.postEvent(name, diffUpdateResultEvent, 0L);
                }
            }
        });
        diffUpdateManagerA.z();
        com.transsion.version.updatediff.c.f59779a.d();
        DiffUpdateConfig.f59770a.b(new Function1<Boolean, Unit>() { // from class: com.transsion.startup.pref.al.UpdateUtils$startCheckDiffUpdate$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z11) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("checkDiffUpdatePkgState: ");
                sb2.append(z11);
                Function1<Boolean, Unit> function2 = function1;
                if (function2 != null) {
                    function2.invoke(Boolean.FALSE);
                }
                if (z11) {
                    DiffUpdateConfig diffUpdateConfig = DiffUpdateConfig.f59770a;
                    if (diffUpdateConfig.i() && diffUpdateConfig.c()) {
                        UpdateUtils.f57967a.h(fromPage);
                    }
                }
                DiffUpdateResultEvent diffUpdateResultEvent = new DiffUpdateResultEvent(z11);
                FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                String name = DiffUpdateResultEvent.class.getName();
                Intrinsics.f(name, "T::class.java.name");
                flowEventBus.postEvent(name, diffUpdateResultEvent, 0L);
            }
        });
    }

    public final void h(final String fromPage) {
        Intrinsics.g(fromPage, "fromPage");
        DiffUpdateDialog.f59771f.a(new Function1<Boolean, Unit>() { // from class: com.transsion.startup.pref.al.UpdateUtils$startInstallProcess$1
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
                DiffUpdateConfig diffUpdateConfig;
                String strF;
                com.transsion.version.updatediff.c.f59779a.a(fromPage, z11);
                if (!z11 || (strF = (diffUpdateConfig = DiffUpdateConfig.f59770a).f()) == null) {
                    return;
                }
                diffUpdateConfig.g(new File(strF), fromPage);
            }
        }).j0(RoomActivityLifecycleCallbacks.f51239a.g(), DiffUpdateDialog.class.getSimpleName());
        com.transsion.version.updatediff.c.f59779a.g(fromPage);
    }
}
