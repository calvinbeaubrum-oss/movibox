package com.transsion.play.detail;

import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.d0;
import androidx.lifecycle.u;
import androidx.lifecycle.v0;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.i;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.R$string;
import com.transsion.baseui.widget.magicindicator.ORCommonNavigator;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.SubjectPostCount;
import com.transsion.play.detail.viewmodel.PlayDetailViewModel;
import com.transsion.play.detail.widget.PlayDetailResTabTitleView;
import com.transsion.videodetail.api.IStreamDetailService;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.PublishEvent;
import h20.d;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.g;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.k;
import kotlinx.coroutines.w0;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;

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
public final class PlayDetailBottomRecHelper {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a f54164q = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f54165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Subject f54166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MagicIndicator f54167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewPager2 f54168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f54169e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f54170f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f54171g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<Integer, Unit> f54172h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ORCommonNavigator f54173i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f54174j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FragmentStateAdapter f54175k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f54176l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f54177m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f54178n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f54179o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<String> f54180p;

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
    public final class b extends ks.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ViewPager2 f54181b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<String> f54182c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f54183d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f54184e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ PlayDetailBottomRecHelper f54185f;

        public b(PlayDetailBottomRecHelper playDetailBottomRecHelper, ViewPager2 viewPager2, List<String> tabList, boolean z11, boolean z12) {
            Intrinsics.g(tabList, "tabList");
            this.f54185f = playDetailBottomRecHelper;
            this.f54181b = viewPager2;
            this.f54182c = tabList;
            this.f54183d = z11;
            this.f54184e = z12;
        }

        public static final void k(int i11, PlayDetailBottomRecHelper this$0, PlayDetailResTabTitleView this_apply, b this$1, View view) {
            Intrinsics.g(this$0, "this$0");
            Intrinsics.g(this_apply, "$this_apply");
            Intrinsics.g(this$1, "this$1");
            if (i11 == 1 && this$0.f54178n) {
                this$0.f54178n = false;
                this_apply.setDotVisibility(false);
                RoomAppMMKV.f51271a.a().putBoolean("key_subj_comment_dot", false);
            }
            ViewPager2 viewPager2 = this$1.f54181b;
            if (viewPager2 != null) {
                viewPager2.setCurrentItem(i11, true);
            }
        }

        @Override // h20.a
        public int a() {
            return (this.f54183d && this.f54184e) ? this.f54182c.size() - 1 : this.f54182c.size();
        }

        @Override // h20.a
        public h20.c b(Context context) {
            Intrinsics.g(context, "context");
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setMode(1);
            linePagerIndicator.setLineHeight(i.e(3.0f));
            linePagerIndicator.setStartInterpolator(new AccelerateInterpolator());
            linePagerIndicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
            linePagerIndicator.setColors(-1, -1, -1);
            return linePagerIndicator;
        }

        @Override // h20.a
        public h20.d c(Context context, final int i11) {
            Intrinsics.g(context, "context");
            final PlayDetailResTabTitleView playDetailResTabTitleView = new PlayDetailResTabTitleView(context);
            final PlayDetailBottomRecHelper playDetailBottomRecHelper = this.f54185f;
            if (i11 == 1) {
                playDetailResTabTitleView.setDotVisibility(playDetailBottomRecHelper.f54178n);
            }
            playDetailResTabTitleView.setTitle(this.f54182c.get(i11));
            playDetailResTabTitleView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.play.detail.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlayDetailBottomRecHelper.b.k(i11, playDetailBottomRecHelper, playDetailResTabTitleView, this, view);
                }
            });
            return playDetailResTabTitleView;
        }

        @Override // ks.a
        public LinearLayout.LayoutParams h(Context context, int i11) {
            Intrinsics.g(context, "context");
            return j();
        }

        public final LinearLayout.LayoutParams j() {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.setMarginStart(gs.a.a(6));
            layoutParams.setMarginEnd(gs.a.a(2));
            return layoutParams;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends ViewPager2.OnPageChangeCallback {
        public c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i11) {
            super.onPageScrollStateChanged(i11);
            MagicIndicator magicIndicator = PlayDetailBottomRecHelper.this.f54167c;
            if (magicIndicator != null) {
                magicIndicator.onPageScrollStateChanged(i11);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i11, float f11, int i12) {
            super.onPageScrolled(i11, f11, i12);
            MagicIndicator magicIndicator = PlayDetailBottomRecHelper.this.f54167c;
            if (magicIndicator != null) {
                magicIndicator.onPageScrolled(i11, f11, i12);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            super.onPageSelected(i11);
            Function1 function1 = PlayDetailBottomRecHelper.this.f54172h;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(i11));
            }
            MagicIndicator magicIndicator = PlayDetailBottomRecHelper.this.f54167c;
            if (magicIndicator != null) {
                magicIndicator.onPageSelected(i11);
            }
            PlayDetailBottomRecHelper.this.f54176l = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends FragmentStateAdapter {
        public d(Fragment fragment) {
            super(fragment);
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i11) {
            if (i11 != 0) {
                IStreamDetailService iStreamDetailService = (IStreamDetailService) com.alibaba.android.arouter.launcher.a.d().h(IStreamDetailService.class);
                Subject subject = PlayDetailBottomRecHelper.this.f54166b;
                return iStreamDetailService.V(subject != null ? subject.getSubjectId() : null, PlayDetailBottomRecHelper.this.f54169e);
            }
            IStreamDetailService iStreamDetailService2 = (IStreamDetailService) com.alibaba.android.arouter.launcher.a.d().h(IStreamDetailService.class);
            Subject subject2 = PlayDetailBottomRecHelper.this.f54166b;
            String subjectId = subject2 != null ? subject2.getSubjectId() : null;
            Subject subject3 = PlayDetailBottomRecHelper.this.f54166b;
            Integer subjectType = subject3 != null ? subject3.getSubjectType() : null;
            Subject subject4 = PlayDetailBottomRecHelper.this.f54166b;
            return iStreamDetailService2.a1(subjectId, subjectType, subject4 != null ? subject4.getOps() : null, PlayDetailBottomRecHelper.this.f54169e, PlayDetailBottomRecHelper.this.f54170f, PlayDetailBottomRecHelper.this.f54171g);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return (PlayDetailBottomRecHelper.this.f54170f && PlayDetailBottomRecHelper.this.f54171g) ? PlayDetailBottomRecHelper.this.f54180p.size() - 1 : PlayDetailBottomRecHelper.this.f54180p.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f54188a;

        public e(Function1 function) {
            Intrinsics.g(function, "function");
            this.f54188a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f54188a;
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
            this.f54188a.invoke(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PlayDetailBottomRecHelper(Fragment fragment, Subject subject, MagicIndicator magicIndicator, ViewPager2 viewPager2, String str, boolean z11, boolean z12, Function1<? super Integer, Unit> function1) {
        Intrinsics.g(fragment, "fragment");
        this.f54165a = fragment;
        this.f54166b = subject;
        this.f54167c = magicIndicator;
        this.f54168d = viewPager2;
        this.f54169e = str;
        this.f54170f = z11;
        this.f54171g = z12;
        this.f54172h = function1;
        this.f54179o = LazyKt__LazyJVMKt.b(new Function0<PlayDetailViewModel>() { // from class: com.transsion.play.detail.PlayDetailBottomRecHelper$playDetailViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PlayDetailViewModel invoke() {
                return (PlayDetailViewModel) new v0(this.this$0.f54165a).a(PlayDetailViewModel.class);
            }
        });
        this.f54180p = g.o(Utils.a().getString(R$string.for_you), Utils.a().getString(R$string.name_comments));
        q();
        t();
        s();
        r();
    }

    public /* synthetic */ PlayDetailBottomRecHelper(Fragment fragment, Subject subject, MagicIndicator magicIndicator, ViewPager2 viewPager2, String str, boolean z11, boolean z12, Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragment, subject, magicIndicator, viewPager2, str, (i11 & 32) != 0 ? false : z11, (i11 & 64) != 0 ? false : z12, (i11 & 128) != 0 ? null : function1);
    }

    public final void o() {
        ViewPager2 viewPager2 = this.f54168d;
        if (viewPager2 != null) {
            viewPager2.registerOnPageChangeCallback(new c());
        }
        ViewPager2 viewPager3 = this.f54168d;
        if (viewPager3 != null) {
            viewPager3.setCurrentItem(this.f54176l, false);
        }
    }

    public final PlayDetailViewModel p() {
        return (PlayDetailViewModel) this.f54179o.getValue();
    }

    public final void q() {
        this.f54178n = RoomAppMMKV.f51271a.a().getBoolean("key_subj_comment_dot", true);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void r() {
        ORCommonNavigator oRCommonNavigator = new ORCommonNavigator(this.f54165a.requireContext());
        oRCommonNavigator.setFollowTouch(true);
        b bVar = new b(this, this.f54168d, this.f54180p, this.f54170f, this.f54171g);
        this.f54174j = bVar;
        oRCommonNavigator.setAdapter(bVar);
        this.f54173i = oRCommonNavigator;
        MagicIndicator magicIndicator = this.f54167c;
        if (magicIndicator == null) {
            return;
        }
        magicIndicator.setNavigator(oRCommonNavigator);
    }

    public final void s() {
        d dVar = new d(this.f54165a);
        this.f54175k = dVar;
        ViewPager2 viewPager2 = this.f54168d;
        if (viewPager2 != null) {
            viewPager2.setAdapter(dVar);
        }
        ViewPager2 viewPager3 = this.f54168d;
        if (viewPager3 != null) {
            viewPager3.setUserInputEnabled(false);
        }
        o();
    }

    public final void t() {
        String subjectId;
        Fragment fragment = this.f54165a;
        Function1<PublishEvent, Unit> function1 = new Function1<PublishEvent, Unit>() { // from class: com.transsion.play.detail.PlayDetailBottomRecHelper$initViwModel$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PublishEvent publishEvent) {
                invoke2(publishEvent);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PublishEvent it) {
                String str;
                Intrinsics.g(it, "it");
                this.this$0.f54177m++;
                String strValueOf = this.this$0.f54177m > 99 ? "99+" : String.valueOf(this.this$0.f54177m);
                Object obj = this.this$0.f54180p.get(1);
                if (strValueOf.length() == 0) {
                    str = "";
                } else {
                    str = "(" + strValueOf + ")";
                }
                String str2 = obj + str;
                ORCommonNavigator oRCommonNavigator = this.this$0.f54173i;
                d pagerTitleView = oRCommonNavigator != null ? oRCommonNavigator.getPagerTitleView(1) : null;
                PlayDetailResTabTitleView playDetailResTabTitleView = pagerTitleView instanceof PlayDetailResTabTitleView ? (PlayDetailResTabTitleView) pagerTitleView : null;
                if (playDetailResTabTitleView != null) {
                    playDetailResTabTitleView.setTitle(str2);
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = PublishEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(fragment, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
        p().f().j(this.f54165a, new e(new Function1<SubjectPostCount, Unit>() { // from class: com.transsion.play.detail.PlayDetailBottomRecHelper$initViwModel$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SubjectPostCount subjectPostCount) {
                invoke2(subjectPostCount);
                return Unit.f68710a;
            }

            /* JADX WARN: Code duplicated, block: B:23:0x0046  */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SubjectPostCount subjectPostCount) {
                String count;
                String count2 = subjectPostCount != null ? subjectPostCount.getCount() : null;
                if (count2 == null || count2.length() == 0) {
                    return;
                }
                String count3 = subjectPostCount != null ? subjectPostCount.getCount() : null;
                Intrinsics.d(count3);
                Long lN = k.n(count3);
                String str = "";
                if (lN != null) {
                    PlayDetailBottomRecHelper playDetailBottomRecHelper = this.this$0;
                    long jLongValue = lN.longValue();
                    playDetailBottomRecHelper.f54177m = jLongValue;
                    if (jLongValue > 99) {
                        count = "99+";
                    } else {
                        count = jLongValue <= 0 ? "" : String.valueOf(jLongValue);
                    }
                    if (count == null) {
                        count = subjectPostCount.getCount();
                    }
                } else {
                    count = subjectPostCount.getCount();
                }
                Object obj = this.this$0.f54180p.get(1);
                if (count != null && count.length() != 0) {
                    str = "(" + count + ")";
                }
                String str2 = obj + str;
                if (this.this$0.f54170f && this.this$0.f54171g) {
                    return;
                }
                ORCommonNavigator oRCommonNavigator = this.this$0.f54173i;
                d pagerTitleView = oRCommonNavigator != null ? oRCommonNavigator.getPagerTitleView(1) : null;
                PlayDetailResTabTitleView playDetailResTabTitleView = pagerTitleView instanceof PlayDetailResTabTitleView ? (PlayDetailResTabTitleView) pagerTitleView : null;
                if (playDetailResTabTitleView != null) {
                    playDetailResTabTitleView.setTitle(str2);
                }
            }
        }));
        Subject subject = this.f54166b;
        if (subject == null || (subjectId = subject.getSubjectId()) == null) {
            return;
        }
        p().e(subjectId);
    }

    public final void u(boolean z11) {
        if (com.transsion.baseui.util.c.f51452a.a(90991, 500L) || !this.f54165a.isAdded() || this.f54165a.isDetached() || this.f54165a.isRemoving()) {
            return;
        }
        List<Fragment> fragments = this.f54165a.getChildFragmentManager().getFragments();
        Intrinsics.f(fragments, "fragment.childFragmentManager.fragments");
        for (u uVar : fragments) {
            if (uVar instanceof qz.a) {
                ((qz.a) uVar).o(z11);
            }
        }
    }
}
