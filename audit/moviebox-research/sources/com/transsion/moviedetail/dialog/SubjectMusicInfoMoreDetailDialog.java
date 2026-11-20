package com.transsion.moviedetail.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baselib.report.h;
import com.transsion.baseui.R$drawable;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.moviedetail.dialog.SubjectMusicInfoMoreDetailDialog;
import com.transsion.moviedetail.view.InfoExtendView;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.play.detail.fragment.BaseBottomDialogFragment;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.n;
import so.c;
import tu.i;

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
public final class SubjectMusicInfoMoreDetailDialog extends BaseBottomDialogFragment<i> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f53459n = new a(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Subject f53460l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f53461m;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final void Y0(SubjectMusicInfoMoreDetailDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        BaseBottomDialogFragment.S0(this$0, false, 1, null);
    }

    private final void Z0(Staff staff) {
        com.alibaba.android.arouter.launcher.a.d().b("/movie/staff").withSerializable("staff", staff).navigation();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void a1(Subject subject) {
        InfoExtendView infoExtendView;
        InfoExtendView infoExtendView2;
        InfoExtendView infoExtendView3;
        String description = subject != null ? subject.getDescription() : null;
        if (description == null || description.length() == 0) {
            i iVar = (i) getMViewBinding();
            if (iVar == null || (infoExtendView = iVar.f77501b) == null) {
                return;
            }
            c.g(infoExtendView);
            return;
        }
        i iVar2 = (i) getMViewBinding();
        if (iVar2 != null && (infoExtendView3 = iVar2.f77501b) != null) {
            infoExtendView3.showData(subject);
        }
        i iVar3 = (i) getMViewBinding();
        if (iVar3 == null || (infoExtendView2 = iVar3.f77501b) == null) {
            return;
        }
        c.k(infoExtendView2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void b1(Subject subject) {
        this.f53460l = subject;
        a1(subject);
        i iVar = (i) getMViewBinding();
        if (iVar != null) {
            iVar.f77506h.setText(subject.getTitle());
            com.transsion.moviedetailapi.a.a(subject.getSubjectType());
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
                spannableStringBuilder.append((CharSequence) (releaseDate != null ? n.g1(releaseDate, 4) : null));
            }
            Integer durationSeconds = subject.getDurationSeconds();
            if (durationSeconds != null && durationSeconds.intValue() > 0) {
                spannableStringBuilder.append((CharSequence) " | ");
                Integer durationSeconds2 = subject.getDurationSeconds();
                spannableStringBuilder.append((CharSequence) TimeUtilKt.i(((long) (durationSeconds2 != null ? durationSeconds2.intValue() : 0)) * 1000));
            }
            iVar.f77508j.setText(spannableStringBuilder);
            List<Staff> staffList = subject.getStaffList();
            if (staffList != null) {
                if (!(!staffList.isEmpty())) {
                    iVar.f77502c.setVisibility(8);
                    iVar.f77504f.setVisibility(8);
                    return;
                }
                final Staff staff = staffList.get(0);
                if (TextUtils.isEmpty(staff.getAvatarUrl())) {
                    iVar.f77502c.setVisibility(8);
                    iVar.f77504f.setVisibility(8);
                    return;
                }
                ImageHelper.Companion companion = ImageHelper.f51371a;
                FragmentActivity fragmentActivityRequireActivity = requireActivity();
                Intrinsics.f(fragmentActivityRequireActivity, "requireActivity()");
                ShapeableImageView shapeableImageView = iVar.f77502c;
                Intrinsics.f(shapeableImageView, "viewBinding.ivAvatar");
                String avatarUrl = staff.getAvatarUrl();
                if (avatarUrl == null) {
                    avatarUrl = "";
                }
                companion.r(fragmentActivityRequireActivity, shapeableImageView, avatarUrl, (4088 & 8) != 0 ? companion.d() : 0, (4088 & 16) != 0 ? companion.c() : 0, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
                iVar.f77502c.setOnClickListener(new View.OnClickListener() { // from class: uu.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SubjectMusicInfoMoreDetailDialog.c1(this.f78639a, staff, view);
                    }
                });
                iVar.f77504f.setOnClickListener(new View.OnClickListener() { // from class: uu.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SubjectMusicInfoMoreDetailDialog.d1(this.f78641a, staff, view);
                    }
                });
                iVar.f77504f.setText(staff.getName());
            }
        }
    }

    public static final void c1(SubjectMusicInfoMoreDetailDialog this$0, Staff staff, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(staff, "$staff");
        this$0.Z0(staff);
    }

    public static final void d1(SubjectMusicInfoMoreDetailDialog this$0, Staff staff, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(staff, "$staff");
        this$0.Z0(staff);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public i getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        i iVarC = i.c(inflater);
        Intrinsics.f(iVarC, "inflate(inflater)");
        return iVarC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        AppCompatImageView appCompatImageView;
        i iVar = (i) getMViewBinding();
        if (iVar == null || (appCompatImageView = iVar.f77503d) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: uu.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubjectMusicInfoMoreDetailDialog.Y0(this.f78643a, view);
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
        AppCompatTextView appCompatTextView;
        HashMap<String, String> mapG;
        HashMap<String, String> mapG2;
        HashMap<String, String> mapG3;
        String subjectId;
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("data_key_resource_detectors") : null;
        Subject subject = serializable instanceof Subject ? (Subject) serializable : null;
        this.f53460l = subject;
        this.f53461m = subject != null ? subject.getSubjectId() : null;
        h logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.j(true);
        }
        h logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null && (mapG3 = logViewConfig2.g()) != null) {
            Subject subject2 = this.f53460l;
            if (subject2 == null || (subjectId = subject2.getSubjectId()) == null) {
                subjectId = "";
            }
            mapG3.put("subject_id", subjectId);
        }
        h logViewConfig3 = getLogViewConfig();
        if (logViewConfig3 != null && (mapG2 = logViewConfig3.g()) != null) {
            Subject subject3 = this.f53460l;
            mapG2.put("subject_type", String.valueOf(subject3 != null ? subject3.getSubjectType() : null));
        }
        h logViewConfig4 = getLogViewConfig();
        if (logViewConfig4 != null && (mapG = logViewConfig4.g()) != null) {
            Subject subject4 = this.f53460l;
            mapG.put("has_resource", String.valueOf(subject4 != null ? subject4.getHasResource() : null));
        }
        i iVar = (i) getMViewBinding();
        if (iVar != null && (appCompatTextView = iVar.f77508j) != null) {
            Context context = getContext();
            appCompatTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(context != null ? d1.a.b(context, R$drawable.ic_tag_music) : null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        Subject subject5 = this.f53460l;
        if (subject5 != null) {
            com.transsion.moviedetailapi.a.a(subject5.getSubjectType());
            i iVar2 = (i) getMViewBinding();
            AppCompatTextView appCompatTextView2 = iVar2 != null ? iVar2.f77506h : null;
            if (appCompatTextView2 != null) {
                appCompatTextView2.setText(subject5.getTitle());
            }
            b1(subject5);
        }
    }
}
