package com.transsion.postdetail.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.report.f;
import com.transsion.baselib.utils.o;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$string;
import com.transsion.postdetail.helper.ImmVideoHelper;
import com.transsion.postdetail.ui.fragment.PostAudioDetailFragment;
import com.transsion.postdetail.ui.fragment.PostDetailFragment;
import com.transsion.postdetail.ui.fragment.VideoFragment;
import com.transsion.postdetail.viewmodel.PostDetailViewModel;
import com.transsion.room.api.IFloatingApi;
import com.transsion.web.api.WebConstants;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import rw.e;

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
@Route(path = "/post/detail")
@Metadata
@SourceDebugExtension
public final class PostDetailActivity extends BaseNewActivity<tv.b> implements f {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final a f55537x = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Autowired(name = "media_type")
    @JvmField
    public String f55538i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Autowired(name = "id")
    @JvmField
    public String f55539j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Autowired(name = "item_type")
    @JvmField
    public String f55540k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Autowired(name = "from_comment")
    @JvmField
    public boolean f55541l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Autowired(name = "rec_ops")
    @JvmField
    public String f55542m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Autowired(name = "tab_id")
    @JvmField
    public int f55543n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Autowired(name = WebConstants.PAGE_FROM)
    @JvmField
    public String f55545p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Autowired(name = "item_object")
    @JvmField
    public PostSubjectItem f55546q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Autowired(name = "comment_id")
    @JvmField
    public String f55547r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Autowired(name = "need_back_to_room")
    @JvmField
    public boolean f55548s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f55549t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Fragment f55550u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Fragment f55551v;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Autowired(name = "video_load_more")
    @JvmField
    public boolean f55544o = true;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f55552w = "";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f55553a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f55553a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f55553a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f55553a.invoke(obj);
        }
    }

    public PostDetailActivity() {
        final Function0 function0 = null;
        this.f55549t = new ViewModelLazy(Reflection.b(PostDetailViewModel.class), new Function0<x0>() { // from class: com.transsion.postdetail.ui.activity.PostDetailActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                return this.getViewModelStore();
            }
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.ui.activity.PostDetailActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                return this.getDefaultViewModelProviderFactory();
            }
        }, new Function0<r3.a>() { // from class: com.transsion.postdetail.ui.activity.PostDetailActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final r3.a invoke() {
                r3.a aVar;
                Function0 function1 = function0;
                return (function1 == null || (aVar = (r3.a) function1.invoke()) == null) ? this.getDefaultViewModelCreationExtras() : aVar;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u0() {
        w0();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.f(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
        Fragment fragmentX0 = x0(this.f55538i);
        if (fragmentX0 != null) {
            fragmentTransactionBeginTransaction.replace(R$id.container, fragmentX0);
        } else {
            fragmentX0 = null;
        }
        this.f55551v = fragmentX0;
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public String O() {
        return this.f55552w;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public String U() {
        return "";
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void X() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void Y() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void Z() {
        r0().q().j(this, new b(new Function1<PostSubjectItem, Unit>() { // from class: com.transsion.postdetail.ui.activity.PostDetailActivity$initViewModel$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PostSubjectItem postSubjectItem) {
                invoke2(postSubjectItem);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PostSubjectItem postSubjectItem) {
                if (postSubjectItem == null) {
                    this.this$0.h0();
                    return;
                }
                PostDetailActivity postDetailActivity = this.this$0;
                Media media = postSubjectItem.getMedia();
                postDetailActivity.f55538i = media != null ? media.getMediaType() : null;
                if (Intrinsics.b(this.this$0.f55538i, MediaType.VIDEO.getValue())) {
                    ImmVideoHelper.f55024g.a().o(postSubjectItem);
                }
                PostDetailActivity postDetailActivity2 = this.this$0;
                postDetailActivity2.f55546q = postSubjectItem;
                postDetailActivity2.f0();
                this.this$0.u0();
            }
        }));
        r0().o().j(this, new b(new Function1<String, Unit>() { // from class: com.transsion.postdetail.ui.activity.PostDetailActivity$initViewModel$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                if (Intrinsics.b(str, "404")) {
                    PostDetailActivity postDetailActivity = this.this$0;
                    String string = postDetailActivity.getString(R$string.post_delete_tips);
                    Intrinsics.f(string, "getString(R.string.post_delete_tips)");
                    postDetailActivity.f55552w = string;
                }
            }
        }));
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean b0() {
        if (Intrinsics.b(MediaType.VIDEO.getValue(), this.f55538i)) {
            return false;
        }
        return super.b0();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void c0() {
        t0();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public String getPageName() {
        return "postdetail";
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isChangeStatusBar() {
        return s0();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isStatusDark() {
        if (s0()) {
            return false;
        }
        return super.isStatusDark();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f55548s) {
            e.b(e.f75743a, null, null, 3, null);
            finish();
            return;
        }
        Fragment fragment = this.f55550u;
        if (fragment instanceof PostAudioDetailFragment) {
            Intrinsics.e(fragment, "null cannot be cast to non-null type com.transsion.postdetail.ui.fragment.PostAudioDetailFragment");
            ((PostAudioDetailFragment) fragment).V1();
        }
        super.onBackPressed();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.alibaba.android.arouter.launcher.a.d().f(this);
        super.onCreate(bundle);
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseMusicFloatActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        w0();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        v0();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public tv.b getViewBinding() {
        tv.b bVarC = tv.b.c(getLayoutInflater());
        Intrinsics.f(bVarC, "inflate(layoutInflater)");
        return bVarC;
    }

    public final PostDetailViewModel r0() {
        return (PostDetailViewModel) this.f55549t.getValue();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void retryLoadData() {
        if (this.f55551v == null) {
            t0();
        }
    }

    public final boolean s0() {
        return Intrinsics.b(MediaType.VIDEO.getValue(), this.f55538i) || Intrinsics.b(MediaType.AUDIO.getValue(), this.f55538i) || o.f51321a.a();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public int statusColor() {
        return s0() ? R$color.gray_0_1 : super.statusColor();
    }

    public final void t0() {
        i0();
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            k0();
            return;
        }
        if (this.f55539j == null) {
            u0();
            return;
        }
        PostDetailViewModel postDetailViewModelR0 = r0();
        String str = this.f55539j;
        if (str == null) {
            str = "";
        }
        postDetailViewModelR0.n(str);
    }

    public final void v0() {
        if (TextUtils.equals(MediaType.VIDEO.getValue(), this.f55538i)) {
            ((IFloatingApi) com.alibaba.android.arouter.launcher.a.d().h(IFloatingApi.class)).j0();
        }
    }

    public final void w0() {
        if (TextUtils.equals(MediaType.VIDEO.getValue(), this.f55538i)) {
            ((IFloatingApi) com.alibaba.android.arouter.launcher.a.d().h(IFloatingApi.class)).c0();
        }
    }

    public final Fragment x0(String str) {
        Fragment fragmentA;
        if (Intrinsics.b(str, MediaType.VIDEO.getValue())) {
            g0();
            PostSubjectItem postSubjectItem = this.f55546q;
            if (postSubjectItem != null) {
                ImmVideoHelper.f55024g.a().o(postSubjectItem);
            }
            fragmentA = VideoFragment.A.a(this.f55539j, this.f55540k, Integer.valueOf(this.f55543n), this.f55544o, (64 & 16) != 0 ? true : this.f55541l, (64 & 32) != 0 ? "" : this.f55542m, (64 & 64) != 0 ? false : false, (64 & 128) != 0 ? "" : this.f55547r, (64 & 256) != 0 ? null : this.f55545p, (64 & 512) != 0 ? false : this.f55548s);
        } else {
            setRequestedOrientation(1);
            fragmentA = PostDetailFragment.f55758v.a(this.f55539j, this.f55541l, this.f55542m, this.f55546q, this.f55547r, this.f55545p);
        }
        this.f55550u = fragmentA;
        return fragmentA;
    }
}
