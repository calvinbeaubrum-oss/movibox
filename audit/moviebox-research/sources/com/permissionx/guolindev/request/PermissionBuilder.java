package com.permissionx.guolindev.request;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Build;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.permissionx.guolindev.dialog.DefaultRationaleDialog;
import com.permissionx.guolindev.dialog.RationaleDialog;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
@Metadata
public final class PermissionBuilder implements f {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final a f48665s = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FragmentActivity f48666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Fragment f48667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f48668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    public RationaleDialog f48669d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @JvmField
    public Set<String> f48670e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @JvmField
    public Set<String> f48671f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @JvmField
    public boolean f48672g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @JvmField
    public boolean f48673h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @JvmField
    public Set<String> f48674i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @JvmField
    public Set<String> f48675j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @JvmField
    public Set<String> f48676k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @JvmField
    public Set<String> f48677l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @JvmField
    public Set<String> f48678m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @JvmField
    public Set<String> f48679n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @JvmField
    public Set<String> f48680o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @JvmField
    public ao.c f48681p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @JvmField
    public ao.b f48682q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @JvmField
    public ao.a f48683r;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PermissionBuilder(FragmentActivity fragmentActivity, Fragment fragment, Set<String> normalPermissions, Set<String> specialPermissions) {
        Intrinsics.g(normalPermissions, "normalPermissions");
        Intrinsics.g(specialPermissions, "specialPermissions");
        this.f48668c = -1;
        this.f48674i = new LinkedHashSet();
        this.f48675j = new LinkedHashSet();
        this.f48676k = new LinkedHashSet();
        this.f48677l = new LinkedHashSet();
        this.f48678m = new LinkedHashSet();
        this.f48679n = new LinkedHashSet();
        this.f48680o = new LinkedHashSet();
        if (fragmentActivity != null) {
            z(fragmentActivity);
        }
        if (fragmentActivity == null && fragment != null) {
            FragmentActivity fragmentActivityRequireActivity = fragment.requireActivity();
            Intrinsics.f(fragmentActivityRequireActivity, "fragment.requireActivity()");
            z(fragmentActivityRequireActivity);
        }
        this.f48667b = fragment;
        this.f48670e = normalPermissions;
        this.f48671f = specialPermissions;
    }

    public static final void L(PermissionBuilder this$0, DialogInterface dialogInterface) {
        Intrinsics.g(this$0, "this$0");
        co.c.f15010a.c(this$0.i());
        this$0.f48669d = null;
    }

    public final void A(c chainTask) {
        Intrinsics.g(chainTask, "chainTask");
        k().i1(this, chainTask);
    }

    public final boolean B() {
        return this.f48671f.contains("android.permission.ACCESS_BACKGROUND_LOCATION");
    }

    public final boolean C() {
        return this.f48671f.contains("android.permission.BODY_SENSORS_BACKGROUND");
    }

    public final boolean D() {
        return this.f48671f.contains("android.permission.REQUEST_INSTALL_PACKAGES");
    }

    public final boolean E() {
        return this.f48671f.contains("android.permission.MANAGE_EXTERNAL_STORAGE");
    }

    public final boolean F() {
        return this.f48671f.contains("android.permission.POST_NOTIFICATIONS");
    }

    public final boolean G() {
        return this.f48671f.contains("android.permission.PICTURE_IN_PICTURE");
    }

    public final boolean H() {
        return this.f48671f.contains("android.permission.SYSTEM_ALERT_WINDOW");
    }

    public final boolean I() {
        return this.f48671f.contains("android.permission.WRITE_SETTINGS");
    }

    public final void J(c chainTask, boolean z11, RationaleDialog dialog) {
        Intrinsics.g(chainTask, "chainTask");
        Intrinsics.g(dialog, "dialog");
        this.f48673h = true;
        List<String> listM0 = dialog.m0();
        if (listM0.isEmpty()) {
            chainTask.finish();
            return;
        }
        this.f48669d = dialog;
        dialog.o0(new PermissionBuilder$showHandlePermissionDialog$1(this, dialog, z11, chainTask, listM0));
        dialog.n0(new PermissionBuilder$showHandlePermissionDialog$2(this, dialog, z11, chainTask));
        dialog.i0(new DialogInterface.OnDismissListener() { // from class: com.permissionx.guolindev.request.r
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                PermissionBuilder.L(this.f48699a, dialogInterface);
            }
        });
        if (co.c.f15010a.b(dialog, "permission_rationale_dialog")) {
            dialog.j0(i(), "permission_rationale_dialog");
        }
    }

    public final void K(c chainTask, boolean z11, List<String> permissions, co.a dialogInfo) {
        Intrinsics.g(chainTask, "chainTask");
        Intrinsics.g(permissions, "permissions");
        Intrinsics.g(dialogInfo, "dialogInfo");
        DefaultRationaleDialog defaultRationaleDialog = new DefaultRationaleDialog();
        defaultRationaleDialog.q0(permissions, dialogInfo);
        J(chainTask, z11, defaultRationaleDialog);
    }

    public final void M() {
        m();
        w wVar = new w();
        if (B()) {
            wVar.a(new u(this));
        } else if (F()) {
            wVar.a(new a0(this));
        } else if (G()) {
            wVar.a(new b0(this));
        } else if (H()) {
            wVar.a(new c0(this));
        } else if (I()) {
            wVar.a(new d0(this));
        } else if (D()) {
            wVar.a(new x(this));
        } else if (E()) {
            wVar.a(new y(this));
        } else if (C()) {
            wVar.a(new v(this));
        } else {
            wVar.a(new z(this));
        }
        wVar.b();
    }

    @Override // com.permissionx.guolindev.request.f
    public void b(ao.c cVar) {
        this.f48681p = cVar;
        M();
    }

    @Override // com.permissionx.guolindev.request.f
    public f d(ao.a aVar) {
        this.f48683r = aVar;
        return this;
    }

    public final void f() {
        o();
        y();
    }

    @Override // com.permissionx.guolindev.request.f
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public PermissionBuilder a() {
        this.f48672g = true;
        return this;
    }

    public final void h(List<String> permissions) {
        Intrinsics.g(permissions, "permissions");
        this.f48680o.clear();
        this.f48680o.addAll(permissions);
        k().D0();
    }

    public final FragmentActivity i() {
        FragmentActivity fragmentActivity = this.f48666a;
        if (fragmentActivity != null) {
            return fragmentActivity;
        }
        Intrinsics.y("activity");
        return null;
    }

    public final FragmentManager j() {
        Fragment fragment = this.f48667b;
        FragmentManager childFragmentManager = fragment != null ? fragment.getChildFragmentManager() : null;
        if (childFragmentManager != null) {
            return childFragmentManager;
        }
        FragmentManager supportFragmentManager = i().getSupportFragmentManager();
        Intrinsics.f(supportFragmentManager, "activity.supportFragmentManager");
        return supportFragmentManager;
    }

    public final InvisibleFragment k() {
        Fragment fragmentFindFragmentByTag = j().findFragmentByTag("InvisibleFragment");
        if (fragmentFindFragmentByTag != null) {
            return (InvisibleFragment) fragmentFindFragmentByTag;
        }
        InvisibleFragment invisibleFragment = new InvisibleFragment();
        j().beginTransaction().add(invisibleFragment, "InvisibleFragment").commitNowAllowingStateLoss();
        return invisibleFragment;
    }

    public final int l() {
        return i().getApplicationInfo().targetSdkVersion;
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public final void m() {
        if (Build.VERSION.SDK_INT != 26) {
            this.f48668c = i().getRequestedOrientation();
            int i11 = i().getResources().getConfiguration().orientation;
            if (i11 == 1) {
                i().setRequestedOrientation(7);
            } else {
                if (i11 != 2) {
                    return;
                }
                i().setRequestedOrientation(6);
            }
        }
    }

    @Override // com.permissionx.guolindev.request.f
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public PermissionBuilder c(ao.b bVar) {
        this.f48682q = bVar;
        return this;
    }

    public final void o() {
        Fragment fragmentFindFragmentByTag = j().findFragmentByTag("InvisibleFragment");
        if (fragmentFindFragmentByTag != null) {
            j().beginTransaction().remove(fragmentFindFragmentByTag).commitNowAllowingStateLoss();
        }
    }

    public void p(c chainTask) {
        Intrinsics.g(chainTask, "chainTask");
        k().Q0(this, chainTask);
    }

    public void q(c chainTask) {
        Intrinsics.g(chainTask, "chainTask");
        k().T0(this, chainTask);
    }

    public void r(c chainTask) {
        Intrinsics.g(chainTask, "chainTask");
        k().V0(this, chainTask);
    }

    public void s(c chainTask) {
        Intrinsics.g(chainTask, "chainTask");
        k().X0(this, chainTask);
    }

    public void t(c chainTask) {
        Intrinsics.g(chainTask, "chainTask");
        k().a1(this, chainTask);
    }

    public final void u(Set<String> permissions, c chainTask) {
        Intrinsics.g(permissions, "permissions");
        Intrinsics.g(chainTask, "chainTask");
        k().b1(this, permissions, chainTask);
    }

    public void v(c chainTask) {
        Intrinsics.g(chainTask, "chainTask");
        k().d1(this, chainTask);
    }

    public void w(c chainTask) {
        Intrinsics.g(chainTask, "chainTask");
        k().f1(this, chainTask);
    }

    public void x(c chainTask) {
        Intrinsics.g(chainTask, "chainTask");
        k().h1(this, chainTask);
    }

    public final void y() {
        if (Build.VERSION.SDK_INT != 26) {
            i().setRequestedOrientation(this.f48668c);
        }
    }

    public final void z(FragmentActivity fragmentActivity) {
        Intrinsics.g(fragmentActivity, "<set-?>");
        this.f48666a = fragmentActivity;
    }
}
