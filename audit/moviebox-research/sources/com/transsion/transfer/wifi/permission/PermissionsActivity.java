package com.transsion.transfer.wifi.permission;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import androidx.activity.p;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.baselib.utils.o;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.transfer.R$string;
import com.transsion.transfer.wifi.bean.PermissionState;
import com.transsion.transfer.wifi.permission.PermissionsActivity;
import com.transsion.transfer.wifi.util.WifiUtils;
import com.transsion.transfer.wifi.util.g;
import f9.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import sy.c;
import sy.e;

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
public final class PermissionsActivity extends BaseNewActivity<ky.a> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public c f59188j;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<PermissionsBean> f59187i = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f59189k = "";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends RecyclerView.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f59190a;

        public a(RecyclerView recyclerView) {
            this.f59190a = recyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.x state) {
            RecyclerView.Adapter adapter;
            Intrinsics.g(outRect, "outRect");
            Intrinsics.g(view, "view");
            Intrinsics.g(parent, "parent");
            Intrinsics.g(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            if (parent.getAdapter() != null) {
                RecyclerView recyclerView = this.f59190a;
                if (childAdapterPosition == 0 || ((adapter = recyclerView.getAdapter()) != null && adapter.getItemCount() == childAdapterPosition + 1)) {
                    outRect.top = f0.a(16.0f);
                } else {
                    outRect.top = f0.a(8.0f);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends p {
        public b() {
            super(true);
        }

        @Override // androidx.activity.p
        public void handleOnBackPressed() {
            if (e.f76637a.g(PermissionsActivity.this.f59187i)) {
                PermissionsActivity.this.setResult(-1);
            } else {
                PermissionsActivity.this.setResult(0);
            }
            PermissionsActivity.this.finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s0() {
        RecyclerView recyclerView = ((ky.a) getMViewBinding()).f69650c;
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(this));
        recyclerView.addItemDecoration(new a(recyclerView));
        c cVar = new c();
        cVar.B0(new d() { // from class: sy.a
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                PermissionsActivity.t0(this.f76636a, baseQuickAdapter, view, i11);
            }
        });
        this.f59188j = cVar;
        ((ky.a) getMViewBinding()).f69650c.setAdapter(this.f59188j);
    }

    public static final void t0(PermissionsActivity this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "<anonymous parameter 1>");
        Object item = adapter.getItem(i11);
        if (item instanceof PermissionsBean) {
            this$0.u0((PermissionsBean) item);
        }
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public String U() {
        return "";
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void X() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void Y() {
        TitleLayout titleLayout = ((ky.a) getMViewBinding()).f69651d;
        String string = getResources().getString(R$string.transfer_wifi_preparations);
        Intrinsics.f(string, "resources.getString(R.st…ansfer_wifi_preparations)");
        titleLayout.setTitleText(string);
        s0();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void Z() {
        getOnBackPressedDispatcher().i(this, new b());
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean a0() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void c0() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isStatusDark() {
        return !o.f51321a.a();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        py.c cVar = py.c.f74067a;
        Intent intent = getIntent();
        cVar.m(intent != null ? intent.getAction() : null);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i11, String[] permissions, int[] grantResults) {
        Intrinsics.g(permissions, "permissions");
        Intrinsics.g(grantResults, "grantResults");
        super.onRequestPermissionsResult(i11, permissions, grantResults);
        if (i11 == 101) {
            if ((!(grantResults.length == 0)) && grantResults[0] == 0) {
                if (e.f76637a.g(this.f59187i)) {
                    r0();
                } else {
                    setResult(0);
                }
            }
        }
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseMusicFloatActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        v0();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public ky.a getViewBinding() {
        ky.a aVarC = ky.a.c(getLayoutInflater());
        Intrinsics.f(aVarC, "inflate(layoutInflater)");
        return aVarC;
    }

    public final void r0() {
        setResult(-1);
        finish();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void retryLoadData() {
    }

    public final void u0(PermissionsBean permissionsBean) {
        PermissionState state = permissionsBean.getState();
        PermissionState permissionState = PermissionState.PERMISSION_REQUEST;
        if (state == permissionState || permissionsBean.getState() == PermissionState.PERMISSION_GRANTED) {
            return;
        }
        py.c cVar = py.c.f74067a;
        Intent intent = getIntent();
        cVar.l(intent != null ? intent.getAction() : null, permissionsBean.getPermission(), permissionState);
        this.f59189k = permissionsBean.getPermission();
        if (!TextUtils.equals("mb.permission.WIFI", permissionsBean.getPermission()) && ActivityCompat.j(this, permissionsBean.getPermission())) {
            g.h(g.f59252a, getClassTag() + " --> itemClick() --> 如果是不再询问，那就直接跳转到设置页面", false, 2, null);
            e.f76637a.h(this);
            return;
        }
        String permission = permissionsBean.getPermission();
        if (Intrinsics.b(permission, "mb.permission.WIFI")) {
            WifiUtils.f59242a.u(this);
            return;
        }
        if (Intrinsics.b(permission, "android.permission.WRITE_SETTINGS")) {
            if (Build.VERSION.SDK_INT >= 23) {
                WifiUtils.f59242a.t(this);
            }
        } else {
            e eVar = e.f76637a;
            if (eVar.f(permissionsBean.getPermission())) {
                return;
            }
            eVar.i(this, permissionsBean.getPermission(), 101);
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003d  */
    public final void v0() {
        List<PermissionsBean> arrayList;
        Intent intent = getIntent();
        String action = intent != null ? intent.getAction() : null;
        if (action == null) {
            arrayList = new ArrayList<>();
        } else {
            int iHashCode = action.hashCode();
            if (iHashCode != -726963349) {
                if (iHashCode == -616897536 && action.equals("com.transsion.transfer.wifi.util.send")) {
                    arrayList = e.f76637a.e();
                } else {
                    arrayList = new ArrayList<>();
                }
            } else if (action.equals("com.transsion.transfer.wifi.util.receive")) {
                arrayList = e.f76637a.c();
            } else {
                arrayList = new ArrayList<>();
            }
        }
        this.f59187i = arrayList;
        if (!TextUtils.isEmpty(this.f59189k)) {
            PermissionState permissionState = e.f76637a.f(this.f59189k) ? PermissionState.PERMISSION_GRANTED : PermissionState.PERMISSION_DENIED;
            py.c cVar = py.c.f74067a;
            Intent intent2 = getIntent();
            cVar.l(intent2 != null ? intent2.getAction() : null, this.f59189k, permissionState);
            this.f59189k = "";
        }
        c cVar2 = this.f59188j;
        if (cVar2 != null) {
            cVar2.w0(this.f59187i);
        }
        Iterator<T> it = this.f59187i.iterator();
        boolean z11 = true;
        while (it.hasNext()) {
            if (((PermissionsBean) it.next()).getState() == PermissionState.PERMISSION_DENIED) {
                z11 = false;
            }
        }
        if (z11) {
            r0();
        }
    }
}
