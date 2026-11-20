package com.transsion.videodetail;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetail.dialog.SubjectInfoMoreDetailDialog;
import com.transsion.moviedetail.view.CustomTextViewGroup;
import com.transsion.moviedetail.view.HeaderExtensionFragment;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.ResourcesSeason;
import com.transsion.moviedetailapi.bean.ResourcesSeasonList;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.ninegridview.ImageInfo;
import com.transsion.ninegridview.preview.ImagePreviewActivity;
import com.transsion.web.api.WebConstants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;

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
public final class SubjectDetailHeaderFragment extends BaseFragment<rz.h> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Subject f59820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f59821d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f59822f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f59825i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f59826j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f59827k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f59828l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public HeaderExtensionFragment f59829m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f59818a = FragmentViewModelLazyKt.a(this, Reflection.b(MovieDetailViewModel.class), new Function0<x0>() { // from class: com.transsion.videodetail.SubjectDetailHeaderFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final x0 invoke() {
            x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.f(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.videodetail.SubjectDetailHeaderFragment$special$$inlined$activityViewModels$default$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final v0.c invoke() {
            v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.f(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f59819b = FragmentViewModelLazyKt.a(this, Reflection.b(VideoDetailViewModel.class), new Function0<x0>() { // from class: com.transsion.videodetail.SubjectDetailHeaderFragment$special$$inlined$activityViewModels$default$3
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final x0 invoke() {
            x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.f(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.videodetail.SubjectDetailHeaderFragment$special$$inlined$activityViewModels$default$4
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final v0.c invoke() {
            v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.f(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f59823g = "stream_detail";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f59824h = 1;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f59830a;

        public a(Function1 function) {
            Intrinsics.g(function, "function");
            this.f59830a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f59830a;
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
            this.f59830a.invoke(obj);
        }
    }

    private final String l0(String str) {
        if (str.length() < 4) {
            return str;
        }
        String strSubstring = str.substring(0, 4);
        Intrinsics.f(strSubstring, "substring(...)");
        return strSubstring;
    }

    private final MovieDetailViewModel m0() {
        return (MovieDetailViewModel) this.f59818a.getValue();
    }

    private final VideoDetailViewModel n0() {
        return (VideoDetailViewModel) this.f59819b.getValue();
    }

    public static final void r0(SubjectDetailHeaderFragment this$0, ShapeableImageView this_apply, View view) {
        Cover cover;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        Subject subject = this$0.f59820c;
        if (subject == null || (cover = subject.getCover()) == null) {
            return;
        }
        com.transsion.baselib.helper.a.f51183a.g("movie_poster", "preview", (28 & 4) != 0 ? "" : null, (28 & 8) != 0 ? "" : null, (28 & 16) != 0 ? "" : null);
        ImageInfo imageInfo = new ImageInfo();
        imageInfo.bigImageUrl = cover.getUrl();
        imageInfo.thumbnailUrl = cover.getThumbnail();
        Integer height = cover.getHeight();
        imageInfo.imageViewHeight = height != null ? height.intValue() : 0.0f;
        Integer width = cover.getWidth();
        imageInfo.imageViewWidth = width != null ? width.intValue() : 0.0f;
        List<? extends ImageInfo> listQ = kotlin.collections.g.q(imageInfo);
        ImagePreviewActivity.a aVar = ImagePreviewActivity.Companion;
        Context context = this_apply.getContext();
        Intrinsics.f(context, "this.context");
        aVar.a(context, 0, listQ);
    }

    public static final void s0(SubjectDetailHeaderFragment this$0, View it) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.f(it, "it");
        this$0.t0(it);
    }

    private final void t0(View view) {
        if (this.f59826j || com.transsion.baseui.util.c.f51452a.a(view.getId(), 1000L)) {
            return;
        }
        uo.b.a.g(uo.b.f78622a, "Open the right to view more detail", false, 2, null);
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            SubjectInfoMoreDetailDialog subjectInfoMoreDetailDialog = new SubjectInfoMoreDetailDialog();
            subjectInfoMoreDetailDialog.setArguments(androidx.core.os.c.b(TuplesKt.a("data_key_resource_detectors", this.f59820c)));
            subjectInfoMoreDetailDialog.T0(parentFragment, R$id.fl_bottom_dialog_container);
        }
    }

    private final void u0(Integer num) {
    }

    private final void v0(Integer num) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0(Subject subject) {
        Subject subject2;
        CustomTextViewGroup customTextViewGroup;
        CustomTextViewGroup customTextViewGroup2;
        rz.h mViewBinding;
        CustomTextViewGroup customTextViewGroup3;
        rz.h mViewBinding2;
        CustomTextViewGroup customTextViewGroup4;
        rz.h mViewBinding3;
        CustomTextViewGroup customTextViewGroup5;
        FrameLayout frameLayout;
        rz.h mViewBinding4;
        CustomTextViewGroup customTextViewGroup6;
        CustomTextViewGroup customTextViewGroup7;
        rz.h mViewBinding5;
        CustomTextViewGroup customTextViewGroup8;
        AppCompatTextView appCompatTextView;
        AppCompatImageView appCompatImageView;
        View vSeasonsLine2;
        AppCompatTextView tvSeasons2;
        CustomTextViewGroup tvSeasons;
        CustomTextViewGroup customTextViewGroup9;
        View vSeasonsLine3;
        AppCompatTextView tvSeasons3;
        CustomTextViewGroup tvSeasons4;
        CustomTextViewGroup customTextViewGroup10;
        rz.h mViewBinding6;
        LinearLayout linearLayout;
        AppCompatImageView appCompatImageView2;
        HashMap<String, String> mapG;
        HashMap<String, String> mapG2;
        this.f59820c = subject;
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.j(true);
        }
        com.transsion.baselib.report.h logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null && (mapG2 = logViewConfig2.g()) != null) {
            String subjectId = subject.getSubjectId();
            if (subjectId == null) {
                subjectId = "";
            }
            mapG2.put("subject_id", subjectId);
        }
        com.transsion.baselib.report.h logViewConfig3 = getLogViewConfig();
        if (logViewConfig3 != null && (mapG = logViewConfig3.g()) != null) {
            mapG.put("has_resource", String.valueOf(subject.getHasResource()));
        }
        Subject subject3 = this.f59820c;
        String ops = subject3 != null ? subject3.getOps() : null;
        if ((ops == null || ops.length() == 0) && (subject2 = this.f59820c) != null) {
            subject2.setOps(this.f59821d);
        }
        int iA = com.transsion.moviedetailapi.a.a(subject.getSubjectType());
        rz.h mViewBinding7 = getMViewBinding();
        if (mViewBinding7 != null && (appCompatImageView2 = mViewBinding7.f75845c) != null) {
            appCompatImageView2.setImageResource(iA);
        }
        rz.h mViewBinding8 = getMViewBinding();
        AppCompatTextView appCompatTextView2 = mViewBinding8 != null ? mViewBinding8.f75852k : null;
        if (appCompatTextView2 != null) {
            appCompatTextView2.setText(subject.getTitle());
        }
        if (this.f59827k && (mViewBinding6 = getMViewBinding()) != null && (linearLayout = mViewBinding6.f75849h) != null) {
            so.c.g(linearLayout);
        }
        if (subject.isTvType()) {
            Integer seNum = subject.getSeNum();
            if (seNum != null) {
                int iIntValue = seNum.intValue();
                if (iIntValue <= 0) {
                    rz.h mViewBinding9 = getMViewBinding();
                    if (mViewBinding9 != null && (customTextViewGroup10 = mViewBinding9.f75855n) != null) {
                        customTextViewGroup10.setText("");
                    }
                } else {
                    if (this.f59828l) {
                        rz.h mViewBinding10 = getMViewBinding();
                        if (mViewBinding10 != null && (tvSeasons4 = mViewBinding10.f75855n) != null) {
                            Intrinsics.f(tvSeasons4, "tvSeasons");
                            so.c.k(tvSeasons4);
                        }
                        rz.h mViewBinding11 = getMViewBinding();
                        if (mViewBinding11 != null && (tvSeasons3 = mViewBinding11.f75856o) != null) {
                            Intrinsics.f(tvSeasons3, "tvSeasons2");
                            so.c.g(tvSeasons3);
                        }
                        rz.h mViewBinding12 = getMViewBinding();
                        if (mViewBinding12 != null && (vSeasonsLine3 = mViewBinding12.f75860s) != null) {
                            Intrinsics.f(vSeasonsLine3, "vSeasonsLine2");
                            so.c.g(vSeasonsLine3);
                        }
                    } else {
                        rz.h mViewBinding13 = getMViewBinding();
                        if (mViewBinding13 != null && (tvSeasons = mViewBinding13.f75855n) != null) {
                            Intrinsics.f(tvSeasons, "tvSeasons");
                            so.c.g(tvSeasons);
                        }
                        rz.h mViewBinding14 = getMViewBinding();
                        if (mViewBinding14 != null && (tvSeasons2 = mViewBinding14.f75856o) != null) {
                            Intrinsics.f(tvSeasons2, "tvSeasons2");
                            so.c.k(tvSeasons2);
                        }
                        rz.h mViewBinding15 = getMViewBinding();
                        if (mViewBinding15 != null && (vSeasonsLine2 = mViewBinding15.f75860s) != null) {
                            Intrinsics.f(vSeasonsLine2, "vSeasonsLine2");
                            so.c.k(vSeasonsLine2);
                        }
                    }
                    Context context = getContext();
                    String string = context != null ? context.getString(com.transsion.moviedetail.R$string.movie_detail_seasons, Integer.valueOf(iIntValue)) : null;
                    rz.h mViewBinding16 = getMViewBinding();
                    if (mViewBinding16 != null && (customTextViewGroup9 = mViewBinding16.f75855n) != null) {
                        customTextViewGroup9.setText(string == null ? "" : string);
                    }
                    rz.h mViewBinding17 = getMViewBinding();
                    AppCompatTextView appCompatTextView3 = mViewBinding17 != null ? mViewBinding17.f75856o : null;
                    if (appCompatTextView3 != null) {
                        appCompatTextView3.setText(string != null ? string : "");
                    }
                }
            }
        } else {
            rz.h mViewBinding18 = getMViewBinding();
            if (mViewBinding18 != null && (customTextViewGroup = mViewBinding18.f75855n) != null) {
                so.c.g(customTextViewGroup);
            }
        }
        if (subject.isMusicType()) {
            rz.h mViewBinding19 = getMViewBinding();
            if (mViewBinding19 != null && (appCompatImageView = mViewBinding19.f75848g) != null) {
                so.c.g(appCompatImageView);
            }
            rz.h mViewBinding20 = getMViewBinding();
            if (mViewBinding20 != null && (appCompatTextView = mViewBinding20.f75854m) != null) {
                so.c.g(appCompatTextView);
            }
            String countryName = subject.getCountryName();
            if (countryName != null && (mViewBinding5 = getMViewBinding()) != null && (customTextViewGroup8 = mViewBinding5.f75850i) != null) {
                customTextViewGroup8.setText(countryName);
            }
            String genre = subject.getGenre();
            if (genre != null) {
                String string2 = StringsKt__StringsKt.Z0((String) StringsKt__StringsKt.E0(genre, new String[]{","}, false, 0, 6, null).get(0)).toString();
                rz.h mViewBinding21 = getMViewBinding();
                if (mViewBinding21 != null && (customTextViewGroup7 = mViewBinding21.f75858q) != null) {
                    customTextViewGroup7.setText(string2);
                }
            }
            String releaseDate = subject.getReleaseDate();
            if (releaseDate != null && (mViewBinding4 = getMViewBinding()) != null && (customTextViewGroup6 = mViewBinding4.f75857p) != null) {
                customTextViewGroup6.setText(l0(releaseDate));
            }
        } else {
            String restrictLevel = subject.getRestrictLevel();
            if (restrictLevel != null && (mViewBinding3 = getMViewBinding()) != null && (customTextViewGroup5 = mViewBinding3.f75853l) != null) {
                customTextViewGroup5.setText(restrictLevel);
            }
            String releaseDate2 = subject.getReleaseDate();
            if (releaseDate2 != null && (mViewBinding2 = getMViewBinding()) != null && (customTextViewGroup4 = mViewBinding2.f75857p) != null) {
                customTextViewGroup4.setText(l0(releaseDate2));
            }
            String countryName2 = subject.getCountryName();
            if (countryName2 != null && (mViewBinding = getMViewBinding()) != null && (customTextViewGroup3 = mViewBinding.f75850i) != null) {
                customTextViewGroup3.setText(countryName2);
            }
            String genre2 = subject.getGenre();
            if (genre2 != null) {
                String string3 = StringsKt__StringsKt.Z0((String) StringsKt__StringsKt.E0(genre2, new String[]{","}, false, 0, 6, null).get(0)).toString();
                rz.h mViewBinding22 = getMViewBinding();
                if (mViewBinding22 != null && (customTextViewGroup2 = mViewBinding22.f75858q) != null) {
                    customTextViewGroup2.setText(string3);
                }
            }
            rz.h mViewBinding23 = getMViewBinding();
            AppCompatTextView appCompatTextView4 = mViewBinding23 != null ? mViewBinding23.f75854m : null;
            if (appCompatTextView4 != null) {
                appCompatTextView4.setText(subject.getImdbRate());
            }
        }
        Subject subject4 = this.f59820c;
        v0(subject4 != null ? subject4.getSeenStatus() : null);
        Subject subject5 = this.f59820c;
        u0(subject5 != null ? subject5.getSeenStatus() : null);
        if (this.f59826j) {
            rz.h mViewBinding24 = getMViewBinding();
            if (mViewBinding24 == null || (frameLayout = mViewBinding24.f75844b) == null) {
                return;
            }
            so.c.g(frameLayout);
            return;
        }
        if (this.f59829m == null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.f(childFragmentManager, "childFragmentManager");
            FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
            Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
            HeaderExtensionFragment headerExtensionFragment = new HeaderExtensionFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("data_key_resource_detectors", this.f59820c);
            bundle.putString("module_name", this.f59825i);
            bundle.putInt("season", this.f59824h);
            bundle.putString("ops", this.f59821d);
            bundle.putString(WebConstants.PAGE_FROM, this.f59823g);
            headerExtensionFragment.setArguments(bundle);
            fragmentTransactionBeginTransaction.replace(R$id.extension_container, headerExtensionFragment);
            this.f59829m = headerExtensionFragment;
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle bundle) {
        AppCompatImageView appCompatImageView;
        ShapeableImageView shapeableImageView;
        rz.h mViewBinding;
        AppCompatTextView appCompatTextView;
        Intrinsics.g(view, "view");
        super.initData(view, bundle);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("data_key_resource_detectors") : null;
        this.f59820c = serializable instanceof Subject ? (Subject) serializable : null;
        Bundle arguments2 = getArguments();
        this.f59825i = arguments2 != null ? arguments2.getString("module_name") : null;
        Bundle arguments3 = getArguments();
        this.f59824h = arguments3 != null ? arguments3.getInt("season") : 1;
        Bundle arguments4 = getArguments();
        this.f59821d = arguments4 != null ? arguments4.getString("ops") : null;
        Bundle arguments5 = getArguments();
        String string = arguments5 != null ? arguments5.getString(WebConstants.PAGE_FROM) : null;
        if (string == null) {
            string = "stream_detail";
        }
        this.f59823g = string;
        Bundle arguments6 = getArguments();
        this.f59822f = arguments6 != null ? arguments6.getString("id") : null;
        Bundle arguments7 = getArguments();
        this.f59826j = arguments7 != null ? arguments7.getBoolean("is_Intercept_detail") : false;
        Bundle arguments8 = getArguments();
        this.f59827k = arguments8 != null ? arguments8.getBoolean("isOutsideVideo") : false;
        Subject subject = this.f59820c;
        this.f59828l = subject != null ? Intrinsics.b(subject.getHasResource(), Boolean.TRUE) : false;
        Subject subject2 = this.f59820c;
        if (subject2 != null) {
            Intrinsics.d(subject2);
            w0(subject2);
        }
        if (this.f59826j && (mViewBinding = getMViewBinding()) != null && (appCompatTextView = mViewBinding.f75851j) != null) {
            so.c.g(appCompatTextView);
        }
        if (!this.f59828l) {
            rz.h mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (shapeableImageView = mViewBinding2.f75846d) != null) {
                so.c.k(shapeableImageView);
            }
            rz.h mViewBinding3 = getMViewBinding();
            if (mViewBinding3 != null && (appCompatImageView = mViewBinding3.f75847f) != null) {
                so.c.k(appCompatImageView);
            }
        }
        MovieDetailViewModel movieDetailViewModelM0 = m0();
        movieDetailViewModelM0.r().j(this, new a(new Function1<Pair<? extends String, ? extends Subject>, Unit>() { // from class: com.transsion.videodetail.SubjectDetailHeaderFragment$initData$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends String, ? extends Subject> pair) {
                invoke2((Pair<String, ? extends Subject>) pair);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<String, ? extends Subject> pair) {
                Subject second = pair.getSecond();
                uo.b.f78622a.c("videoDetail", "get movie detail data==" + pair, true);
                if (second != null) {
                    this.this$0.w0(second);
                }
            }
        }));
        movieDetailViewModelM0.u().j(this, new a(new Function1<Integer, Unit>() { // from class: com.transsion.videodetail.SubjectDetailHeaderFragment$initData$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer season) {
                SubjectDetailHeaderFragment subjectDetailHeaderFragment = this.this$0;
                Intrinsics.f(season, "season");
                subjectDetailHeaderFragment.f59824h = season.intValue();
            }
        }));
        n0().w().j(this, new a(new Function1<ResourcesSeasonList, Unit>() { // from class: com.transsion.videodetail.SubjectDetailHeaderFragment.initData.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ResourcesSeasonList resourcesSeasonList) {
                invoke2(resourcesSeasonList);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ResourcesSeasonList resourcesSeasonList) {
                SubjectDetailHeaderFragment.this.p0(resourcesSeasonList);
                SubjectDetailHeaderFragment.this.hideLoading();
            }
        }));
        m0().u().j(this, new a(new Function1<Integer, Unit>() { // from class: com.transsion.videodetail.SubjectDetailHeaderFragment.initData.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer it) {
                SubjectDetailHeaderFragment subjectDetailHeaderFragment = SubjectDetailHeaderFragment.this;
                Intrinsics.f(it, "it");
                subjectDetailHeaderFragment.f59824h = it.intValue();
            }
        }));
        q0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        rz.h mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            mViewBinding.f75859r.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SubjectDetailHeaderFragment.s0(this.f59915a, view2);
                }
            });
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public rz.h getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        rz.h hVarC = rz.h.c(inflater);
        Intrinsics.f(hVarC, "inflate(inflater)");
        return hVarC;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x005a  */
    public final void p0(ResourcesSeasonList resourcesSeasonList) {
        int se2;
        List<ResourcesSeason> seasons;
        List<ResourcesSeason> seasons2;
        if (resourcesSeasonList == null || (seasons2 = resourcesSeasonList.getSeasons()) == null || !seasons2.isEmpty()) {
            if (resourcesSeasonList == null || (seasons = resourcesSeasonList.getSeasons()) == null) {
                se2 = this.f59824h;
            } else {
                Iterator<T> it = seasons.iterator();
                if (!it.hasNext()) {
                    throw new NoSuchElementException();
                }
                Object next = it.next();
                if (it.hasNext()) {
                    int se3 = ((ResourcesSeason) next).getSe();
                    do {
                        Object next2 = it.next();
                        int se4 = ((ResourcesSeason) next2).getSe();
                        if (se3 > se4) {
                            next = next2;
                            se3 = se4;
                        }
                    } while (it.hasNext());
                }
                ResourcesSeason resourcesSeason = (ResourcesSeason) next;
                if (resourcesSeason != null) {
                    se2 = resourcesSeason.getSe();
                } else {
                    se2 = this.f59824h;
                }
            }
            if (this.f59824h < se2) {
                this.f59824h = se2;
            }
        }
    }

    public final void q0() {
        final ShapeableImageView shapeableImageView;
        Cover cover;
        String thumbnail;
        Cover cover2;
        String url;
        FrameLayout frameLayout;
        if (this.f59828l) {
            return;
        }
        rz.h mViewBinding = getMViewBinding();
        if (mViewBinding != null && (frameLayout = mViewBinding.f75844b) != null) {
            so.c.g(frameLayout);
        }
        rz.h mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (shapeableImageView = mViewBinding2.f75846d) == null) {
            return;
        }
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        Subject subject = this.f59820c;
        String str = (subject == null || (cover2 = subject.getCover()) == null || (url = cover2.getUrl()) == null) ? "" : url;
        Subject subject2 = this.f59820c;
        companion.q(contextRequireContext, shapeableImageView, str, (8120 & 8) != 0 ? companion.d() : 0, (8120 & 16) != 0 ? companion.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : (subject2 == null || (cover = subject2.getCover()) == null || (thumbnail = cover.getThumbnail()) == null) ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
        shapeableImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubjectDetailHeaderFragment.r0(this.f59916a, shapeableImageView, view);
            }
        });
    }
}
