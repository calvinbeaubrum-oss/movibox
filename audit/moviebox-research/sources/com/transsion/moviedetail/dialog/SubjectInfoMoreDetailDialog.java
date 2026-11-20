package com.transsion.moviedetail.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.blankj.utilcode.util.Utils;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baselib.report.h;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$string;
import com.transsion.moviedetail.dialog.SubjectInfoMoreDetailDialog;
import com.transsion.moviedetail.fragment.StarringFragment;
import com.transsion.moviedetail.view.CustomTextViewGroup;
import com.transsion.moviedetail.view.InfoExtendView;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.ninegridview.ImageInfo;
import com.transsion.ninegridview.preview.ImagePreviewActivity;
import com.transsion.play.detail.fragment.BaseBottomDialogFragment;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.g;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import so.c;
import tu.o;

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
public final class SubjectInfoMoreDetailDialog extends BaseBottomDialogFragment<o> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f53456n = new a(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Subject f53457l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f53458m;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final void Y0(SubjectInfoMoreDetailDialog this$0, View view) {
        Cover cover;
        Intrinsics.g(this$0, "this$0");
        Subject subject = this$0.f53457l;
        if (subject == null || (cover = subject.getCover()) == null) {
            return;
        }
        com.transsion.baselib.helper.a.f51183a.g("detail_info", "preview", (28 & 4) != 0 ? "" : null, (28 & 8) != 0 ? "" : null, (28 & 16) != 0 ? "" : null);
        ImageInfo imageInfo = new ImageInfo();
        imageInfo.bigImageUrl = cover.getUrl();
        imageInfo.thumbnailUrl = cover.getThumbnail();
        Integer height = cover.getHeight();
        imageInfo.imageViewHeight = height != null ? height.intValue() : 0.0f;
        Integer width = cover.getWidth();
        imageInfo.imageViewWidth = width != null ? width.intValue() : 0.0f;
        List<? extends ImageInfo> listQ = g.q(imageInfo);
        ImagePreviewActivity.a aVar = ImagePreviewActivity.Companion;
        Context context = view.getContext();
        Intrinsics.f(context, "view.context");
        aVar.a(context, 0, listQ);
    }

    public static final void Z0(SubjectInfoMoreDetailDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        BaseBottomDialogFragment.S0(this$0, false, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void a1(Subject subject) {
        InfoExtendView infoExtendView;
        InfoExtendView infoExtendView2;
        InfoExtendView infoExtendView3;
        String description = subject != null ? subject.getDescription() : null;
        if (description == null || description.length() == 0) {
            o oVar = (o) getMViewBinding();
            if (oVar == null || (infoExtendView = oVar.f77550d) == null) {
                return;
            }
            c.g(infoExtendView);
            return;
        }
        o oVar2 = (o) getMViewBinding();
        if (oVar2 != null && (infoExtendView3 = oVar2.f77550d) != null) {
            infoExtendView3.showData(subject);
        }
        o oVar3 = (o) getMViewBinding();
        if (oVar3 == null || (infoExtendView2 = oVar3.f77550d) == null) {
            return;
        }
        c.k(infoExtendView2);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
    }

    public final String W0(String str) {
        if (str.length() < 4) {
            return str;
        }
        String strSubstring = str.substring(0, 4);
        Intrinsics.f(strSubstring, "substring(...)");
        return strSubstring;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public o getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        o oVarC = o.c(inflater);
        Intrinsics.f(oVarC, "inflate(inflater)");
        return oVarC;
    }

    public final void b1(Subject subject) {
        Integer subjectType;
        if (subject != null && (subjectType = subject.getSubjectType()) != null) {
            int iIntValue = subjectType.intValue();
            int value = SubjectType.AUDIO.getValue();
            if (iIntValue <= SubjectType.MUSIC.getValue() && value <= iIntValue) {
                return;
            }
        }
        List<Staff> staffList = subject != null ? subject.getStaffList() : null;
        if (staffList == null || staffList.isEmpty()) {
            return;
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.f(childFragmentManager, "childFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
        Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
        fragmentTransactionBeginTransaction.replace(R$id.fl_starring, new StarringFragment());
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        AppCompatImageView appCompatImageView;
        ShapeableImageView shapeableImageView;
        o oVar = (o) getMViewBinding();
        if (oVar != null && (shapeableImageView = oVar.f77552g) != null) {
            shapeableImageView.setOnClickListener(new View.OnClickListener() { // from class: uu.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubjectInfoMoreDetailDialog.Y0(this.f78637a, view);
                }
            });
        }
        o oVar2 = (o) getMViewBinding();
        if (oVar2 == null || (appCompatImageView = oVar2.f77556k) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: uu.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubjectInfoMoreDetailDialog.Z0(this.f78638a, view);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public h newLogViewConfig() {
        return new h("detail_info", false, 2, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        if (isResumed()) {
            if (z11) {
                logPause();
            } else {
                logResume();
            }
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        CustomTextViewGroup customTextViewGroup;
        o oVar;
        CustomTextViewGroup customTextViewGroup2;
        o oVar2;
        CustomTextViewGroup customTextViewGroup3;
        o oVar3;
        CustomTextViewGroup customTextViewGroup4;
        o oVar4;
        CustomTextViewGroup customTextViewGroup5;
        CustomTextViewGroup customTextViewGroup6;
        o oVar5;
        CustomTextViewGroup customTextViewGroup7;
        AppCompatTextView tvScore;
        AppCompatImageView ivScore;
        View vSeasonsLine;
        AppCompatTextView tvSeasons;
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        List listE0;
        AppCompatTextView appCompatTextView3;
        AppCompatImageView appCompatImageView;
        ShapeableImageView shapeableImageView;
        Cover cover;
        String thumbnail;
        Cover cover2;
        String url;
        HashMap<String, String> mapG;
        HashMap<String, String> mapG2;
        HashMap<String, String> mapG3;
        String subjectId;
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("data_key_resource_detectors") : null;
        Subject subject = serializable instanceof Subject ? (Subject) serializable : null;
        this.f53457l = subject;
        this.f53458m = subject != null ? subject.getSubjectId() : null;
        h logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.j(true);
        }
        h logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null && (mapG3 = logViewConfig2.g()) != null) {
            Subject subject2 = this.f53457l;
            if (subject2 == null || (subjectId = subject2.getSubjectId()) == null) {
                subjectId = "";
            }
            mapG3.put("subject_id", subjectId);
        }
        h logViewConfig3 = getLogViewConfig();
        if (logViewConfig3 != null && (mapG2 = logViewConfig3.g()) != null) {
            Subject subject3 = this.f53457l;
            mapG2.put("subject_type", String.valueOf(subject3 != null ? subject3.getSubjectType() : null));
        }
        h logViewConfig4 = getLogViewConfig();
        if (logViewConfig4 != null && (mapG = logViewConfig4.g()) != null) {
            Subject subject4 = this.f53457l;
            mapG.put("has_resource", String.valueOf(subject4 != null ? subject4.getHasResource() : null));
        }
        o oVar6 = (o) getMViewBinding();
        if (oVar6 != null && (shapeableImageView = oVar6.f77552g) != null) {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context contextRequireContext = requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            Subject subject5 = this.f53457l;
            String str = (subject5 == null || (cover2 = subject5.getCover()) == null || (url = cover2.getUrl()) == null) ? "" : url;
            Subject subject6 = this.f53457l;
            companion.q(contextRequireContext, shapeableImageView, str, (8120 & 8) != 0 ? companion.d() : 0, (8120 & 16) != 0 ? companion.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : (subject6 == null || (cover = subject6.getCover()) == null || (thumbnail = cover.getThumbnail()) == null) ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
        }
        Subject subject7 = this.f53457l;
        if (subject7 != null) {
            int iA = com.transsion.moviedetailapi.a.a(subject7.getSubjectType());
            o oVar7 = (o) getMViewBinding();
            if (oVar7 != null && (appCompatImageView = oVar7.f77551f) != null) {
                appCompatImageView.setImageResource(iA);
            }
            o oVar8 = (o) getMViewBinding();
            AppCompatTextView appCompatTextView4 = oVar8 != null ? oVar8.f77559n : null;
            if (appCompatTextView4 != null) {
                appCompatTextView4.setText(subject7.getTitle());
            }
            Integer seNum = subject7.getSeNum();
            if (seNum != null) {
                int iIntValue = seNum.intValue();
                if (iIntValue > 1) {
                    Context context = getContext();
                    String string = context != null ? context.getString(R$string.movie_detail_seasons, Integer.valueOf(iIntValue)) : null;
                    o oVar9 = (o) getMViewBinding();
                    if (oVar9 != null && (appCompatTextView3 = oVar9.f77562q) != null) {
                        appCompatTextView3.setText(string != null ? string : "");
                    }
                } else {
                    String subtitles = subject7.getSubtitles();
                    int size = (subtitles == null || (listE0 = StringsKt__StringsKt.E0(subtitles, new String[]{","}, false, 0, 6, null)) == null) ? 0 : listE0.size();
                    if (size > 10) {
                        o oVar10 = (o) getMViewBinding();
                        if (oVar10 != null && (appCompatTextView2 = oVar10.f77562q) != null) {
                            appCompatTextView2.setText(Utils.a().getString(R$string.movie_detail_subtitles_count, "10+"));
                        }
                    } else if (size > 1) {
                        o oVar11 = (o) getMViewBinding();
                        if (oVar11 != null && (appCompatTextView = oVar11.f77562q) != null) {
                            appCompatTextView.setText(Utils.a().getString(R$string.movie_detail_subtitles_count, String.valueOf(size)));
                        }
                    } else {
                        o oVar12 = (o) getMViewBinding();
                        if (oVar12 != null && (tvSeasons = oVar12.f77562q) != null) {
                            Intrinsics.f(tvSeasons, "tvSeasons");
                            c.g(tvSeasons);
                        }
                        o oVar13 = (o) getMViewBinding();
                        if (oVar13 != null && (vSeasonsLine = oVar13.f77565t) != null) {
                            Intrinsics.f(vSeasonsLine, "vSeasonsLine");
                            c.g(vSeasonsLine);
                        }
                    }
                }
            }
            if (subject7.isMusicType()) {
                o oVar14 = (o) getMViewBinding();
                if (oVar14 != null && (ivScore = oVar14.f77554i) != null) {
                    Intrinsics.f(ivScore, "ivScore");
                    c.g(ivScore);
                }
                o oVar15 = (o) getMViewBinding();
                if (oVar15 != null && (tvScore = oVar15.f77561p) != null) {
                    Intrinsics.f(tvScore, "tvScore");
                    c.g(tvScore);
                }
                String countryName = subject7.getCountryName();
                if (countryName != null && (oVar5 = (o) getMViewBinding()) != null && (customTextViewGroup7 = oVar5.f77557l) != null) {
                    customTextViewGroup7.setText(countryName);
                }
                String genre = subject7.getGenre();
                if (genre != null) {
                    String string2 = StringsKt__StringsKt.Z0((String) StringsKt__StringsKt.E0(genre, new String[]{","}, false, 0, 6, null).get(0)).toString();
                    o oVar16 = (o) getMViewBinding();
                    if (oVar16 != null && (customTextViewGroup6 = oVar16.f77564s) != null) {
                        customTextViewGroup6.setText(string2);
                    }
                }
                String releaseDate = subject7.getReleaseDate();
                if (releaseDate != null && (oVar4 = (o) getMViewBinding()) != null && (customTextViewGroup5 = oVar4.f77563r) != null) {
                    customTextViewGroup5.setText(W0(releaseDate));
                }
            } else {
                String restrictLevel = subject7.getRestrictLevel();
                if (restrictLevel != null && (oVar3 = (o) getMViewBinding()) != null && (customTextViewGroup4 = oVar3.f77560o) != null) {
                    customTextViewGroup4.setText(restrictLevel);
                }
                String releaseDate2 = subject7.getReleaseDate();
                if (releaseDate2 != null && (oVar2 = (o) getMViewBinding()) != null && (customTextViewGroup3 = oVar2.f77563r) != null) {
                    customTextViewGroup3.setText(W0(releaseDate2));
                }
                String countryName2 = subject7.getCountryName();
                if (countryName2 != null && (oVar = (o) getMViewBinding()) != null && (customTextViewGroup2 = oVar.f77557l) != null) {
                    customTextViewGroup2.setText(countryName2);
                }
                String genre2 = subject7.getGenre();
                if (genre2 != null) {
                    String string3 = StringsKt__StringsKt.Z0((String) StringsKt__StringsKt.E0(genre2, new String[]{","}, false, 0, 6, null).get(0)).toString();
                    o oVar17 = (o) getMViewBinding();
                    if (oVar17 != null && (customTextViewGroup = oVar17.f77564s) != null) {
                        customTextViewGroup.setText(string3);
                    }
                }
                o oVar18 = (o) getMViewBinding();
                AppCompatTextView appCompatTextView5 = oVar18 != null ? oVar18.f77561p : null;
                if (appCompatTextView5 != null) {
                    appCompatTextView5.setText(subject7.getImdbRate());
                }
            }
            a1(this.f53457l);
            b1(this.f53457l);
        }
    }
}
