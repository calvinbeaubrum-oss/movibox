package com.transsion.home.fragment.tab;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.ad.bidding.nativead.BiddingListManager;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.home.activity.MovieFilterActivity;
import com.transsion.home.fragment.HomeFragment;
import com.transsion.memberapi.IMemberApi;
import com.transsion.web.api.WebConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import n6.a;

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
@SourceDebugExtension
public abstract class BaseHomeSubFragment<T extends n6.a> extends BaseFragment<T> implements su.e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f52467f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f52468g = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f52469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f52470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f52471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BiddingListManager f52472d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final String i0() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    private final String m0() {
        switch (this.f52471c) {
            case 1:
                return "TrendingScene";
            case 2:
                return r0() ? "Home2MovieScene" : "Home1MovieScene";
            case 3:
                return "Home1EducationScene";
            case 4:
                return "Home1MusicScene";
            case 5:
                return r0() ? "Home2TvSeriesScene" : "Home1TvSeriesScene";
            case 6:
            default:
                com.transsion.ad.a.j(com.transsion.ad.a.f50276a, i0() + " --> mTabCode = " + this.f52470b + " --> 当前没有匹配到场景信息 --> mTabId = " + this.f52471c + " --> 不初始化广告相关模块了", false, 2, null);
                return "";
            case 7:
                return "Home1ShortTvScene";
            case 8:
                return r0() ? "Home2AnimationScene" : "Home1AnimationScene";
        }
    }

    private final void p0() {
        if (TextUtils.isEmpty(m0()) || l0() == null) {
            return;
        }
        BiddingListManager biddingListManager = new BiddingListManager();
        this.f52472d = biddingListManager;
        biddingListManager.F(l0());
        BiddingListManager biddingListManager2 = this.f52472d;
        if (biddingListManager2 != null) {
            biddingListManager2.A(androidx.lifecycle.v.a(this));
        }
        BiddingListManager biddingListManager3 = this.f52472d;
        if (biddingListManager3 != null) {
            biddingListManager3.G(m0());
        }
        BiddingListManager biddingListManager4 = this.f52472d;
        if (biddingListManager4 != null) {
            biddingListManager4.z(new Function2<Integer, com.transsion.ad.bidding.nativead.c, Unit>(this) { // from class: com.transsion.home.fragment.tab.BaseHomeSubFragment$initAd$1
                final /* synthetic */ BaseHomeSubFragment<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, com.transsion.ad.bidding.nativead.c cVar) {
                    invoke(num.intValue(), cVar);
                    return Unit.f68710a;
                }

                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                public final void invoke(int i11, com.transsion.ad.bidding.nativead.c current) {
                    Intrinsics.g(current, "current");
                    this.this$0.s0(i11, current);
                }
            });
        }
        w0(null);
    }

    public final void g0(boolean z11) {
        this.f52469a = z11;
        Fragment parentFragment = getParentFragment();
        HomeFragment homeFragment = parentFragment instanceof HomeFragment ? (HomeFragment) parentFragment : null;
        if (homeFragment != null) {
            homeFragment.s0(z11);
        }
    }

    public void h0() {
        t0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        p0();
    }

    public final String j0() {
        return this.f52470b;
    }

    public final int k0() {
        return this.f52471c;
    }

    public abstract RecyclerView l0();

    public final int n0() {
        return com.blankj.utilcode.util.f0.a(78.0f) + com.blankj.utilcode.util.d.c();
    }

    public final BiddingListManager o0() {
        return this.f52472d;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f52470b = arguments != null ? arguments.getString(WebConstants.TAB_CODE) : null;
        Bundle arguments2 = getArguments();
        this.f52471c = arguments2 != null ? arguments2.getInt("tab_id") : 0;
        ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).w(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        t0();
        ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).V0(this);
    }

    @Override // su.e
    public void onMemberStateChange() {
        if (isFirst()) {
            return;
        }
        h0();
    }

    public final boolean q0() {
        return this.f52469a;
    }

    public final boolean r0() {
        return getActivity() instanceof MovieFilterActivity;
    }

    public abstract void s0(int i11, com.transsion.ad.bidding.nativead.c cVar);

    public final void t0() {
        com.transsion.ad.a.f50276a.i(i0() + " --> resetAd() --> mTabCode = " + this.f52470b + " --> getSceneId() = " + m0(), false);
        BiddingListManager biddingListManager = this.f52472d;
        if (biddingListManager != null) {
            biddingListManager.y();
        }
    }

    public final void u0() {
        g0(this.f52469a);
    }

    public void v0() {
    }

    public final void w0(Map<String, String> map) {
        Map<String, Object> mapA = com.transsion.ad.strategy.b.f50584a.a("");
        Bundle arguments = getArguments();
        mapA.put("channelId", String.valueOf(arguments != null ? Integer.valueOf(arguments.getInt("tab_id")) : null));
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                mapA.put(entry.getKey(), entry.getValue());
            }
        }
        BiddingListManager biddingListManager = this.f52472d;
        if (biddingListManager != null) {
            biddingListManager.B(mapA);
        }
    }
}
