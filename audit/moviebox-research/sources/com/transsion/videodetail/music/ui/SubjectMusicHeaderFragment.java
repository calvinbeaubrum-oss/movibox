package com.transsion.videodetail.music.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.music.MusicLikedDbBean;
import com.transsion.baseui.R$drawable;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.dialog.SubjectMusicInfoMoreDetailDialog;
import com.transsion.moviedetail.view.HeaderExtensionFragment;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.videodetail.R$string;
import com.transsion.videodetail.music.bean.LikeListActionEnum;
import com.transsion.videodetail.music.bean.MusicLikedRemoteItemBean;
import com.transsion.videodetail.music.data.MusicLikedFragmentViewModel;
import com.transsion.web.api.WebConstants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import tu.q;

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
public final class SubjectMusicHeaderFragment extends BaseFragment<q> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Subject f59964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f59965d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f59966f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f59969i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f59971k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public HeaderExtensionFragment f59972l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f59962a = FragmentViewModelLazyKt.a(this, Reflection.b(MovieDetailViewModel.class), new Function0<x0>() { // from class: com.transsion.videodetail.music.ui.SubjectMusicHeaderFragment$special$$inlined$activityViewModels$default$1
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
    }, new Function0<v0.c>() { // from class: com.transsion.videodetail.music.ui.SubjectMusicHeaderFragment$special$$inlined$activityViewModels$default$2
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
    public final String f59963b = "SubjectMusicHeaderFragment";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f59967g = "stream_detail";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f59968h = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f59970j = FragmentViewModelLazyKt.a(this, Reflection.b(MusicLikedFragmentViewModel.class), new Function0<x0>() { // from class: com.transsion.videodetail.music.ui.SubjectMusicHeaderFragment$special$$inlined$activityViewModels$default$3
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
    }, new Function0<v0.c>() { // from class: com.transsion.videodetail.music.ui.SubjectMusicHeaderFragment$special$$inlined$activityViewModels$default$4
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

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f59973a;

        public a(Function1 function) {
            Intrinsics.g(function, "function");
            this.f59973a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f59973a;
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
            this.f59973a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MusicLikedFragmentViewModel q0() {
        return (MusicLikedFragmentViewModel) this.f59970j.getValue();
    }

    private final MovieDetailViewModel r0() {
        return (MovieDetailViewModel) this.f59962a.getValue();
    }

    public static final void t0(final SubjectMusicHeaderFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        com.transsion.baseui.util.d.a(1000L, new Function0<Unit>() { // from class: com.transsion.videodetail.music.ui.SubjectMusicHeaderFragment$initView$1$1$1
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
                Subject subject = this.this$0.f59964c;
                if (subject != null) {
                    this.this$0.q0().m(subject);
                }
            }
        });
    }

    public static final void u0(SubjectMusicHeaderFragment this$0, View it) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.f(it, "it");
        this$0.v0(it);
    }

    private final void v0(View view) {
        Fragment parentFragment;
        if (this.f59971k || com.transsion.baseui.util.c.f51452a.a(view.getId(), 1000L) || (parentFragment = getParentFragment()) == null) {
            return;
        }
        SubjectMusicInfoMoreDetailDialog subjectMusicInfoMoreDetailDialog = new SubjectMusicInfoMoreDetailDialog();
        subjectMusicInfoMoreDetailDialog.setArguments(androidx.core.os.c.b(TuplesKt.a("data_key_resource_detectors", this.f59964c)));
        subjectMusicInfoMoreDetailDialog.T0(parentFragment, R$id.fl_bottom_dialog_container);
    }

    private final void x0() {
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            return;
        }
        q0().x(this.f59966f, new Function1<MusicLikedDbBean, Unit>() { // from class: com.transsion.videodetail.music.ui.SubjectMusicHeaderFragment$showNoNetworkLayout$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MusicLikedDbBean musicLikedDbBean) {
                invoke2(musicLikedDbBean);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MusicLikedDbBean musicLikedDbBean) {
                if (musicLikedDbBean == null) {
                    MusicLikedFragmentViewModel musicLikedFragmentViewModelQ0 = this.this$0.q0();
                    String str = this.this$0.f59966f;
                    final SubjectMusicHeaderFragment subjectMusicHeaderFragment = this.this$0;
                    musicLikedFragmentViewModelQ0.r(str, new Function1<DownloadBean, Unit>() { // from class: com.transsion.videodetail.music.ui.SubjectMusicHeaderFragment$showNoNetworkLayout$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DownloadBean downloadBean) {
                            invoke2(downloadBean);
                            return Unit.f68710a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DownloadBean downloadBean) {
                            Long duration;
                            subjectMusicHeaderFragment.f59964c = new Subject(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, null, null, -1, 4194303, null);
                            Subject subject = subjectMusicHeaderFragment.f59964c;
                            if (subject != null) {
                                subject.setSubjectId(subjectMusicHeaderFragment.f59966f);
                            }
                            Subject subject2 = subjectMusicHeaderFragment.f59964c;
                            if (subject2 != null) {
                                subject2.setCover(new Cover(null, null, null, null, null, null, null, null, null, 511, null));
                            }
                            Subject subject3 = subjectMusicHeaderFragment.f59964c;
                            Cover cover = subject3 != null ? subject3.getCover() : null;
                            if (cover != null) {
                                cover.setUrl(downloadBean != null ? downloadBean.getCover() : null);
                            }
                            Subject subject4 = subjectMusicHeaderFragment.f59964c;
                            if (subject4 != null) {
                                subject4.setSubjectType(6);
                            }
                            Subject subject5 = subjectMusicHeaderFragment.f59964c;
                            if (subject5 != null) {
                                subject5.setLikeStatus(0);
                            }
                            Subject subject6 = subjectMusicHeaderFragment.f59964c;
                            if (subject6 != null) {
                                subject6.setTitle(downloadBean != null ? downloadBean.getSubjectName() : null);
                            }
                            Subject subject7 = subjectMusicHeaderFragment.f59964c;
                            if (subject7 != null) {
                                subject7.setCountryName(downloadBean != null ? downloadBean.getUploadBy() : null);
                            }
                            Subject subject8 = subjectMusicHeaderFragment.f59964c;
                            if (subject8 != null) {
                                subject8.setGenre(downloadBean != null ? downloadBean.getGenre() : null);
                            }
                            Subject subject9 = subjectMusicHeaderFragment.f59964c;
                            if (subject9 != null) {
                                subject9.setReleaseDate("");
                            }
                            Subject subject10 = subjectMusicHeaderFragment.f59964c;
                            if (subject10 != null) {
                                subject10.setDurationSeconds(Integer.valueOf((int) (((downloadBean == null || (duration = downloadBean.getDuration()) == null) ? 0L : duration.longValue()) / ((long) 1000))));
                            }
                            Staff staff = new Staff();
                            staff.setAvatarUrl("");
                            staff.setName("");
                            Subject subject11 = subjectMusicHeaderFragment.f59964c;
                            if (subject11 != null) {
                                subject11.setStaffList(kotlin.collections.g.q(staff));
                            }
                            subjectMusicHeaderFragment.y0();
                        }
                    });
                } else {
                    sz.a.f76638a.b(this.this$0.f59963b + " --> showNoNetworkLayout() --> liked = " + musicLikedDbBean);
                    this.this$0.f59964c = new Subject(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, null, null, -1, 4194303, null);
                    Subject subject = this.this$0.f59964c;
                    if (subject != null) {
                        subject.setSubjectId(this.this$0.f59966f);
                    }
                    Subject subject2 = this.this$0.f59964c;
                    if (subject2 != null) {
                        subject2.setCover(new Cover(null, null, null, null, null, null, null, null, null, 511, null));
                    }
                    Subject subject3 = this.this$0.f59964c;
                    Cover cover = subject3 != null ? subject3.getCover() : null;
                    if (cover != null) {
                        cover.setUrl(musicLikedDbBean.getCoverUrl());
                    }
                    Subject subject4 = this.this$0.f59964c;
                    if (subject4 != null) {
                        subject4.setSubjectType(6);
                    }
                    Subject subject5 = this.this$0.f59964c;
                    if (subject5 != null) {
                        subject5.setLikeStatus(1);
                    }
                    Subject subject6 = this.this$0.f59964c;
                    if (subject6 != null) {
                        subject6.setTitle(musicLikedDbBean.getTitle());
                    }
                    Subject subject7 = this.this$0.f59964c;
                    if (subject7 != null) {
                        subject7.setCountryName(musicLikedDbBean.getCountryName());
                    }
                    Subject subject8 = this.this$0.f59964c;
                    if (subject8 != null) {
                        subject8.setGenre(musicLikedDbBean.getGenre());
                    }
                    Subject subject9 = this.this$0.f59964c;
                    if (subject9 != null) {
                        subject9.setReleaseDate(musicLikedDbBean.getReleaseDate());
                    }
                    Subject subject10 = this.this$0.f59964c;
                    if (subject10 != null) {
                        subject10.setDurationSeconds(Integer.valueOf(musicLikedDbBean.getDurationSeconds()));
                    }
                    Staff staff = new Staff();
                    staff.setAvatarUrl(musicLikedDbBean.getSingerAvatar());
                    staff.setName(musicLikedDbBean.getSingerName());
                    Subject subject11 = this.this$0.f59964c;
                    if (subject11 != null) {
                        subject11.setStaffList(kotlin.collections.g.q(staff));
                    }
                }
                this.this$0.y0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0(Subject subject) {
        FrameLayout frameLayout;
        Subject subject2;
        HashMap<String, String> mapG;
        HashMap<String, String> mapG2;
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.j(true);
        }
        com.transsion.baselib.report.h logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null) {
            logViewConfig2.m(this.f59965d);
        }
        com.transsion.baselib.report.h logViewConfig3 = getLogViewConfig();
        if (logViewConfig3 != null && (mapG2 = logViewConfig3.g()) != null) {
            String subjectId = subject.getSubjectId();
            if (subjectId == null) {
                subjectId = "";
            }
            mapG2.put("subject_id", subjectId);
        }
        com.transsion.baselib.report.h logViewConfig4 = getLogViewConfig();
        if (logViewConfig4 != null && (mapG = logViewConfig4.g()) != null) {
            mapG.put("has_resource", String.valueOf(subject.getHasResource()));
        }
        q mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            Subject subject3 = this.f59964c;
            String ops = subject3 != null ? subject3.getOps() : null;
            if ((ops == null || ops.length() == 0) && (subject2 = this.f59964c) != null) {
                subject2.setOps(this.f59965d);
            }
            mViewBinding.f77583f.setText(subject.getTitle());
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) " | ");
            if (!TextUtils.isEmpty(subject.getCountryName())) {
                spannableStringBuilder.append((CharSequence) subject.getCountryName());
            }
            if (!TextUtils.isEmpty(subject.getGenre())) {
                if (spannableStringBuilder.length() > 2) {
                    spannableStringBuilder.append((CharSequence) " | ");
                }
                spannableStringBuilder.append((CharSequence) subject.getGenre());
            }
            if (!TextUtils.isEmpty(subject.getReleaseDate())) {
                if (spannableStringBuilder.length() > 2) {
                    spannableStringBuilder.append((CharSequence) " | ");
                }
                String releaseDate = subject.getReleaseDate();
                spannableStringBuilder.append((CharSequence) (releaseDate != null ? kotlin.text.n.g1(releaseDate, 4) : null));
            }
            Integer durationSeconds = subject.getDurationSeconds();
            if (durationSeconds != null && durationSeconds.intValue() > 0) {
                spannableStringBuilder.append((CharSequence) " | ");
                uz.b bVar = uz.b.f78666a;
                Integer durationSeconds2 = subject.getDurationSeconds();
                spannableStringBuilder.append((CharSequence) bVar.a(((long) (durationSeconds2 != null ? durationSeconds2.intValue() : 0)) * 1000));
            }
            mViewBinding.f77584g.setText(spannableStringBuilder);
        }
        if (this.f59971k) {
            q mViewBinding2 = getMViewBinding();
            if (mViewBinding2 == null || (frameLayout = mViewBinding2.f77580b) == null) {
                return;
            }
            so.c.g(frameLayout);
            return;
        }
        if (this.f59972l == null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.f(childFragmentManager, "childFragmentManager");
            FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
            Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
            HeaderExtensionFragment headerExtensionFragment = new HeaderExtensionFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("data_key_resource_detectors", this.f59964c);
            bundle.putString("module_name", this.f59969i);
            bundle.putInt("season", this.f59968h);
            bundle.putString("ops", this.f59965d);
            bundle.putString(WebConstants.PAGE_FROM, this.f59967g);
            headerExtensionFragment.setArguments(bundle);
            fragmentTransactionBeginTransaction.replace(R$id.extension_container, headerExtensionFragment);
            this.f59972l = headerExtensionFragment;
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle bundle) {
        q mViewBinding;
        AppCompatTextView appCompatTextView;
        Intrinsics.g(view, "view");
        super.initData(view, bundle);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("data_key_resource_detectors") : null;
        this.f59964c = serializable instanceof Subject ? (Subject) serializable : null;
        Bundle arguments2 = getArguments();
        this.f59965d = arguments2 != null ? arguments2.getString("ops") : null;
        Bundle arguments3 = getArguments();
        this.f59966f = arguments3 != null ? arguments3.getString("id") : null;
        Bundle arguments4 = getArguments();
        this.f59969i = arguments4 != null ? arguments4.getString("module_name") : null;
        Bundle arguments5 = getArguments();
        this.f59968h = arguments5 != null ? arguments5.getInt("season") : 1;
        Bundle arguments6 = getArguments();
        this.f59965d = arguments6 != null ? arguments6.getString("ops") : null;
        Bundle arguments7 = getArguments();
        String string = arguments7 != null ? arguments7.getString(WebConstants.PAGE_FROM) : null;
        if (string == null) {
            string = "stream_detail";
        }
        this.f59967g = string;
        Bundle arguments8 = getArguments();
        this.f59971k = arguments8 != null ? arguments8.getBoolean("is_Intercept_detail") : false;
        Subject subject = this.f59964c;
        if (subject != null) {
            Intrinsics.d(subject);
            z0(subject);
        }
        if (this.f59971k && (mViewBinding = getMViewBinding()) != null && (appCompatTextView = mViewBinding.f77583f) != null) {
            appCompatTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        final MovieDetailViewModel movieDetailViewModelR0 = r0();
        movieDetailViewModelR0.r().j(this, new a(new Function1<Pair<? extends String, ? extends Subject>, Unit>() { // from class: com.transsion.videodetail.music.ui.SubjectMusicHeaderFragment$initData$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                if (second != null) {
                    this.this$0.f59964c = second;
                    sz.a.f76638a.a(movieDetailViewModelR0.getClass().getSimpleName() + " --> initData() --> mMovieDetailBean = " + this.this$0.f59964c);
                    this.this$0.z0(second);
                    this.this$0.w0();
                    MusicLikedFragmentViewModel musicLikedFragmentViewModelQ0 = this.this$0.q0();
                    String str = this.this$0.f59966f;
                    final SubjectMusicHeaderFragment subjectMusicHeaderFragment = this.this$0;
                    musicLikedFragmentViewModelQ0.B(str, new Function1<Boolean, Unit>() { // from class: com.transsion.videodetail.music.ui.SubjectMusicHeaderFragment$initData$1$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(boolean z11) {
                            Subject subject2;
                            Integer likeStatus;
                            if (z11 || (subject2 = subjectMusicHeaderFragment.f59964c) == null || (likeStatus = subject2.getLikeStatus()) == null || likeStatus.intValue() != 1) {
                                return;
                            }
                            MusicLikedFragmentViewModel musicLikedFragmentViewModelQ1 = subjectMusicHeaderFragment.q0();
                            Subject subject3 = subjectMusicHeaderFragment.f59964c;
                            musicLikedFragmentViewModelQ1.C(subject3 != null ? subject3.getSubjectId() : null, LikeListActionEnum.REMOVE);
                        }
                    });
                }
            }
        }));
        q0().s().j(this, new a(new Function1<MusicLikedRemoteItemBean, Unit>() { // from class: com.transsion.videodetail.music.ui.SubjectMusicHeaderFragment.initData.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MusicLikedRemoteItemBean musicLikedRemoteItemBean) {
                invoke2(musicLikedRemoteItemBean);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MusicLikedRemoteItemBean musicLikedRemoteItemBean) {
                Integer likeStatus;
                int i11;
                Resources resources;
                Resources resources2;
                String string2 = null;
                if (TextUtils.equals(SubjectMusicHeaderFragment.this.f59966f, musicLikedRemoteItemBean != null ? musicLikedRemoteItemBean.getSubjectId() : null)) {
                    Subject subject2 = SubjectMusicHeaderFragment.this.f59964c;
                    if (subject2 != null) {
                        if ((musicLikedRemoteItemBean != null ? musicLikedRemoteItemBean.getActionEnum() : null) == LikeListActionEnum.ADD) {
                            zp.b.a aVar = zp.b.f82110a;
                            Context context = SubjectMusicHeaderFragment.this.getContext();
                            if (context != null && (resources2 = context.getResources()) != null) {
                                string2 = resources2.getString(R$string.music_liked_success);
                            }
                            aVar.e(string2);
                            i11 = 1;
                        } else {
                            zp.b.a aVar2 = zp.b.f82110a;
                            Context context2 = SubjectMusicHeaderFragment.this.getContext();
                            if (context2 != null && (resources = context2.getResources()) != null) {
                                string2 = resources.getString(R$string.music_liked_remove_success);
                            }
                            aVar2.e(string2);
                            i11 = 0;
                        }
                        subject2.setLikeStatus(i11);
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    Subject subject3 = SubjectMusicHeaderFragment.this.f59964c;
                    linkedHashMap.put("click_action", (subject3 == null || (likeStatus = subject3.getLikeStatus()) == null || likeStatus.intValue() != 0) ? "add" : "remove");
                    com.transsion.baselib.report.m.f51277a.m("subject_music_header_fragment", "click", linkedHashMap);
                    SubjectMusicHeaderFragment.this.w0();
                }
            }
        }));
        x0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void initView(View view, Bundle bundle) {
        View view2;
        AppCompatImageView appCompatImageView;
        AppCompatTextView appCompatTextView;
        Intrinsics.g(view, "view");
        q mViewBinding = getMViewBinding();
        if (mViewBinding != null && (appCompatTextView = mViewBinding.f77584g) != null) {
            Context context = getContext();
            appCompatTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(context != null ? context.getDrawable(R$drawable.ic_tag_music) : null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        q mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (appCompatImageView = mViewBinding2.f77581c) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.music.ui.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    SubjectMusicHeaderFragment.t0(this.f59986a, view3);
                }
            });
        }
        q mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (view2 = mViewBinding3.f77585h) == null) {
            return;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.music.ui.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                SubjectMusicHeaderFragment.u0(this.f59987a, view3);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
    public q getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        q qVarC = q.c(inflater);
        Intrinsics.f(qVarC, "inflate(inflater)");
        return qVarC;
    }

    public final void w0() {
        final AppCompatImageView appCompatImageView;
        q mViewBinding = getMViewBinding();
        if (mViewBinding == null || (appCompatImageView = mViewBinding.f77581c) == null) {
            return;
        }
        q0().B(this.f59966f, new Function1<Boolean, Unit>() { // from class: com.transsion.videodetail.music.ui.SubjectMusicHeaderFragment$showLikedIcon$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z11) {
                if (z11) {
                    appCompatImageView.setImageResource(com.transsion.moviedetail.R$drawable.music_collection_1);
                } else {
                    appCompatImageView.setImageResource(com.transsion.moviedetail.R$drawable.music_collection_0);
                }
            }
        });
    }

    public final void y0() {
        Subject subject = this.f59964c;
        if (subject != null) {
            z0(subject);
            w0();
        }
    }
}
