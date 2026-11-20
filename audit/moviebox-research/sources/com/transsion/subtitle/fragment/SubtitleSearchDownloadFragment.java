package com.transsion.subtitle.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.c0;
import androidx.lifecycle.d0;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.f0;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.SubtitleLanguageMapBean;
import com.transsion.baseui.widget.EditTextWithClear;
import com.transsion.subtitle.R$string;
import com.transsion.subtitle.view.SubtitleSearchTabTitleView;
import com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class SubtitleSearchDownloadFragment extends SubtitleBaseFragment<wx.f> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a f58180q = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CommonNavigator f58181h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FragmentStateAdapter f58182i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f58183j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f58184k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public DownloadBean f58185l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Function1<? super vx.a, Unit> f58187n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f58188o;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<Integer, SubtitleSearchResultListFragment> f58186m = new LinkedHashMap();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f58189p = "";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SubtitleSearchDownloadFragment a(String str, DownloadBean downloadBean, String str2) {
            SubtitleSearchDownloadFragment subtitleSearchDownloadFragment = new SubtitleSearchDownloadFragment();
            subtitleSearchDownloadFragment.E0(downloadBean);
            subtitleSearchDownloadFragment.setArguments(androidx.core.os.c.b(TuplesKt.a("EXTRA_NAME", str), TuplesKt.a("KEY_PAGE_NAME", str2)));
            return subtitleSearchDownloadFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends h20.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<SubtitleLanguageMapBean> f58190b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SubtitleSearchDownloadFragment f58191c;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a extends com.transsion.baseui.util.f {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ SubtitleSearchDownloadFragment f58192f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ int f58193g;

            public a(SubtitleSearchDownloadFragment subtitleSearchDownloadFragment, int i11) {
                this.f58192f = subtitleSearchDownloadFragment;
                this.f58193g = i11;
            }

            @Override // com.transsion.baseui.util.f
            public void c(View view) {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.transsion.baseui.util.f
            public void d(View view) {
                ViewPager2 viewPager2;
                wx.f fVar = (wx.f) this.f58192f.getMViewBinding();
                if (fVar == null || (viewPager2 = fVar.f79694j) == null) {
                    return;
                }
                viewPager2.setCurrentItem(this.f58193g, true);
            }
        }

        public b(List<SubtitleLanguageMapBean> list, SubtitleSearchDownloadFragment subtitleSearchDownloadFragment) {
            this.f58190b = list;
            this.f58191c = subtitleSearchDownloadFragment;
        }

        @Override // h20.a
        public int a() {
            return this.f58190b.size();
        }

        @Override // h20.a
        public h20.c b(Context context) {
            Intrinsics.g(context, "context");
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setColors(0);
            return linePagerIndicator;
        }

        @Override // h20.a
        public h20.d c(Context context, int i11) {
            Intrinsics.g(context, "context");
            SubtitleSearchTabTitleView subtitleSearchTabTitleView = new SubtitleSearchTabTitleView(context);
            List<SubtitleLanguageMapBean> list = this.f58190b;
            SubtitleSearchDownloadFragment subtitleSearchDownloadFragment = this.f58191c;
            subtitleSearchTabTitleView.setTextWithString(list.get(i11).getLanName());
            subtitleSearchTabTitleView.setOnClickListener(new a(subtitleSearchDownloadFragment, i11));
            return subtitleSearchTabTitleView;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends ViewPager2.OnPageChangeCallback {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i11) {
            MagicIndicator magicIndicator;
            super.onPageScrollStateChanged(i11);
            wx.f fVar = (wx.f) SubtitleSearchDownloadFragment.this.getMViewBinding();
            if (fVar == null || (magicIndicator = fVar.f79690f) == null) {
                return;
            }
            magicIndicator.onPageScrollStateChanged(i11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i11, float f11, int i12) {
            MagicIndicator magicIndicator;
            super.onPageScrolled(i11, f11, i12);
            wx.f fVar = (wx.f) SubtitleSearchDownloadFragment.this.getMViewBinding();
            if (fVar == null || (magicIndicator = fVar.f79690f) == null) {
                return;
            }
            magicIndicator.onPageScrolled(i11, f11, i12);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            MagicIndicator magicIndicator;
            super.onPageSelected(i11);
            wx.f fVar = (wx.f) SubtitleSearchDownloadFragment.this.getMViewBinding();
            if (fVar != null && (magicIndicator = fVar.f79690f) != null) {
                magicIndicator.onPageSelected(i11);
            }
            SubtitleSearchDownloadFragment.this.f58183j = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class d implements TextWatcher {
        public d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            SubtitleSearchDownloadFragment.this.f58184k = String.valueOf(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class e implements TextView.OnEditorActionListener {
        public e() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
            if (i11 != 0 && i11 != 3) {
                return false;
            }
            CharSequence text = textView != null ? textView.getText() : null;
            if (text == null || text.length() == 0) {
                zp.b.f82110a.e(Utils.a().getString(R$string.subtitle_search_empty_tips));
                return true;
            }
            SubtitleSearchResultListFragment subtitleSearchResultListFragment = (SubtitleSearchResultListFragment) SubtitleSearchDownloadFragment.this.f58186m.get(Integer.valueOf(SubtitleSearchDownloadFragment.this.f58183j));
            if (subtitleSearchResultListFragment != null) {
                subtitleSearchResultListFragment.I1(SubtitleSearchDownloadFragment.this.f58184k);
            }
            if (textView != null) {
                KeyboardUtils.e(textView);
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f58197a;

        public f(Function1 function) {
            Intrinsics.g(function, "function");
            this.f58197a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f58197a;
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
            this.f58197a.invoke(obj);
        }
    }

    public static final void B0(SubtitleSearchDownloadFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        SubtitleDownloadViewModel subtitleDownloadViewModelI0 = this$0.i0();
        c0<String> c0VarF = subtitleDownloadViewModelI0 != null ? subtitleDownloadViewModelI0.f() : null;
        if (c0VarF == null) {
            return;
        }
        c0VarF.q(this$0.f58189p);
    }

    public static final void C0(SubtitleSearchDownloadFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        String str = this$0.f58184k;
        if (str == null || str.length() == 0) {
            zp.b.f82110a.e(Utils.a().getString(R$string.subtitle_search_empty_tips));
            return;
        }
        SubtitleSearchResultListFragment subtitleSearchResultListFragment = this$0.f58186m.get(Integer.valueOf(this$0.f58183j));
        if (subtitleSearchResultListFragment != null) {
            subtitleSearchResultListFragment.I1(this$0.f58184k);
        }
        if (view != null) {
            KeyboardUtils.e(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E0(DownloadBean downloadBean) {
        this.f58185l = downloadBean;
    }

    private final void initViewModel() {
        c0<List<SubtitleLanguageMapBean>> c0VarH;
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            uo.b.a aVar = uo.b.f78622a;
            String TAG = h0();
            Intrinsics.f(TAG, "TAG");
            uo.b.a.f(aVar, TAG, "initViewModel ", false, 4, null);
            SubtitleDownloadViewModel subtitleDownloadViewModelI0 = i0();
            if (subtitleDownloadViewModelI0 != null && (c0VarH = subtitleDownloadViewModelI0.h()) != null) {
                c0VarH.j(parentFragment, new f(new Function1<List<SubtitleLanguageMapBean>, Unit>() { // from class: com.transsion.subtitle.fragment.SubtitleSearchDownloadFragment$initViewModel$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(List<SubtitleLanguageMapBean> list) {
                        invoke2(list);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(List<SubtitleLanguageMapBean> list) {
                        uo.b.a aVar2 = uo.b.f78622a;
                        String TAG2 = this.this$0.h0();
                        Intrinsics.f(TAG2, "TAG");
                        uo.b.a.f(aVar2, TAG2, "get languages list success, size = " + list.size() + " ", false, 4, null);
                        ArrayList arrayList = new ArrayList();
                        Intrinsics.f(list, "list");
                        arrayList.addAll(list);
                        com.transsion.subtitle.helper.c.d(arrayList);
                        this.this$0.D0(arrayList);
                    }
                }));
            }
            SubtitleDownloadViewModel subtitleDownloadViewModelI1 = i0();
            if (subtitleDownloadViewModelI1 != null) {
                subtitleDownloadViewModelI1.g();
            }
        }
    }

    public final void A0() {
        LinearLayout titleContainer;
        View childAt;
        LinearLayout titleContainer2;
        CommonNavigator commonNavigator = this.f58181h;
        int childCount = (commonNavigator == null || (titleContainer2 = commonNavigator.getTitleContainer()) == null) ? 0 : titleContainer2.getChildCount();
        if (childCount > 0) {
            for (int i11 = 0; i11 < childCount; i11++) {
                CommonNavigator commonNavigator2 = this.f58181h;
                if (commonNavigator2 != null && (titleContainer = commonNavigator2.getTitleContainer()) != null && (childAt = titleContainer.getChildAt(i11)) != null) {
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
                    if (layoutParams2 == null) {
                        layoutParams2 = new LinearLayout.LayoutParams(-2, f0.a(30.0f));
                    }
                    layoutParams2.height = f0.a(30.0f);
                    if (i11 == 0) {
                        layoutParams2.setMarginStart(f0.a(16.0f));
                    }
                    layoutParams2.setMarginEnd(f0.a(8.0f));
                    childAt.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D0(final List<SubtitleLanguageMapBean> list) {
        this.f58182i = new FragmentStateAdapter() { // from class: com.transsion.subtitle.fragment.SubtitleSearchDownloadFragment$initViewPager$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(this.f58198i);
            }

            @Override // androidx.viewpager2.adapter.FragmentStateAdapter
            public Fragment createFragment(int i11) {
                SubtitleSearchResultListFragment subtitleSearchResultListFragmentA = SubtitleSearchResultListFragment.F.a(this.f58198i.f58185l, list.get(i11), this.f58198i.f58184k, this.f58198i.getPageName());
                final SubtitleSearchDownloadFragment subtitleSearchDownloadFragment = this.f58198i;
                subtitleSearchDownloadFragment.f58186m.put(Integer.valueOf(i11), subtitleSearchResultListFragmentA);
                subtitleSearchResultListFragmentA.M1(subtitleSearchDownloadFragment.f58187n);
                subtitleSearchResultListFragmentA.L1(new Function0<Unit>() { // from class: com.transsion.subtitle.fragment.SubtitleSearchDownloadFragment$initViewPager$1$createFragment$1$1
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
                        boolean unused = subtitleSearchDownloadFragment.f58188o;
                    }
                });
                return subtitleSearchResultListFragmentA;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return list.size();
            }
        };
        wx.f fVar = (wx.f) getMViewBinding();
        ViewPager2 viewPager2 = fVar != null ? fVar.f79694j : null;
        if (viewPager2 != null) {
            viewPager2.setAdapter(this.f58182i);
        }
        y0(list);
    }

    public final void F0(Function1<? super vx.a, Unit> function1, String type) {
        Intrinsics.g(type, "type");
        this.f58187n = function1;
        this.f58189p = type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        EditTextWithClear editTextWithClear;
        TextView textView;
        EditTextWithClear editTextWithClear2;
        AppCompatImageView appCompatImageView;
        wx.f fVar;
        EditTextWithClear editTextWithClear3;
        EditTextWithClear editTextWithClear4;
        Intrinsics.g(view, "view");
        if (j0()) {
            int iA = f0.a(12.0f);
            int iA2 = f0.a(5.0f);
            wx.f fVar2 = (wx.f) getMViewBinding();
            if (fVar2 != null && (editTextWithClear4 = fVar2.f79687b) != null) {
                editTextWithClear4.setPadding(iA * 3, iA2, iA, iA2);
            }
        }
        initViewModel();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f58184k = arguments.getString("EXTRA_NAME", "");
        }
        String str = this.f58184k;
        if (str != null && str.length() != 0 && (fVar = (wx.f) getMViewBinding()) != null && (editTextWithClear3 = fVar.f79687b) != null) {
            editTextWithClear3.setText(this.f58184k);
        }
        wx.f fVar3 = (wx.f) getMViewBinding();
        if (fVar3 != null && (appCompatImageView = fVar3.f79688c) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.subtitle.fragment.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SubtitleSearchDownloadFragment.B0(this.f58231a, view2);
                }
            });
        }
        wx.f fVar4 = (wx.f) getMViewBinding();
        if (fVar4 != null && (editTextWithClear2 = fVar4.f79687b) != null) {
            editTextWithClear2.addTextChangedListener(new d());
        }
        wx.f fVar5 = (wx.f) getMViewBinding();
        if (fVar5 != null && (textView = fVar5.f79692h) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.subtitle.fragment.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SubtitleSearchDownloadFragment.C0(this.f58232a, view2);
                }
            });
        }
        wx.f fVar6 = (wx.f) getMViewBinding();
        if (fVar6 == null || (editTextWithClear = fVar6.f79687b) == null) {
            return;
        }
        editTextWithClear.setOnEditorActionListener(new e());
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.subtitle.fragment.SubtitleBaseFragment, com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        l0("dialog_subtitle_search");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y0(List<SubtitleLanguageMapBean> list) {
        ViewPager2 viewPager2;
        ViewPager2 viewPager3;
        Context context = getContext();
        if (context == null) {
            return;
        }
        CommonNavigator commonNavigator = new CommonNavigator(context);
        commonNavigator.setFollowTouch(true);
        commonNavigator.setAdapter(new b(list, this));
        this.f58181h = commonNavigator;
        wx.f fVar = (wx.f) getMViewBinding();
        MagicIndicator magicIndicator = fVar != null ? fVar.f79690f : null;
        if (magicIndicator != null) {
            magicIndicator.setNavigator(this.f58181h);
        }
        A0();
        wx.f fVar2 = (wx.f) getMViewBinding();
        if (fVar2 != null && (viewPager3 = fVar2.f79694j) != null) {
            viewPager3.registerOnPageChangeCallback(new c());
        }
        wx.f fVar3 = (wx.f) getMViewBinding();
        if (fVar3 == null || (viewPager2 = fVar3.f79694j) == null) {
            return;
        }
        viewPager2.setCurrentItem(this.f58183j, false);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
    public wx.f getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        wx.f fVarC = wx.f.c(inflater);
        Intrinsics.f(fVarC, "inflate(inflater)");
        return fVarC;
    }
}
