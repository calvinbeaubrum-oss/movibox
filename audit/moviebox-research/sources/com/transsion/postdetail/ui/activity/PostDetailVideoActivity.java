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
import com.transsion.baselib.report.f;
import com.transsion.baseui.R$color;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.helper.ImmVideoHelper;
import com.transsion.postdetail.ui.fragment.PostAudioDetailFragment;
import com.transsion.postdetail.ui.fragment.PostImageTextDetailFragment;
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
@Route(path = "/post/detailVideo")
@Metadata
@SourceDebugExtension
public final class PostDetailVideoActivity extends BaseNewActivity<tv.b> implements f {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f55554v = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Autowired(name = "media_type")
    @JvmField
    public String f55555i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Autowired(name = "id")
    @JvmField
    public String f55556j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Autowired(name = "item_type")
    @JvmField
    public String f55557k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Autowired(name = "from_comment")
    @JvmField
    public boolean f55558l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Autowired(name = "rec_ops")
    @JvmField
    public String f55559m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Autowired(name = "tab_id")
    @JvmField
    public int f55560n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Autowired(name = "video_load_more")
    @JvmField
    public boolean f55561o = true;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Autowired(name = WebConstants.PAGE_FROM)
    @JvmField
    public String f55562p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Autowired(name = "item_object")
    @JvmField
    public PostSubjectItem f55563q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Autowired(name = "is_build_in")
    @JvmField
    public boolean f55564r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f55565s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Fragment f55566t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Fragment f55567u;

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
        public final /* synthetic */ Function1 f55568a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f55568a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f55568a;
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
            this.f55568a.invoke(obj);
        }
    }

    public PostDetailVideoActivity() {
        final Function0 function0 = null;
        this.f55565s = new ViewModelLazy(Reflection.b(PostDetailViewModel.class), new Function0<x0>() { // from class: com.transsion.postdetail.ui.activity.PostDetailVideoActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                return this.getViewModelStore();
            }
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.ui.activity.PostDetailVideoActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                return this.getDefaultViewModelProviderFactory();
            }
        }, new Function0<r3.a>() { // from class: com.transsion.postdetail.ui.activity.PostDetailVideoActivity$special$$inlined$viewModels$default$3
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

    private final PostDetailViewModel q0() {
        return (PostDetailViewModel) this.f55565s.getValue();
    }

    private final void r0() {
        i0();
        if (!this.f55564r && !com.tn.lib.util.networkinfo.f.f49475a.e()) {
            k0();
            return;
        }
        if (this.f55556j == null || !TextUtils.isEmpty(this.f55555i)) {
            s0();
            return;
        }
        PostDetailViewModel postDetailViewModelQ0 = q0();
        String str = this.f55556j;
        if (str == null) {
            str = "";
        }
        postDetailViewModelQ0.n(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s0() {
        g0();
        u0();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.f(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
        Fragment fragmentV0 = v0(this.f55555i);
        if (fragmentV0 != null) {
            fragmentTransactionBeginTransaction.replace(R$id.container, fragmentV0);
        } else {
            fragmentV0 = null;
        }
        this.f55567u = fragmentV0;
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    private final void t0() {
        if (TextUtils.equals(MediaType.VIDEO.getValue(), this.f55555i)) {
            ((IFloatingApi) com.alibaba.android.arouter.launcher.a.d().h(IFloatingApi.class)).j0();
        }
    }

    private final void u0() {
        if (TextUtils.equals(MediaType.VIDEO.getValue(), this.f55555i)) {
            ((IFloatingApi) com.alibaba.android.arouter.launcher.a.d().h(IFloatingApi.class)).c0();
        }
    }

    private final Fragment v0(String str) {
        Fragment fragmentA;
        if (Intrinsics.b(str, MediaType.AUDIO.getValue())) {
            setRequestedOrientation(1);
            fragmentA = PostAudioDetailFragment.A.a(this.f55556j, this.f55558l, this.f55559m, this.f55563q);
        } else if (Intrinsics.b(str, MediaType.VIDEO.getValue())) {
            PostSubjectItem postSubjectItem = this.f55563q;
            if (postSubjectItem != null) {
                ImmVideoHelper.f55024g.a().o(postSubjectItem);
            }
            fragmentA = VideoFragment.A.a(this.f55556j, this.f55557k, Integer.valueOf(this.f55560n), this.f55561o, (64 & 16) != 0 ? true : this.f55558l, (64 & 32) != 0 ? "" : this.f55559m, (64 & 64) != 0 ? false : false, (64 & 128) != 0 ? "" : null, (64 & 256) != 0 ? null : this.f55562p, (64 & 512) != 0 ? false : false);
        } else {
            setRequestedOrientation(1);
            fragmentA = PostImageTextDetailFragment.f55773u.a(this.f55556j, this.f55558l, this.f55559m, this.f55563q, this.f55562p);
        }
        this.f55566t = fragmentA;
        return fragmentA;
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
        q0().q().j(this, new b(new Function1<PostSubjectItem, Unit>() { // from class: com.transsion.postdetail.ui.activity.PostDetailVideoActivity$initViewModel$1
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
                PostDetailVideoActivity postDetailVideoActivity = this.this$0;
                Media media = postSubjectItem.getMedia();
                postDetailVideoActivity.f55555i = media != null ? media.getMediaType() : null;
                if (Intrinsics.b(this.this$0.f55555i, MediaType.VIDEO.getValue())) {
                    ImmVideoHelper.f55024g.a().o(postSubjectItem);
                }
                PostDetailVideoActivity postDetailVideoActivity2 = this.this$0;
                postDetailVideoActivity2.f55563q = postSubjectItem;
                postDetailVideoActivity2.s0();
            }
        }));
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean b0() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void c0() {
        r0();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public String getPageName() {
        return "postdetail";
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public boolean isMonitorNetworkState() {
        return !this.f55564r;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isStatusDark() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean m0() {
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Fragment fragment = this.f55566t;
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
        if (!this.f55564r || com.tn.lib.util.networkinfo.f.f49475a.e()) {
            return;
        }
        c0();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseMusicFloatActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        u0();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        t0();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public tv.b getViewBinding() {
        tv.b bVarC = tv.b.c(getLayoutInflater());
        Intrinsics.f(bVarC, "inflate(layoutInflater)");
        return bVarC;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void retryLoadData() {
        if (this.f55567u == null) {
            r0();
        }
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public int statusColor() {
        return R$color.base_color_black;
    }
}
