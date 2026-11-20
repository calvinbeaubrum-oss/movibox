package com.transsion.audio.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.d0;
import androidx.lifecycle.m;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.i;
import com.tn.lib.view.GradientLinePagerIndicator;
import com.tn.lib.widget.R$color;
import com.transsion.audio.R$layout;
import com.transsion.audio.R$string;
import com.transsion.audio.adapter.dialog.ClearTipsDialog;
import com.transsion.audio.viewmodel.HistoryListManager;
import com.transsion.audio.viewmodel.SubjectListViewModel;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.baseui.widget.RoomSimplePagerTitleView;
import com.transsion.room.api.IAudioApi;
import com.transsnet.downloader.bean.DownloadListBean;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

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
public final class AudioBottomSheetFragment extends BaseDialog {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f50775o = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f50776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public GradientLinePagerIndicator f50777d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CommonNavigator f50778f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SubjectListFragment f50779g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RecentListFragment f50780h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public fr.a f50781i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String[] f50782j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RoomSimplePagerTitleView[] f50783k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.transsion.audio.adapter.c f50784l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f50785m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f50786n;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final AudioBottomSheetFragment a(AudioBean audioBean) {
            Intrinsics.g(audioBean, "audioBean");
            AudioBottomSheetFragment audioBottomSheetFragment = new AudioBottomSheetFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("field_item", audioBean);
            audioBottomSheetFragment.setArguments(bundle);
            return audioBottomSheetFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends h20.a {

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a extends com.transsion.baseui.util.f {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ AudioBottomSheetFragment f50788f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ int f50789g;

            public a(AudioBottomSheetFragment audioBottomSheetFragment, int i11) {
                this.f50788f = audioBottomSheetFragment;
                this.f50789g = i11;
            }

            @Override // com.transsion.baseui.util.f
            public void c(View view) {
            }

            @Override // com.transsion.baseui.util.f
            public void d(View view) {
                ViewPager2 viewPager2;
                fr.a aVar = this.f50788f.f50781i;
                if (aVar == null || (viewPager2 = aVar.f65226h) == null) {
                    return;
                }
                viewPager2.setCurrentItem(this.f50789g, true);
            }
        }

        public b() {
        }

        @Override // h20.a
        public int a() {
            String[] strArr = AudioBottomSheetFragment.this.f50782j;
            if (strArr != null) {
                return strArr.length;
            }
            return 0;
        }

        @Override // h20.a
        public h20.c b(Context context) {
            if (AudioBottomSheetFragment.this.f50777d != null) {
                GradientLinePagerIndicator gradientLinePagerIndicator = AudioBottomSheetFragment.this.f50777d;
                ViewParent parent = gradientLinePagerIndicator != null ? gradientLinePagerIndicator.getParent() : null;
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup != null) {
                    viewGroup.removeView(AudioBottomSheetFragment.this.f50777d);
                }
                GradientLinePagerIndicator gradientLinePagerIndicator2 = AudioBottomSheetFragment.this.f50777d;
                Intrinsics.d(gradientLinePagerIndicator2);
                return gradientLinePagerIndicator2;
            }
            AudioBottomSheetFragment audioBottomSheetFragment = AudioBottomSheetFragment.this;
            Context contextRequireContext = AudioBottomSheetFragment.this.requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            GradientLinePagerIndicator gradientLinePagerIndicator3 = new GradientLinePagerIndicator(contextRequireContext);
            AudioBottomSheetFragment audioBottomSheetFragment2 = AudioBottomSheetFragment.this;
            gradientLinePagerIndicator3.setMode(2);
            gradientLinePagerIndicator3.setLineHeight(i.e(3.0f));
            gradientLinePagerIndicator3.setLineWidth(i.e(24.0f));
            gradientLinePagerIndicator3.setRoundRadius(i.e(1.0f));
            gradientLinePagerIndicator3.setStartInterpolator(new AccelerateInterpolator());
            gradientLinePagerIndicator3.setEndInterpolator(new DecelerateInterpolator(2.0f));
            gradientLinePagerIndicator3.setColors(z2.a.getColor(audioBottomSheetFragment2.requireContext(), R$color.brand_gradient_start), z2.a.getColor(audioBottomSheetFragment2.requireContext(), R$color.brand_gradient_center), z2.a.getColor(audioBottomSheetFragment2.requireContext(), R$color.brand_gradient_end));
            audioBottomSheetFragment.f50777d = gradientLinePagerIndicator3;
            GradientLinePagerIndicator gradientLinePagerIndicator4 = AudioBottomSheetFragment.this.f50777d;
            Intrinsics.d(gradientLinePagerIndicator4);
            return gradientLinePagerIndicator4;
        }

        @Override // h20.a
        public h20.d c(Context context, int i11) {
            String str;
            RoomSimplePagerTitleView[] roomSimplePagerTitleViewArr = AudioBottomSheetFragment.this.f50783k;
            RoomSimplePagerTitleView roomSimplePagerTitleView = roomSimplePagerTitleViewArr != null ? roomSimplePagerTitleViewArr[i11] : null;
            if (roomSimplePagerTitleView != null) {
                ViewParent parent = roomSimplePagerTitleView.getParent();
                Intrinsics.e(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).removeView(roomSimplePagerTitleView);
                String[] strArr = AudioBottomSheetFragment.this.f50782j;
                if (strArr == null || (str = strArr[i11]) == null) {
                    str = "";
                }
                roomSimplePagerTitleView.setText(str);
                return roomSimplePagerTitleView;
            }
            Context contextRequireContext = AudioBottomSheetFragment.this.requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            RoomSimplePagerTitleView roomSimplePagerTitleView2 = new RoomSimplePagerTitleView(contextRequireContext);
            AudioBottomSheetFragment audioBottomSheetFragment = AudioBottomSheetFragment.this;
            roomSimplePagerTitleView2.setSingleLine(false);
            String[] strArr2 = audioBottomSheetFragment.f50782j;
            if (strArr2 != null) {
                roomSimplePagerTitleView2.setText(strArr2[i11]);
            }
            roomSimplePagerTitleView2.setOnClickListener(new a(audioBottomSheetFragment, i11));
            RoomSimplePagerTitleView[] roomSimplePagerTitleViewArr2 = AudioBottomSheetFragment.this.f50783k;
            if (roomSimplePagerTitleViewArr2 != null) {
                roomSimplePagerTitleViewArr2[i11] = roomSimplePagerTitleView2;
            }
            return roomSimplePagerTitleView2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends ViewPager2.OnPageChangeCallback {
        public c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i11) {
            MagicIndicator magicIndicator;
            super.onPageScrollStateChanged(i11);
            fr.a aVar = AudioBottomSheetFragment.this.f50781i;
            if (aVar == null || (magicIndicator = aVar.f65224f) == null) {
                return;
            }
            magicIndicator.onPageScrollStateChanged(i11);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i11, float f11, int i12) {
            MagicIndicator magicIndicator;
            super.onPageScrolled(i11, f11, i12);
            fr.a aVar = AudioBottomSheetFragment.this.f50781i;
            if (aVar == null || (magicIndicator = aVar.f65224f) == null) {
                return;
            }
            magicIndicator.onPageScrolled(i11, f11, i12);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            AppCompatImageView appCompatImageView;
            MagicIndicator magicIndicator;
            super.onPageSelected(i11);
            fr.a aVar = AudioBottomSheetFragment.this.f50781i;
            if (aVar != null && (magicIndicator = aVar.f65224f) != null) {
                magicIndicator.onPageSelected(i11);
            }
            AudioBottomSheetFragment.this.f50776c = i11;
            RoomSimplePagerTitleView[] roomSimplePagerTitleViewArr = AudioBottomSheetFragment.this.f50783k;
            if (roomSimplePagerTitleViewArr == null || i11 != roomSimplePagerTitleViewArr.length - 1) {
                fr.a aVar2 = AudioBottomSheetFragment.this.f50781i;
                appCompatImageView = aVar2 != null ? aVar2.f65221b : null;
                if (appCompatImageView == null) {
                    return;
                }
                appCompatImageView.setVisibility(8);
                return;
            }
            fr.a aVar3 = AudioBottomSheetFragment.this.f50781i;
            appCompatImageView = aVar3 != null ? aVar3.f65221b : null;
            if (appCompatImageView == null) {
                return;
            }
            appCompatImageView.setVisibility(0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends FragmentStateAdapter {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ String f50792j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str) {
            super(AudioBottomSheetFragment.this);
            this.f50792j = str;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i11) {
            String[] strArr = AudioBottomSheetFragment.this.f50782j;
            if (strArr == null || i11 != strArr.length - 1) {
                AudioBottomSheetFragment.this.f50779g = SubjectListFragment.f50804r.b(this.f50792j);
                SubjectListFragment subjectListFragment = AudioBottomSheetFragment.this.f50779g;
                Intrinsics.d(subjectListFragment);
                return subjectListFragment;
            }
            AudioBottomSheetFragment.this.f50780h = new RecentListFragment();
            RecentListFragment recentListFragment = AudioBottomSheetFragment.this.f50780h;
            Intrinsics.d(recentListFragment);
            return recentListFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            String[] strArr = AudioBottomSheetFragment.this.f50782j;
            if (strArr != null) {
                return strArr.length;
            }
            return 0;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e implements er.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ClearTipsDialog f50793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AudioBottomSheetFragment f50794b;

        public e(ClearTipsDialog clearTipsDialog, AudioBottomSheetFragment audioBottomSheetFragment) {
            this.f50793a = clearTipsDialog;
            this.f50794b = audioBottomSheetFragment;
        }

        @Override // er.a
        public void a() {
            com.transsion.audio.adapter.c cVar = this.f50794b.f50784l;
            if (cVar != null) {
                cVar.w0(null);
            }
            HistoryListManager.f50901e.b().g();
            this.f50794b.dismissAllowingStateLoss();
        }

        @Override // er.a
        public void b() {
            this.f50793a.dismissAllowingStateLoss();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f50795a;

        public f(Function1 function) {
            Intrinsics.g(function, "function");
            this.f50795a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f50795a;
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
            this.f50795a.invoke(obj);
        }
    }

    public AudioBottomSheetFragment() {
        super(R$layout.fragment_bottom_dialog_audio);
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.audio.fragment.AudioBottomSheetFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        this.f50785m = FragmentViewModelLazyKt.a(this, Reflection.b(SubjectListViewModel.class), new Function0<x0>() { // from class: com.transsion.audio.fragment.AudioBottomSheetFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = ((y0) function0.invoke()).getViewModelStore();
                Intrinsics.f(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.audio.fragment.AudioBottomSheetFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                Object objInvoke = function0.invoke();
                m mVar = objInvoke instanceof m ? (m) objInvoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.f(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.f50786n = LazyKt__LazyJVMKt.b(new Function0<IAudioApi>() { // from class: com.transsion.audio.fragment.AudioBottomSheetFragment$mAudioApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IAudioApi invoke() {
                return (IAudioApi) com.alibaba.android.arouter.launcher.a.d().h(IAudioApi.class);
            }
        });
    }

    private final void A0() {
        ViewPager2 viewPager2;
        CommonNavigator commonNavigator = new CommonNavigator(requireContext());
        this.f50778f = commonNavigator;
        commonNavigator.setAdapter(new b());
        fr.a aVar = this.f50781i;
        MagicIndicator magicIndicator = aVar != null ? aVar.f65224f : null;
        if (magicIndicator != null) {
            magicIndicator.setNavigator(this.f50778f);
        }
        fr.a aVar2 = this.f50781i;
        if (aVar2 == null || (viewPager2 = aVar2.f65226h) == null) {
            return;
        }
        viewPager2.registerOnPageChangeCallback(new c());
    }

    private final void C0() {
        HistoryListManager.f50901e.b().o().j(this, new f(new Function1<DownloadListBean, Unit>() { // from class: com.transsion.audio.fragment.AudioBottomSheetFragment$initData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DownloadListBean downloadListBean) {
                invoke2(downloadListBean);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DownloadListBean downloadListBean) {
                this.this$0.D0(downloadListBean);
            }
        }));
    }

    public static final void F0(AudioBottomSheetFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        ClearTipsDialog clearTipsDialogA = ClearTipsDialog.f50770h.a();
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.f(childFragmentManager, "childFragmentManager");
        clearTipsDialogA.show(childFragmentManager, "dialog");
        clearTipsDialogA.r0(new e(clearTipsDialogA, this$0));
    }

    public static final void G0(AudioBottomSheetFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    public final int B0() {
        int i11 = getResources().getDisplayMetrics().heightPixels;
        return i11 - (i11 / 3);
    }

    public final void D0(DownloadListBean downloadListBean) {
        String strValueOf;
        String subjectTitle = downloadListBean != null ? downloadListBean.getSubjectTitle() : null;
        Integer totalEpisode = downloadListBean != null ? downloadListBean.getTotalEpisode() : null;
        String subjectId = downloadListBean != null ? downloadListBean.getSubjectId() : null;
        if (downloadListBean != null) {
            this.f50782j = new String[2];
            if (subjectTitle != null && subjectTitle.length() > 27) {
                String strSubstring = subjectTitle.substring(0, 27);
                Intrinsics.f(strSubstring, "substring(...)");
                subjectTitle = strSubstring + "...";
            }
            if (totalEpisode != null) {
                int iIntValue = totalEpisode.intValue();
                if (iIntValue > 0) {
                    strValueOf = ((Object) subjectTitle) + "(" + iIntValue + ")";
                } else {
                    strValueOf = String.valueOf(subjectTitle);
                }
            } else {
                strValueOf = null;
            }
            String[] strArr = this.f50782j;
            if (strArr != null) {
                strArr[0] = strValueOf;
            }
            if (strArr != null) {
                strArr[1] = getString(R$string.str_recently);
            }
        } else {
            this.f50782j = new String[]{getString(R$string.str_recently)};
        }
        String[] strArr2 = this.f50782j;
        this.f50783k = new RoomSimplePagerTitleView[strArr2 != null ? strArr2.length : 0];
        fr.a aVar = this.f50781i;
        ViewPager2 viewPager2 = aVar != null ? aVar.f65226h : null;
        if (viewPager2 != null) {
            viewPager2.setAdapter(new d(subjectId));
        }
        A0();
    }

    public final void E0(View view) {
        TextView textView;
        AppCompatImageView appCompatImageView;
        fr.a aVarA = fr.a.a(view);
        this.f50781i = aVarA;
        if (aVarA != null && (appCompatImageView = aVarA.f65221b) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.audio.fragment.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AudioBottomSheetFragment.F0(this.f50824a, view2);
                }
            });
        }
        fr.a aVar = this.f50781i;
        if (aVar == null || (textView = aVar.f65225g) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.audio.fragment.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AudioBottomSheetFragment.G0(this.f50825a, view2);
            }
        });
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.BottomDialogTheme);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        com.google.android.material.bottomsheet.b bVar = new com.google.android.material.bottomsheet.b(contextRequireContext, getTheme());
        Window window = bVar.getWindow();
        if (window != null) {
            window.setWindowAnimations(R$style.BaseBottomDialogAnimation);
        }
        Window window2 = bVar.getWindow();
        if (window2 != null) {
            window2.setGravity(80);
            window2.setDimAmount(0.5f);
            WindowManager.LayoutParams attributes = window2.getAttributes();
            if (attributes == null) {
                attributes = new WindowManager.LayoutParams();
            } else {
                Intrinsics.f(attributes, "it.attributes ?: WindowManager.LayoutParams()");
            }
            attributes.width = com.transsion.baseui.util.a.f51450a.b(contextRequireContext);
            attributes.height = B0();
            window2.setBackgroundDrawable(null);
            window2.setAttributes(attributes);
        }
        return bVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        E0(view);
        C0();
    }
}
