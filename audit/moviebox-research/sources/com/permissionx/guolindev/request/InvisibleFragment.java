package com.permissionx.guolindev.request;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.permissionx.guolindev.PermissionX;
import com.permissionx.guolindev.dialog.RationaleDialog;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class InvisibleFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f48652a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PermissionBuilder f48653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f48654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b1.b<String[]> f48655d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b1.b<String> f48656f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b1.b<Intent> f48657g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b1.b<Intent> f48658h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b1.b<Intent> f48659i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b1.b<Intent> f48660j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b1.b<Intent> f48661k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b1.b<Intent> f48662l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b1.b<String> f48663m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b1.b<Intent> f48664n;

    public InvisibleFragment() {
        b1.b<String[]> bVarRegisterForActivityResult = registerForActivityResult(new c1.h(), new b1.a() { // from class: com.permissionx.guolindev.request.g
            @Override // b1.a
            public final void a(Object obj) {
                InvisibleFragment.Y0(this.f48688a, (Map) obj);
            }
        });
        Intrinsics.f(bVarRegisterForActivityResult, "registerForActivityResul…)\n            }\n        }");
        this.f48655d = bVarRegisterForActivityResult;
        b1.b<String> bVarRegisterForActivityResult2 = registerForActivityResult(new c1.i(), new b1.a() { // from class: com.permissionx.guolindev.request.i
            @Override // b1.a
            public final void a(Object obj) {
                InvisibleFragment.R0(this.f48690a, (Boolean) obj);
            }
        });
        Intrinsics.f(bVarRegisterForActivityResult2, "registerForActivityResul…)\n            }\n        }");
        this.f48656f = bVarRegisterForActivityResult2;
        b1.b<Intent> bVarRegisterForActivityResult3 = registerForActivityResult(new c1.j(), new b1.a() { // from class: com.permissionx.guolindev.request.j
            @Override // b1.a
            public final void a(Object obj) {
                InvisibleFragment.e1(this.f48691a, (ActivityResult) obj);
            }
        });
        Intrinsics.f(bVarRegisterForActivityResult3, "registerForActivityResul…)\n            }\n        }");
        this.f48657g = bVarRegisterForActivityResult3;
        b1.b<Intent> bVarRegisterForActivityResult4 = registerForActivityResult(new c1.j(), new b1.a() { // from class: com.permissionx.guolindev.request.k
            @Override // b1.a
            public final void a(Object obj) {
                InvisibleFragment.g1(this.f48692a, (ActivityResult) obj);
            }
        });
        Intrinsics.f(bVarRegisterForActivityResult4, "registerForActivityResul…)\n            }\n        }");
        this.f48658h = bVarRegisterForActivityResult4;
        b1.b<Intent> bVarRegisterForActivityResult5 = registerForActivityResult(new c1.j(), new b1.a() { // from class: com.permissionx.guolindev.request.l
            @Override // b1.a
            public final void a(Object obj) {
                InvisibleFragment.W0(this.f48693a, (ActivityResult) obj);
            }
        });
        Intrinsics.f(bVarRegisterForActivityResult5, "registerForActivityResul…)\n            }\n        }");
        this.f48659i = bVarRegisterForActivityResult5;
        b1.b<Intent> bVarRegisterForActivityResult6 = registerForActivityResult(new c1.j(), new b1.a() { // from class: com.permissionx.guolindev.request.m
            @Override // b1.a
            public final void a(Object obj) {
                InvisibleFragment.U0(this.f48694a, (ActivityResult) obj);
            }
        });
        Intrinsics.f(bVarRegisterForActivityResult6, "registerForActivityResul…)\n            }\n        }");
        this.f48660j = bVarRegisterForActivityResult6;
        b1.b<Intent> bVarRegisterForActivityResult7 = registerForActivityResult(new c1.j(), new b1.a() { // from class: com.permissionx.guolindev.request.n
            @Override // b1.a
            public final void a(Object obj) {
                InvisibleFragment.Z0(this.f48695a, (ActivityResult) obj);
            }
        });
        Intrinsics.f(bVarRegisterForActivityResult7, "registerForActivityResul…)\n            }\n        }");
        this.f48661k = bVarRegisterForActivityResult7;
        b1.b<Intent> bVarRegisterForActivityResult8 = registerForActivityResult(new c1.j(), new b1.a() { // from class: com.permissionx.guolindev.request.o
            @Override // b1.a
            public final void a(Object obj) {
                InvisibleFragment.c1(this.f48696a, (ActivityResult) obj);
            }
        });
        Intrinsics.f(bVarRegisterForActivityResult8, "registerForActivityResul…)\n            }\n        }");
        this.f48662l = bVarRegisterForActivityResult8;
        b1.b<String> bVarRegisterForActivityResult9 = registerForActivityResult(new c1.i(), new b1.a() { // from class: com.permissionx.guolindev.request.p
            @Override // b1.a
            public final void a(Object obj) {
                InvisibleFragment.S0(this.f48697a, (Boolean) obj);
            }
        });
        Intrinsics.f(bVarRegisterForActivityResult9, "registerForActivityResul…)\n            }\n        }");
        this.f48663m = bVarRegisterForActivityResult9;
        b1.b<Intent> bVarRegisterForActivityResult10 = registerForActivityResult(new c1.j(), new b1.a() { // from class: com.permissionx.guolindev.request.q
            @Override // b1.a
            public final void a(Object obj) {
                InvisibleFragment.E0(this.f48698a, (ActivityResult) obj);
            }
        });
        Intrinsics.f(bVarRegisterForActivityResult10, "registerForActivityResul…)\n            }\n        }");
        this.f48664n = bVarRegisterForActivityResult10;
    }

    public static final void E0(InvisibleFragment this$0, ActivityResult activityResult) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.C0()) {
            c cVar = this$0.f48654c;
            PermissionBuilder permissionBuilder = null;
            if (cVar == null) {
                Intrinsics.y("task");
                cVar = null;
            }
            PermissionBuilder permissionBuilder2 = this$0.f48653b;
            if (permissionBuilder2 == null) {
                Intrinsics.y("pb");
            } else {
                permissionBuilder = permissionBuilder2;
            }
            cVar.a(new ArrayList(permissionBuilder.f48680o));
        }
    }

    public static final void P0(Function0 callback) {
        Intrinsics.g(callback, "$callback");
        callback.invoke();
    }

    public static final void R0(final InvisibleFragment this$0, final Boolean bool) {
        Intrinsics.g(this$0, "this$0");
        this$0.O0(new Function0<Unit>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$requestBackgroundLocationLauncher$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                InvisibleFragment invisibleFragment = this.this$0;
                Boolean granted = bool;
                Intrinsics.f(granted, "granted");
                invisibleFragment.F0(granted.booleanValue());
            }
        });
    }

    public static final void S0(final InvisibleFragment this$0, final Boolean bool) {
        Intrinsics.g(this$0, "this$0");
        this$0.O0(new Function0<Unit>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$requestBodySensorsBackgroundLauncher$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                InvisibleFragment invisibleFragment = this.this$0;
                Boolean granted = bool;
                Intrinsics.f(granted, "granted");
                invisibleFragment.G0(granted.booleanValue());
            }
        });
    }

    public static final void U0(final InvisibleFragment this$0, ActivityResult activityResult) {
        Intrinsics.g(this$0, "this$0");
        this$0.O0(new Function0<Unit>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$requestInstallPackagesLauncher$1$1
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
                this.this$0.H0();
            }
        });
    }

    public static final void W0(final InvisibleFragment this$0, ActivityResult activityResult) {
        Intrinsics.g(this$0, "this$0");
        this$0.O0(new Function0<Unit>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$requestManageExternalStorageLauncher$1$1
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
                this.this$0.I0();
            }
        });
    }

    public static final void Y0(final InvisibleFragment this$0, final Map map) {
        Intrinsics.g(this$0, "this$0");
        this$0.O0(new Function0<Unit>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$requestNormalPermissionLauncher$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                InvisibleFragment invisibleFragment = this.this$0;
                Map<String, Boolean> grantResults = map;
                Intrinsics.f(grantResults, "grantResults");
                invisibleFragment.J0(grantResults);
            }
        });
    }

    public static final void Z0(final InvisibleFragment this$0, ActivityResult activityResult) {
        Intrinsics.g(this$0, "this$0");
        this$0.O0(new Function0<Unit>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$requestNotificationLauncher$1$1
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
                this.this$0.K0();
            }
        });
    }

    public static final void c1(final InvisibleFragment this$0, ActivityResult activityResult) {
        Intrinsics.g(this$0, "this$0");
        this$0.O0(new Function0<Unit>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$requestPipLauncher$1$1
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
                this.this$0.L0();
            }
        });
    }

    public static final void e1(final InvisibleFragment this$0, ActivityResult activityResult) {
        Intrinsics.g(this$0, "this$0");
        this$0.O0(new Function0<Unit>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$requestSystemAlertWindowLauncher$1$1
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
                this.this$0.M0();
            }
        });
    }

    public static final void g1(final InvisibleFragment this$0, ActivityResult activityResult) {
        Intrinsics.g(this$0, "this$0");
        this$0.O0(new Function0<Unit>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$requestWriteSettingsLauncher$1$1
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
                this.this$0.N0();
            }
        });
    }

    public final boolean C0() {
        if (this.f48653b != null && this.f48654c != null && getContext() != null) {
            return true;
        }
        Log.w("PermissionX", "PermissionBuilder and ChainTask should not be null at this time, so we can do nothing in this case.");
        return false;
    }

    public final void D0() {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", requireActivity().getPackageName(), null));
            this.f48664n.a(intent);
        } catch (Throwable unused) {
        }
    }

    public final void F0(final boolean z11) {
        if (C0()) {
            O0(new Function0<Unit>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$onRequestBackgroundLocationPermissionResult$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    c cVar = null;
                    if (z11) {
                        PermissionBuilder permissionBuilder = this.f48653b;
                        if (permissionBuilder == null) {
                            Intrinsics.y("pb");
                            permissionBuilder = null;
                        }
                        permissionBuilder.f48675j.add("android.permission.ACCESS_BACKGROUND_LOCATION");
                        PermissionBuilder permissionBuilder2 = this.f48653b;
                        if (permissionBuilder2 == null) {
                            Intrinsics.y("pb");
                            permissionBuilder2 = null;
                        }
                        permissionBuilder2.f48676k.remove("android.permission.ACCESS_BACKGROUND_LOCATION");
                        PermissionBuilder permissionBuilder3 = this.f48653b;
                        if (permissionBuilder3 == null) {
                            Intrinsics.y("pb");
                            permissionBuilder3 = null;
                        }
                        permissionBuilder3.f48677l.remove("android.permission.ACCESS_BACKGROUND_LOCATION");
                        c cVar2 = this.f48654c;
                        if (cVar2 == null) {
                            Intrinsics.y("task");
                        } else {
                            cVar = cVar2;
                        }
                        cVar.finish();
                        return;
                    }
                    boolean zShouldShowRequestPermissionRationale = this.shouldShowRequestPermissionRationale("android.permission.ACCESS_BACKGROUND_LOCATION");
                    PermissionBuilder permissionBuilder4 = this.f48653b;
                    if (permissionBuilder4 == null) {
                        Intrinsics.y("pb");
                        permissionBuilder4 = null;
                    }
                    permissionBuilder4.getClass();
                    PermissionBuilder permissionBuilder5 = this.f48653b;
                    if (permissionBuilder5 == null) {
                        Intrinsics.y("pb");
                        permissionBuilder5 = null;
                    }
                    if (permissionBuilder5.f48682q == null || !zShouldShowRequestPermissionRationale) {
                        PermissionBuilder permissionBuilder6 = this.f48653b;
                        if (permissionBuilder6 == null) {
                            Intrinsics.y("pb");
                            permissionBuilder6 = null;
                        }
                        permissionBuilder6.getClass();
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add("android.permission.ACCESS_BACKGROUND_LOCATION");
                        PermissionBuilder permissionBuilder7 = this.f48653b;
                        if (permissionBuilder7 == null) {
                            Intrinsics.y("pb");
                            permissionBuilder7 = null;
                        }
                        if (permissionBuilder7.f48682q == null) {
                            PermissionBuilder permissionBuilder8 = this.f48653b;
                            if (permissionBuilder8 == null) {
                                Intrinsics.y("pb");
                                permissionBuilder8 = null;
                            }
                            permissionBuilder8.getClass();
                            Intrinsics.d(null);
                            c cVar3 = this.f48654c;
                            if (cVar3 == null) {
                                Intrinsics.y("task");
                                cVar3 = null;
                            }
                            cVar3.b();
                            throw null;
                        }
                        PermissionBuilder permissionBuilder9 = this.f48653b;
                        if (permissionBuilder9 == null) {
                            Intrinsics.y("pb");
                            permissionBuilder9 = null;
                        }
                        ao.b bVar = permissionBuilder9.f48682q;
                        Intrinsics.d(bVar);
                        c cVar4 = this.f48654c;
                        if (cVar4 == null) {
                            Intrinsics.y("task");
                            cVar4 = null;
                        }
                        bVar.a(cVar4.b(), arrayList, false, false);
                        PermissionBuilder permissionBuilder10 = this.f48653b;
                        if (permissionBuilder10 == null) {
                            Intrinsics.y("pb");
                            permissionBuilder10 = null;
                        }
                        if (permissionBuilder10.f48673h) {
                            return;
                        }
                    }
                    c cVar5 = this.f48654c;
                    if (cVar5 == null) {
                        Intrinsics.y("task");
                    } else {
                        cVar = cVar5;
                    }
                    cVar.finish();
                }
            });
        }
    }

    public final void G0(final boolean z11) {
        if (C0()) {
            O0(new Function0<Unit>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$onRequestBodySensorsBackgroundPermissionResult$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    c cVar = null;
                    if (z11) {
                        PermissionBuilder permissionBuilder = this.f48653b;
                        if (permissionBuilder == null) {
                            Intrinsics.y("pb");
                            permissionBuilder = null;
                        }
                        permissionBuilder.f48675j.add("android.permission.BODY_SENSORS_BACKGROUND");
                        PermissionBuilder permissionBuilder2 = this.f48653b;
                        if (permissionBuilder2 == null) {
                            Intrinsics.y("pb");
                            permissionBuilder2 = null;
                        }
                        permissionBuilder2.f48676k.remove("android.permission.BODY_SENSORS_BACKGROUND");
                        PermissionBuilder permissionBuilder3 = this.f48653b;
                        if (permissionBuilder3 == null) {
                            Intrinsics.y("pb");
                            permissionBuilder3 = null;
                        }
                        permissionBuilder3.f48677l.remove("android.permission.BODY_SENSORS_BACKGROUND");
                        c cVar2 = this.f48654c;
                        if (cVar2 == null) {
                            Intrinsics.y("task");
                        } else {
                            cVar = cVar2;
                        }
                        cVar.finish();
                        return;
                    }
                    boolean zShouldShowRequestPermissionRationale = this.shouldShowRequestPermissionRationale("android.permission.BODY_SENSORS_BACKGROUND");
                    PermissionBuilder permissionBuilder4 = this.f48653b;
                    if (permissionBuilder4 == null) {
                        Intrinsics.y("pb");
                        permissionBuilder4 = null;
                    }
                    permissionBuilder4.getClass();
                    PermissionBuilder permissionBuilder5 = this.f48653b;
                    if (permissionBuilder5 == null) {
                        Intrinsics.y("pb");
                        permissionBuilder5 = null;
                    }
                    if (permissionBuilder5.f48682q == null || !zShouldShowRequestPermissionRationale) {
                        PermissionBuilder permissionBuilder6 = this.f48653b;
                        if (permissionBuilder6 == null) {
                            Intrinsics.y("pb");
                            permissionBuilder6 = null;
                        }
                        permissionBuilder6.getClass();
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add("android.permission.BODY_SENSORS_BACKGROUND");
                        PermissionBuilder permissionBuilder7 = this.f48653b;
                        if (permissionBuilder7 == null) {
                            Intrinsics.y("pb");
                            permissionBuilder7 = null;
                        }
                        if (permissionBuilder7.f48682q == null) {
                            PermissionBuilder permissionBuilder8 = this.f48653b;
                            if (permissionBuilder8 == null) {
                                Intrinsics.y("pb");
                                permissionBuilder8 = null;
                            }
                            permissionBuilder8.getClass();
                            Intrinsics.d(null);
                            c cVar3 = this.f48654c;
                            if (cVar3 == null) {
                                Intrinsics.y("task");
                                cVar3 = null;
                            }
                            cVar3.b();
                            throw null;
                        }
                        PermissionBuilder permissionBuilder9 = this.f48653b;
                        if (permissionBuilder9 == null) {
                            Intrinsics.y("pb");
                            permissionBuilder9 = null;
                        }
                        ao.b bVar = permissionBuilder9.f48682q;
                        Intrinsics.d(bVar);
                        c cVar4 = this.f48654c;
                        if (cVar4 == null) {
                            Intrinsics.y("task");
                            cVar4 = null;
                        }
                        bVar.a(cVar4.b(), arrayList, false, false);
                        PermissionBuilder permissionBuilder10 = this.f48653b;
                        if (permissionBuilder10 == null) {
                            Intrinsics.y("pb");
                            permissionBuilder10 = null;
                        }
                        if (permissionBuilder10.f48673h) {
                            return;
                        }
                    }
                    c cVar5 = this.f48654c;
                    if (cVar5 == null) {
                        Intrinsics.y("task");
                    } else {
                        cVar = cVar5;
                    }
                    cVar.finish();
                }
            });
        }
    }

    public final void H0() {
        if (C0()) {
            O0(new Function0<Unit>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$onRequestInstallPackagesPermissionResult$1
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
                    c cVar = null;
                    if (Build.VERSION.SDK_INT < 26) {
                        c cVar2 = this.this$0.f48654c;
                        if (cVar2 == null) {
                            Intrinsics.y("task");
                        } else {
                            cVar = cVar2;
                        }
                        cVar.finish();
                        return;
                    }
                    if (this.this$0.requireActivity().getPackageManager().canRequestPackageInstalls()) {
                        c cVar3 = this.this$0.f48654c;
                        if (cVar3 == null) {
                            Intrinsics.y("task");
                        } else {
                            cVar = cVar3;
                        }
                        cVar.finish();
                        return;
                    }
                    PermissionBuilder permissionBuilder = this.this$0.f48653b;
                    if (permissionBuilder == null) {
                        Intrinsics.y("pb");
                        permissionBuilder = null;
                    }
                    permissionBuilder.getClass();
                    PermissionBuilder permissionBuilder2 = this.this$0.f48653b;
                    if (permissionBuilder2 == null) {
                        Intrinsics.y("pb");
                        permissionBuilder2 = null;
                    }
                    if (permissionBuilder2.f48682q != null) {
                        PermissionBuilder permissionBuilder3 = this.this$0.f48653b;
                        if (permissionBuilder3 == null) {
                            Intrinsics.y("pb");
                            permissionBuilder3 = null;
                        }
                        if (permissionBuilder3.f48682q != null) {
                            PermissionBuilder permissionBuilder4 = this.this$0.f48653b;
                            if (permissionBuilder4 == null) {
                                Intrinsics.y("pb");
                                permissionBuilder4 = null;
                            }
                            ao.b bVar = permissionBuilder4.f48682q;
                            Intrinsics.d(bVar);
                            c cVar4 = this.this$0.f48654c;
                            if (cVar4 == null) {
                                Intrinsics.y("task");
                            } else {
                                cVar = cVar4;
                            }
                            bVar.a(cVar.b(), kotlin.collections.f.e("android.permission.REQUEST_INSTALL_PACKAGES"), false, false);
                            return;
                        }
                        PermissionBuilder permissionBuilder5 = this.this$0.f48653b;
                        if (permissionBuilder5 == null) {
                            Intrinsics.y("pb");
                            permissionBuilder5 = null;
                        }
                        permissionBuilder5.getClass();
                        Intrinsics.d(null);
                        c cVar5 = this.this$0.f48654c;
                        if (cVar5 == null) {
                            Intrinsics.y("task");
                            cVar5 = null;
                        }
                        cVar5.b();
                        kotlin.collections.f.e("android.permission.REQUEST_INSTALL_PACKAGES");
                        throw null;
                    }
                }
            });
        }
    }

    public final void I0() {
        if (C0()) {
            O0(new Function0<Unit>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$onRequestManageExternalStoragePermissionResult$1
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
                    c cVar = null;
                    if (Build.VERSION.SDK_INT < 30) {
                        c cVar2 = this.this$0.f48654c;
                        if (cVar2 == null) {
                            Intrinsics.y("task");
                        } else {
                            cVar = cVar2;
                        }
                        cVar.finish();
                        return;
                    }
                    if (Environment.isExternalStorageManager()) {
                        c cVar3 = this.this$0.f48654c;
                        if (cVar3 == null) {
                            Intrinsics.y("task");
                        } else {
                            cVar = cVar3;
                        }
                        cVar.finish();
                        return;
                    }
                    PermissionBuilder permissionBuilder = this.this$0.f48653b;
                    if (permissionBuilder == null) {
                        Intrinsics.y("pb");
                        permissionBuilder = null;
                    }
                    permissionBuilder.getClass();
                    PermissionBuilder permissionBuilder2 = this.this$0.f48653b;
                    if (permissionBuilder2 == null) {
                        Intrinsics.y("pb");
                        permissionBuilder2 = null;
                    }
                    if (permissionBuilder2.f48682q != null) {
                        PermissionBuilder permissionBuilder3 = this.this$0.f48653b;
                        if (permissionBuilder3 == null) {
                            Intrinsics.y("pb");
                            permissionBuilder3 = null;
                        }
                        if (permissionBuilder3.f48682q != null) {
                            PermissionBuilder permissionBuilder4 = this.this$0.f48653b;
                            if (permissionBuilder4 == null) {
                                Intrinsics.y("pb");
                                permissionBuilder4 = null;
                            }
                            ao.b bVar = permissionBuilder4.f48682q;
                            Intrinsics.d(bVar);
                            c cVar4 = this.this$0.f48654c;
                            if (cVar4 == null) {
                                Intrinsics.y("task");
                            } else {
                                cVar = cVar4;
                            }
                            bVar.a(cVar.b(), kotlin.collections.f.e("android.permission.MANAGE_EXTERNAL_STORAGE"), false, false);
                            return;
                        }
                        PermissionBuilder permissionBuilder5 = this.this$0.f48653b;
                        if (permissionBuilder5 == null) {
                            Intrinsics.y("pb");
                            permissionBuilder5 = null;
                        }
                        permissionBuilder5.getClass();
                        Intrinsics.d(null);
                        c cVar5 = this.this$0.f48654c;
                        if (cVar5 == null) {
                            Intrinsics.y("task");
                            cVar5 = null;
                        }
                        cVar5.b();
                        kotlin.collections.f.e("android.permission.MANAGE_EXTERNAL_STORAGE");
                        throw null;
                    }
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:195:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:196:0x02fe  */
    public final void J0(Map<String, Boolean> map) {
        PermissionBuilder permissionBuilder;
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed() || !C0()) {
            return;
        }
        PermissionBuilder permissionBuilder2 = this.f48653b;
        PermissionBuilder permissionBuilder3 = null;
        c cVar = null;
        if (permissionBuilder2 == null) {
            Intrinsics.y("pb");
            permissionBuilder2 = null;
        }
        permissionBuilder2.f48675j.clear();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
            String key = entry.getKey();
            if (entry.getValue().booleanValue()) {
                PermissionBuilder permissionBuilder4 = this.f48653b;
                if (permissionBuilder4 == null) {
                    Intrinsics.y("pb");
                    permissionBuilder4 = null;
                }
                permissionBuilder4.f48675j.add(key);
                PermissionBuilder permissionBuilder5 = this.f48653b;
                if (permissionBuilder5 == null) {
                    Intrinsics.y("pb");
                    permissionBuilder5 = null;
                }
                permissionBuilder5.f48676k.remove(key);
                PermissionBuilder permissionBuilder6 = this.f48653b;
                if (permissionBuilder6 == null) {
                    Intrinsics.y("pb");
                    permissionBuilder6 = null;
                }
                permissionBuilder6.f48677l.remove(key);
            } else if (shouldShowRequestPermissionRationale(key)) {
                arrayList.add(key);
                PermissionBuilder permissionBuilder7 = this.f48653b;
                if (permissionBuilder7 == null) {
                    Intrinsics.y("pb");
                    permissionBuilder7 = null;
                }
                permissionBuilder7.f48676k.add(key);
            } else {
                arrayList2.add(key);
                PermissionBuilder permissionBuilder8 = this.f48653b;
                if (permissionBuilder8 == null) {
                    Intrinsics.y("pb");
                    permissionBuilder8 = null;
                }
                permissionBuilder8.f48677l.add(key);
                PermissionBuilder permissionBuilder9 = this.f48653b;
                if (permissionBuilder9 == null) {
                    Intrinsics.y("pb");
                    permissionBuilder9 = null;
                }
                permissionBuilder9.f48676k.remove(key);
            }
        }
        if (Build.VERSION.SDK_INT >= 34) {
            PermissionBuilder permissionBuilder10 = this.f48653b;
            if (permissionBuilder10 == null) {
                Intrinsics.y("pb");
                permissionBuilder10 = null;
            }
            if (permissionBuilder10.f48675j.contains("android.permission.READ_MEDIA_VISUAL_USER_SELECTED")) {
                PermissionBuilder permissionBuilder11 = this.f48653b;
                if (permissionBuilder11 == null) {
                    Intrinsics.y("pb");
                    permissionBuilder11 = null;
                }
                if (permissionBuilder11.f48676k.contains("android.permission.READ_MEDIA_IMAGES")) {
                    PermissionBuilder permissionBuilder12 = this.f48653b;
                    if (permissionBuilder12 == null) {
                        Intrinsics.y("pb");
                        permissionBuilder12 = null;
                    }
                    permissionBuilder12.f48676k.remove("android.permission.READ_MEDIA_IMAGES");
                    arrayList.remove("android.permission.READ_MEDIA_IMAGES");
                    PermissionBuilder permissionBuilder13 = this.f48653b;
                    if (permissionBuilder13 == null) {
                        Intrinsics.y("pb");
                        permissionBuilder13 = null;
                    }
                    permissionBuilder13.f48679n.add("android.permission.READ_MEDIA_IMAGES");
                } else {
                    PermissionBuilder permissionBuilder14 = this.f48653b;
                    if (permissionBuilder14 == null) {
                        Intrinsics.y("pb");
                        permissionBuilder14 = null;
                    }
                    if (permissionBuilder14.f48677l.contains("android.permission.READ_MEDIA_IMAGES")) {
                        PermissionBuilder permissionBuilder15 = this.f48653b;
                        if (permissionBuilder15 == null) {
                            Intrinsics.y("pb");
                            permissionBuilder15 = null;
                        }
                        permissionBuilder15.f48677l.remove("android.permission.READ_MEDIA_IMAGES");
                        arrayList2.remove("android.permission.READ_MEDIA_IMAGES");
                        PermissionBuilder permissionBuilder16 = this.f48653b;
                        if (permissionBuilder16 == null) {
                            Intrinsics.y("pb");
                            permissionBuilder16 = null;
                        }
                        permissionBuilder16.f48679n.add("android.permission.READ_MEDIA_IMAGES");
                    }
                }
                PermissionBuilder permissionBuilder17 = this.f48653b;
                if (permissionBuilder17 == null) {
                    Intrinsics.y("pb");
                    permissionBuilder17 = null;
                }
                if (permissionBuilder17.f48676k.contains("android.permission.READ_MEDIA_VIDEO")) {
                    PermissionBuilder permissionBuilder18 = this.f48653b;
                    if (permissionBuilder18 == null) {
                        Intrinsics.y("pb");
                        permissionBuilder18 = null;
                    }
                    permissionBuilder18.f48676k.remove("android.permission.READ_MEDIA_VIDEO");
                    arrayList.remove("android.permission.READ_MEDIA_VIDEO");
                    PermissionBuilder permissionBuilder19 = this.f48653b;
                    if (permissionBuilder19 == null) {
                        Intrinsics.y("pb");
                        permissionBuilder19 = null;
                    }
                    permissionBuilder19.f48679n.add("android.permission.READ_MEDIA_VIDEO");
                } else {
                    PermissionBuilder permissionBuilder20 = this.f48653b;
                    if (permissionBuilder20 == null) {
                        Intrinsics.y("pb");
                        permissionBuilder20 = null;
                    }
                    if (permissionBuilder20.f48677l.contains("android.permission.READ_MEDIA_VIDEO")) {
                        PermissionBuilder permissionBuilder21 = this.f48653b;
                        if (permissionBuilder21 == null) {
                            Intrinsics.y("pb");
                            permissionBuilder21 = null;
                        }
                        permissionBuilder21.f48677l.remove("android.permission.READ_MEDIA_VIDEO");
                        arrayList2.remove("android.permission.READ_MEDIA_VIDEO");
                        PermissionBuilder permissionBuilder22 = this.f48653b;
                        if (permissionBuilder22 == null) {
                            Intrinsics.y("pb");
                            permissionBuilder22 = null;
                        }
                        permissionBuilder22.f48679n.add("android.permission.READ_MEDIA_VIDEO");
                    }
                }
            }
        }
        ArrayList<String> arrayList3 = new ArrayList();
        PermissionBuilder permissionBuilder23 = this.f48653b;
        if (permissionBuilder23 == null) {
            Intrinsics.y("pb");
            permissionBuilder23 = null;
        }
        arrayList3.addAll(permissionBuilder23.f48676k);
        PermissionBuilder permissionBuilder24 = this.f48653b;
        if (permissionBuilder24 == null) {
            Intrinsics.y("pb");
            permissionBuilder24 = null;
        }
        arrayList3.addAll(permissionBuilder24.f48677l);
        for (String str : arrayList3) {
            if (PermissionX.f48641a.e(activity, str)) {
                PermissionBuilder permissionBuilder25 = this.f48653b;
                if (permissionBuilder25 == null) {
                    Intrinsics.y("pb");
                    permissionBuilder25 = null;
                }
                permissionBuilder25.f48676k.remove(str);
                PermissionBuilder permissionBuilder26 = this.f48653b;
                if (permissionBuilder26 == null) {
                    Intrinsics.y("pb");
                    permissionBuilder26 = null;
                }
                permissionBuilder26.f48675j.add(str);
            }
        }
        PermissionBuilder permissionBuilder27 = this.f48653b;
        if (permissionBuilder27 == null) {
            Intrinsics.y("pb");
            permissionBuilder27 = null;
        }
        int size = permissionBuilder27.f48675j.size();
        PermissionBuilder permissionBuilder28 = this.f48653b;
        if (permissionBuilder28 == null) {
            Intrinsics.y("pb");
            permissionBuilder28 = null;
        }
        if (size == permissionBuilder28.f48670e.size()) {
            c cVar2 = this.f48654c;
            if (cVar2 == null) {
                Intrinsics.y("task");
            } else {
                cVar = cVar2;
            }
            cVar.finish();
            return;
        }
        PermissionBuilder permissionBuilder29 = this.f48653b;
        if (permissionBuilder29 == null) {
            Intrinsics.y("pb");
            permissionBuilder29 = null;
        }
        permissionBuilder29.getClass();
        PermissionBuilder permissionBuilder30 = this.f48653b;
        if (permissionBuilder30 == null) {
            Intrinsics.y("pb");
            permissionBuilder30 = null;
        }
        if (permissionBuilder30.f48682q != null && (!arrayList.isEmpty())) {
            PermissionBuilder permissionBuilder31 = this.f48653b;
            if (permissionBuilder31 == null) {
                Intrinsics.y("pb");
                permissionBuilder31 = null;
            }
            if (permissionBuilder31.f48682q == null) {
                PermissionBuilder permissionBuilder32 = this.f48653b;
                if (permissionBuilder32 == null) {
                    Intrinsics.y("pb");
                    permissionBuilder32 = null;
                }
                permissionBuilder32.getClass();
                Intrinsics.d(null);
                c cVar3 = this.f48654c;
                if (cVar3 == null) {
                    Intrinsics.y("task");
                    cVar3 = null;
                }
                cVar3.b();
                PermissionBuilder permissionBuilder33 = this.f48653b;
                if (permissionBuilder33 == null) {
                    Intrinsics.y("pb");
                    permissionBuilder33 = null;
                }
                new ArrayList(permissionBuilder33.f48676k);
                throw null;
            }
            PermissionBuilder permissionBuilder34 = this.f48653b;
            if (permissionBuilder34 == null) {
                Intrinsics.y("pb");
                permissionBuilder34 = null;
            }
            ao.b bVar = permissionBuilder34.f48682q;
            Intrinsics.d(bVar);
            c cVar4 = this.f48654c;
            if (cVar4 == null) {
                Intrinsics.y("task");
                cVar4 = null;
            }
            d dVarB = cVar4.b();
            PermissionBuilder permissionBuilder35 = this.f48653b;
            if (permissionBuilder35 == null) {
                Intrinsics.y("pb");
                permissionBuilder35 = null;
            }
            bVar.a(dVarB, new ArrayList(permissionBuilder35.f48676k), false, false);
            PermissionBuilder permissionBuilder36 = this.f48653b;
            if (permissionBuilder36 == null) {
                Intrinsics.y("pb");
                permissionBuilder36 = null;
            }
            permissionBuilder36.f48678m.addAll(arrayList2);
            PermissionBuilder permissionBuilder37 = this.f48653b;
            if (permissionBuilder37 == null) {
                Intrinsics.y("pb");
                permissionBuilder37 = null;
            }
            if (!permissionBuilder37.f48673h) {
            }
            permissionBuilder = this.f48653b;
            if (permissionBuilder == null) {
                Intrinsics.y("pb");
            } else {
                permissionBuilder3 = permissionBuilder;
            }
            permissionBuilder3.f48673h = false;
        }
        PermissionBuilder permissionBuilder38 = this.f48653b;
        if (permissionBuilder38 == null) {
            Intrinsics.y("pb");
            permissionBuilder38 = null;
        }
        permissionBuilder38.getClass();
        PermissionBuilder permissionBuilder39 = this.f48653b;
        if (permissionBuilder39 == null) {
            Intrinsics.y("pb");
            permissionBuilder39 = null;
        }
        for (String str2 : permissionBuilder39.f48679n) {
            PermissionBuilder permissionBuilder40 = this.f48653b;
            if (permissionBuilder40 == null) {
                Intrinsics.y("pb");
                permissionBuilder40 = null;
            }
            permissionBuilder40.f48676k.add(str2);
        }
        PermissionBuilder permissionBuilder41 = this.f48653b;
        if (permissionBuilder41 == null) {
            Intrinsics.y("pb");
            permissionBuilder41 = null;
        }
        permissionBuilder41.f48679n.clear();
        c cVar5 = this.f48654c;
        if (cVar5 == null) {
            Intrinsics.y("task");
            cVar5 = null;
        }
        cVar5.finish();
        permissionBuilder = this.f48653b;
        if (permissionBuilder == null) {
            Intrinsics.y("pb");
        } else {
            permissionBuilder3 = permissionBuilder;
        }
        permissionBuilder3.f48673h = false;
    }

    public final void K0() {
        final FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed() || !C0()) {
            return;
        }
        O0(new Function0<Unit>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$onRequestNotificationPermissionResult$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                c cVar = null;
                if (Build.VERSION.SDK_INT < 26) {
                    c cVar2 = this.f48654c;
                    if (cVar2 == null) {
                        Intrinsics.y("task");
                    } else {
                        cVar = cVar2;
                    }
                    cVar.finish();
                    return;
                }
                if (PermissionX.f48641a.a(activity)) {
                    c cVar3 = this.f48654c;
                    if (cVar3 == null) {
                        Intrinsics.y("task");
                    } else {
                        cVar = cVar3;
                    }
                    cVar.finish();
                    return;
                }
                PermissionBuilder permissionBuilder = this.f48653b;
                if (permissionBuilder == null) {
                    Intrinsics.y("pb");
                    permissionBuilder = null;
                }
                permissionBuilder.getClass();
                PermissionBuilder permissionBuilder2 = this.f48653b;
                if (permissionBuilder2 == null) {
                    Intrinsics.y("pb");
                    permissionBuilder2 = null;
                }
                if (permissionBuilder2.f48682q != null) {
                    PermissionBuilder permissionBuilder3 = this.f48653b;
                    if (permissionBuilder3 == null) {
                        Intrinsics.y("pb");
                        permissionBuilder3 = null;
                    }
                    if (permissionBuilder3.f48682q != null) {
                        PermissionBuilder permissionBuilder4 = this.f48653b;
                        if (permissionBuilder4 == null) {
                            Intrinsics.y("pb");
                            permissionBuilder4 = null;
                        }
                        ao.b bVar = permissionBuilder4.f48682q;
                        Intrinsics.d(bVar);
                        c cVar4 = this.f48654c;
                        if (cVar4 == null) {
                            Intrinsics.y("task");
                        } else {
                            cVar = cVar4;
                        }
                        bVar.a(cVar.b(), kotlin.collections.f.e("android.permission.POST_NOTIFICATIONS"), false, false);
                        return;
                    }
                    PermissionBuilder permissionBuilder5 = this.f48653b;
                    if (permissionBuilder5 == null) {
                        Intrinsics.y("pb");
                        permissionBuilder5 = null;
                    }
                    permissionBuilder5.getClass();
                    Intrinsics.d(null);
                    c cVar5 = this.f48654c;
                    if (cVar5 == null) {
                        Intrinsics.y("task");
                        cVar5 = null;
                    }
                    cVar5.b();
                    kotlin.collections.f.e("android.permission.POST_NOTIFICATIONS");
                    throw null;
                }
            }
        });
    }

    public final void L0() {
        final FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed() || !C0()) {
            return;
        }
        O0(new Function0<Unit>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$onRequestPipPermissionResult$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                c cVar = null;
                if (Build.VERSION.SDK_INT < 26) {
                    c cVar2 = this.f48654c;
                    if (cVar2 == null) {
                        Intrinsics.y("task");
                    } else {
                        cVar = cVar2;
                    }
                    cVar.finish();
                    return;
                }
                if (PermissionX.f48641a.b(activity)) {
                    c cVar3 = this.f48654c;
                    if (cVar3 == null) {
                        Intrinsics.y("task");
                    } else {
                        cVar = cVar3;
                    }
                    cVar.finish();
                    return;
                }
                PermissionBuilder permissionBuilder = this.f48653b;
                if (permissionBuilder == null) {
                    Intrinsics.y("pb");
                    permissionBuilder = null;
                }
                permissionBuilder.getClass();
                PermissionBuilder permissionBuilder2 = this.f48653b;
                if (permissionBuilder2 == null) {
                    Intrinsics.y("pb");
                    permissionBuilder2 = null;
                }
                if (permissionBuilder2.f48682q != null) {
                    PermissionBuilder permissionBuilder3 = this.f48653b;
                    if (permissionBuilder3 == null) {
                        Intrinsics.y("pb");
                        permissionBuilder3 = null;
                    }
                    if (permissionBuilder3.f48682q != null) {
                        PermissionBuilder permissionBuilder4 = this.f48653b;
                        if (permissionBuilder4 == null) {
                            Intrinsics.y("pb");
                            permissionBuilder4 = null;
                        }
                        ao.b bVar = permissionBuilder4.f48682q;
                        Intrinsics.d(bVar);
                        c cVar4 = this.f48654c;
                        if (cVar4 == null) {
                            Intrinsics.y("task");
                        } else {
                            cVar = cVar4;
                        }
                        bVar.a(cVar.b(), kotlin.collections.f.e("android.permission.PICTURE_IN_PICTURE"), false, true);
                        return;
                    }
                    PermissionBuilder permissionBuilder5 = this.f48653b;
                    if (permissionBuilder5 == null) {
                        Intrinsics.y("pb");
                        permissionBuilder5 = null;
                    }
                    permissionBuilder5.getClass();
                    Intrinsics.d(null);
                    c cVar5 = this.f48654c;
                    if (cVar5 == null) {
                        Intrinsics.y("task");
                        cVar5 = null;
                    }
                    cVar5.b();
                    kotlin.collections.f.e("android.permission.PICTURE_IN_PICTURE");
                    throw null;
                }
            }
        });
    }

    public final void M0() {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed() || !C0()) {
            return;
        }
        c cVar = null;
        if (Build.VERSION.SDK_INT < 23) {
            c cVar2 = this.f48654c;
            if (cVar2 == null) {
                Intrinsics.y("task");
            } else {
                cVar = cVar2;
            }
            cVar.finish();
            return;
        }
        if (Settings.canDrawOverlays(activity)) {
            c cVar3 = this.f48654c;
            if (cVar3 == null) {
                Intrinsics.y("task");
            } else {
                cVar = cVar3;
            }
            cVar.finish();
            return;
        }
        PermissionBuilder permissionBuilder = this.f48653b;
        if (permissionBuilder == null) {
            Intrinsics.y("pb");
            permissionBuilder = null;
        }
        permissionBuilder.getClass();
        PermissionBuilder permissionBuilder2 = this.f48653b;
        if (permissionBuilder2 == null) {
            Intrinsics.y("pb");
            permissionBuilder2 = null;
        }
        if (permissionBuilder2.f48682q != null) {
            PermissionBuilder permissionBuilder3 = this.f48653b;
            if (permissionBuilder3 == null) {
                Intrinsics.y("pb");
                permissionBuilder3 = null;
            }
            if (permissionBuilder3.f48682q != null) {
                PermissionBuilder permissionBuilder4 = this.f48653b;
                if (permissionBuilder4 == null) {
                    Intrinsics.y("pb");
                    permissionBuilder4 = null;
                }
                ao.b bVar = permissionBuilder4.f48682q;
                Intrinsics.d(bVar);
                c cVar4 = this.f48654c;
                if (cVar4 == null) {
                    Intrinsics.y("task");
                } else {
                    cVar = cVar4;
                }
                bVar.a(cVar.b(), kotlin.collections.f.e("android.permission.SYSTEM_ALERT_WINDOW"), false, false);
                return;
            }
            PermissionBuilder permissionBuilder5 = this.f48653b;
            if (permissionBuilder5 == null) {
                Intrinsics.y("pb");
                permissionBuilder5 = null;
            }
            permissionBuilder5.getClass();
            Intrinsics.d(null);
            c cVar5 = this.f48654c;
            if (cVar5 == null) {
                Intrinsics.y("task");
                cVar5 = null;
            }
            cVar5.b();
            kotlin.collections.f.e("android.permission.SYSTEM_ALERT_WINDOW");
            throw null;
        }
    }

    public final void N0() {
        final FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed() || !C0()) {
            return;
        }
        O0(new Function0<Unit>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$onRequestWriteSettingsPermissionResult$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                c cVar = null;
                if (Build.VERSION.SDK_INT < 23) {
                    c cVar2 = this.f48654c;
                    if (cVar2 == null) {
                        Intrinsics.y("task");
                    } else {
                        cVar = cVar2;
                    }
                    cVar.finish();
                    return;
                }
                if (Settings.System.canWrite(activity)) {
                    c cVar3 = this.f48654c;
                    if (cVar3 == null) {
                        Intrinsics.y("task");
                    } else {
                        cVar = cVar3;
                    }
                    cVar.finish();
                    return;
                }
                PermissionBuilder permissionBuilder = this.f48653b;
                if (permissionBuilder == null) {
                    Intrinsics.y("pb");
                    permissionBuilder = null;
                }
                permissionBuilder.getClass();
                PermissionBuilder permissionBuilder2 = this.f48653b;
                if (permissionBuilder2 == null) {
                    Intrinsics.y("pb");
                    permissionBuilder2 = null;
                }
                if (permissionBuilder2.f48682q != null) {
                    PermissionBuilder permissionBuilder3 = this.f48653b;
                    if (permissionBuilder3 == null) {
                        Intrinsics.y("pb");
                        permissionBuilder3 = null;
                    }
                    if (permissionBuilder3.f48682q != null) {
                        PermissionBuilder permissionBuilder4 = this.f48653b;
                        if (permissionBuilder4 == null) {
                            Intrinsics.y("pb");
                            permissionBuilder4 = null;
                        }
                        ao.b bVar = permissionBuilder4.f48682q;
                        Intrinsics.d(bVar);
                        c cVar4 = this.f48654c;
                        if (cVar4 == null) {
                            Intrinsics.y("task");
                        } else {
                            cVar = cVar4;
                        }
                        bVar.a(cVar.b(), kotlin.collections.f.e("android.permission.WRITE_SETTINGS"), false, false);
                        return;
                    }
                    PermissionBuilder permissionBuilder5 = this.f48653b;
                    if (permissionBuilder5 == null) {
                        Intrinsics.y("pb");
                        permissionBuilder5 = null;
                    }
                    permissionBuilder5.getClass();
                    Intrinsics.d(null);
                    c cVar5 = this.f48654c;
                    if (cVar5 == null) {
                        Intrinsics.y("task");
                        cVar5 = null;
                    }
                    cVar5.b();
                    kotlin.collections.f.e("android.permission.WRITE_SETTINGS");
                    throw null;
                }
            }
        });
    }

    public final void O0(final Function0<Unit> function0) {
        this.f48652a.post(new Runnable() { // from class: com.permissionx.guolindev.request.h
            @Override // java.lang.Runnable
            public final void run() {
                InvisibleFragment.P0(function0);
            }
        });
    }

    public final void Q0(PermissionBuilder permissionBuilder, c chainTask) {
        Intrinsics.g(permissionBuilder, "permissionBuilder");
        Intrinsics.g(chainTask, "chainTask");
        this.f48653b = permissionBuilder;
        this.f48654c = chainTask;
        this.f48656f.a("android.permission.ACCESS_BACKGROUND_LOCATION");
    }

    public final void T0(PermissionBuilder permissionBuilder, c chainTask) {
        Intrinsics.g(permissionBuilder, "permissionBuilder");
        Intrinsics.g(chainTask, "chainTask");
        this.f48653b = permissionBuilder;
        this.f48654c = chainTask;
        this.f48663m.a("android.permission.BODY_SENSORS_BACKGROUND");
    }

    public final void V0(PermissionBuilder permissionBuilder, c chainTask) {
        Intrinsics.g(permissionBuilder, "permissionBuilder");
        Intrinsics.g(chainTask, "chainTask");
        this.f48653b = permissionBuilder;
        this.f48654c = chainTask;
        if (Build.VERSION.SDK_INT < 26) {
            H0();
            return;
        }
        try {
            Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
            intent.setData(Uri.parse("package:" + requireActivity().getPackageName()));
            this.f48658h.a(intent);
        } catch (Throwable unused) {
            H0();
        }
    }

    @SuppressLint({"QueryPermissionsNeeded"})
    public final void X0(PermissionBuilder permissionBuilder, c chainTask) {
        Intrinsics.g(permissionBuilder, "permissionBuilder");
        Intrinsics.g(chainTask, "chainTask");
        this.f48653b = permissionBuilder;
        this.f48654c = chainTask;
        if (Build.VERSION.SDK_INT < 30 || Environment.isExternalStorageManager()) {
            I0();
            return;
        }
        try {
            Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
            intent.setData(Uri.parse("package:" + requireActivity().getPackageName()));
            if (intent.resolveActivity(requireActivity().getPackageManager()) == null) {
                intent = new Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION");
            }
            this.f48659i.a(intent);
        } catch (Throwable unused) {
            I0();
        }
    }

    public final void a1(PermissionBuilder permissionBuilder, c chainTask) {
        Intrinsics.g(permissionBuilder, "permissionBuilder");
        Intrinsics.g(chainTask, "chainTask");
        this.f48653b = permissionBuilder;
        this.f48654c = chainTask;
        if (Build.VERSION.SDK_INT < 26) {
            H0();
            return;
        }
        try {
            Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", requireActivity().getPackageName());
            this.f48661k.a(intent);
        } catch (Throwable unused) {
            H0();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void b1(PermissionBuilder permissionBuilder, Set<String> permissions, c chainTask) {
        Intrinsics.g(permissionBuilder, "permissionBuilder");
        Intrinsics.g(permissions, "permissions");
        Intrinsics.g(chainTask, "chainTask");
        this.f48653b = permissionBuilder;
        this.f48654c = chainTask;
        this.f48655d.a(permissions.toArray(new String[0]));
    }

    public final void d1(PermissionBuilder permissionBuilder, c chainTask) {
        Intrinsics.g(permissionBuilder, "permissionBuilder");
        Intrinsics.g(chainTask, "chainTask");
        this.f48653b = permissionBuilder;
        this.f48654c = chainTask;
        if (Build.VERSION.SDK_INT < 26) {
            L0();
            return;
        }
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            Context context = getContext();
            intent.setData(Uri.fromParts("package", context != null ? context.getPackageName() : null, null));
            this.f48662l.a(intent);
        } catch (Throwable unused) {
            L0();
        }
    }

    public final void f1(PermissionBuilder permissionBuilder, c chainTask) {
        Intrinsics.g(permissionBuilder, "permissionBuilder");
        Intrinsics.g(chainTask, "chainTask");
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        this.f48653b = permissionBuilder;
        this.f48654c = chainTask;
        if (Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(activity)) {
            M0();
            return;
        }
        try {
            Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            intent.setData(Uri.parse("package:" + requireActivity().getPackageName()));
            this.f48657g.a(intent);
        } catch (Throwable unused) {
            M0();
        }
    }

    public final void h1(PermissionBuilder permissionBuilder, c chainTask) {
        Intrinsics.g(permissionBuilder, "permissionBuilder");
        Intrinsics.g(chainTask, "chainTask");
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        this.f48653b = permissionBuilder;
        this.f48654c = chainTask;
        if (Build.VERSION.SDK_INT < 23 || Settings.System.canWrite(activity)) {
            N0();
            return;
        }
        try {
            Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
            intent.setData(Uri.parse("package:" + requireActivity().getPackageName()));
            this.f48658h.a(intent);
        } catch (Throwable unused) {
            N0();
        }
    }

    public final void i1(PermissionBuilder permissionBuilder, c chainTask) {
        Intrinsics.g(permissionBuilder, "permissionBuilder");
        Intrinsics.g(chainTask, "chainTask");
        this.f48653b = permissionBuilder;
        this.f48654c = chainTask;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (C0()) {
            try {
                Result.Companion companion = Result.Companion;
                PermissionBuilder permissionBuilder = this.f48653b;
                Unit unit = null;
                if (permissionBuilder == null) {
                    Intrinsics.y("pb");
                    permissionBuilder = null;
                }
                RationaleDialog rationaleDialog = permissionBuilder.f48669d;
                if (rationaleDialog != null) {
                    rationaleDialog.dismissAllowingStateLoss();
                    unit = Unit.f68710a;
                }
                Result.m163constructorimpl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th2));
            }
        }
    }
}
