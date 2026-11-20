package com.transsion.usercenter;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.toast.core.h;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.usercenter.FollowActivity;
import f9.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import so.c;
import wy.g;
import xy.b;

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
public final class FollowActivity extends BaseActivity<b> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f59270c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f59271a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f59272b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final List<String> T() {
        return kotlin.collections.g.q("A", "B", "C", "D", "E");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void V() {
        this.f59272b = new g(this.f59271a);
        RecyclerView recyclerView = ((b) getMViewBinding()).f80719b;
        g gVar = this.f59272b;
        g gVar2 = null;
        if (gVar == null) {
            Intrinsics.y("followAdapter");
            gVar = null;
        }
        recyclerView.setAdapter(gVar);
        ((b) getMViewBinding()).f80719b.setLayoutManager(new LinearLayoutManager(this));
        g gVar3 = this.f59272b;
        if (gVar3 == null) {
            Intrinsics.y("followAdapter");
            gVar3 = null;
        }
        gVar3.i(R$id.btnFollow);
        g gVar4 = this.f59272b;
        if (gVar4 == null) {
            Intrinsics.y("followAdapter");
        } else {
            gVar2 = gVar4;
        }
        gVar2.z0(new f9.b() { // from class: wy.b
            @Override // f9.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                FollowActivity.W(baseQuickAdapter, view, i11);
            }
        });
        ((b) getMViewBinding()).f80720c.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: wy.c
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
            public final void a() {
                FollowActivity.X(this.f79752a);
            }
        });
        Y();
        ((b) getMViewBinding()).f80720c.setRefreshing(true);
        a0();
    }

    public static final void W(BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        h.f50034a.a("点击了第" + i11 + "个");
    }

    public static final void X(FollowActivity this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.a0();
    }

    public static final void Z(FollowActivity this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.c0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void a0() {
        ((b) getMViewBinding()).getRoot().postDelayed(new Runnable() { // from class: wy.e
            @Override // java.lang.Runnable
            public final void run() {
                FollowActivity.b0(this.f79754a);
            }
        }, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void b0(FollowActivity this$0) {
        Intrinsics.g(this$0, "this$0");
        ((b) this$0.getMViewBinding()).f80720c.setRefreshing(false);
        g gVar = this$0.f59272b;
        if (gVar == null) {
            Intrinsics.y("followAdapter");
            gVar = null;
        }
        gVar.w0(this$0.T());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void c0() {
        g gVar = this.f59272b;
        g gVar2 = null;
        if (gVar == null) {
            Intrinsics.y("followAdapter");
            gVar = null;
        }
        if (gVar.D().size() <= 20) {
            ((b) getMViewBinding()).getRoot().postDelayed(new Runnable() { // from class: wy.f
                @Override // java.lang.Runnable
                public final void run() {
                    FollowActivity.d0(this.f79755a);
                }
            }, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
            return;
        }
        g gVar3 = this.f59272b;
        if (gVar3 == null) {
            Intrinsics.y("followAdapter");
        } else {
            gVar2 = gVar3;
        }
        gVar2.Q().s(false);
    }

    public static final void d0(FollowActivity this$0) {
        Intrinsics.g(this$0, "this$0");
        g gVar = this$0.f59272b;
        g gVar2 = null;
        if (gVar == null) {
            Intrinsics.y("followAdapter");
            gVar = null;
        }
        gVar.m(this$0.T());
        g gVar3 = this$0.f59272b;
        if (gVar3 == null) {
            Intrinsics.y("followAdapter");
        } else {
            gVar2 = gVar3;
        }
        gVar2.Q().r();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public b getViewBinding() {
        b bVarC = b.c(getLayoutInflater());
        Intrinsics.f(bVarC, "inflate(layoutInflater)");
        return bVarC;
    }

    public final void Y() {
        g gVar = this.f59272b;
        g gVar2 = null;
        if (gVar == null) {
            Intrinsics.y("followAdapter");
            gVar = null;
        }
        gVar.Q().y(true);
        g gVar3 = this.f59272b;
        if (gVar3 == null) {
            Intrinsics.y("followAdapter");
            gVar3 = null;
        }
        gVar3.Q().x(true);
        g gVar4 = this.f59272b;
        if (gVar4 == null) {
            Intrinsics.y("followAdapter");
            gVar4 = null;
        }
        gVar4.Q().A(true);
        g gVar5 = this.f59272b;
        if (gVar5 == null) {
            Intrinsics.y("followAdapter");
            gVar5 = null;
        }
        gVar5.Q().z(false);
        g gVar6 = this.f59272b;
        if (gVar6 == null) {
            Intrinsics.y("followAdapter");
            gVar6 = null;
        }
        gVar6.Q().q();
        g gVar7 = this.f59272b;
        if (gVar7 == null) {
            Intrinsics.y("followAdapter");
            gVar7 = null;
        }
        gVar7.Q().D(1);
        g gVar8 = this.f59272b;
        if (gVar8 == null) {
            Intrinsics.y("followAdapter");
        } else {
            gVar2 = gVar8;
        }
        gVar2.Q().C(new f() { // from class: wy.d
            @Override // f9.f
            public final void a() {
                FollowActivity.Z(this.f79753a);
            }
        });
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f59271a = getIntent().getIntExtra("follow_type_key", 1);
        LinearLayoutCompat root = ((b) getMViewBinding()).getRoot();
        Intrinsics.f(root, "mViewBinding.root");
        c.e(root);
        TitleLayout titleLayout = ((b) getMViewBinding()).f80721d;
        titleLayout.goneRightViewLayout();
        if (this.f59271a == 1) {
            String string = getString(R$string.user_center_follow_following);
            Intrinsics.f(string, "getString(R.string.user_center_follow_following)");
            titleLayout.setTitleText(string);
        } else {
            String string2 = getString(R$string.user_center_follow_followers);
            Intrinsics.f(string2, "getString(R.string.user_center_follow_followers)");
            titleLayout.setTitleText(string2);
        }
        V();
    }
}
