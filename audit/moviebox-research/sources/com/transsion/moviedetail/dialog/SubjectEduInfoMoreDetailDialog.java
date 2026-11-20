package com.transsion.moviedetail.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.baselib.report.h;
import com.transsion.moviedetail.R$string;
import com.transsion.moviedetail.dialog.SubjectEduInfoMoreDetailDialog;
import com.transsion.moviedetail.view.CustomTextViewGroup;
import com.transsion.moviedetail.view.InfoExtendView;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.play.detail.fragment.BaseBottomDialogFragment;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import so.c;
import tu.e;

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
public final class SubjectEduInfoMoreDetailDialog extends BaseBottomDialogFragment<e> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f53453n = new a(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Subject f53454l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f53455m;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final void W0(SubjectEduInfoMoreDetailDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        BaseBottomDialogFragment.S0(this$0, false, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void Y0(Subject subject) {
        e eVar;
        CustomTextViewGroup customTextViewGroup;
        e eVar2;
        CustomTextViewGroup customTextViewGroup2;
        e eVar3;
        CustomTextViewGroup customTextViewGroup3;
        e eVar4;
        CustomTextViewGroup customTextViewGroup4;
        AppCompatImageView appCompatImageView;
        this.f53454l = subject;
        e eVar5 = (e) getMViewBinding();
        AppCompatTextView appCompatTextView = eVar5 != null ? eVar5.f77476l : null;
        if (appCompatTextView != null) {
            appCompatTextView.setText(subject.getTitle());
        }
        X0(subject);
        int iA = com.transsion.moviedetailapi.a.a(subject.getSubjectType());
        e eVar6 = (e) getMViewBinding();
        if (eVar6 != null && (appCompatImageView = eVar6.f77469d) != null) {
            appCompatImageView.setImageResource(iA);
        }
        String category = subject.getCategory();
        if (category != null && (eVar4 = (e) getMViewBinding()) != null && (customTextViewGroup4 = eVar4.f77471g) != null) {
            customTextViewGroup4.setText(category);
        }
        String genre = subject.getGenre();
        if (genre != null && (eVar3 = (e) getMViewBinding()) != null && (customTextViewGroup3 = eVar3.f77474j) != null) {
            customTextViewGroup3.setText(genre);
        }
        String strA = defpackage.a.a(this.f53454l);
        if (strA != null && (eVar2 = (e) getMViewBinding()) != null && (customTextViewGroup2 = eVar2.f77473i) != null) {
            customTextViewGroup2.setText(strA);
        }
        Context context = getContext();
        if (context != null) {
            int i11 = R$string.movie_detail_students;
            Object[] objArr = new Object[1];
            Long viewers = subject.getViewers();
            objArr[0] = Long.valueOf(viewers != null ? viewers.longValue() : 0L);
            String string = context.getString(i11, objArr);
            if (string == null || (eVar = (e) getMViewBinding()) == null || (customTextViewGroup = eVar.f77477m) == null) {
                return;
            }
            customTextViewGroup.setText(string);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: V0, reason: merged with bridge method [inline-methods] */
    public e getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        e eVarC = e.c(inflater);
        Intrinsics.f(eVarC, "inflate(inflater)");
        return eVarC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void X0(Subject subject) {
        InfoExtendView infoExtendView;
        InfoExtendView infoExtendView2;
        InfoExtendView infoExtendView3;
        String description = subject != null ? subject.getDescription() : null;
        if (description == null || description.length() == 0) {
            e eVar = (e) getMViewBinding();
            if (eVar == null || (infoExtendView = eVar.f77468c) == null) {
                return;
            }
            c.g(infoExtendView);
            return;
        }
        e eVar2 = (e) getMViewBinding();
        if (eVar2 != null && (infoExtendView3 = eVar2.f77468c) != null) {
            infoExtendView3.showData(subject);
        }
        e eVar3 = (e) getMViewBinding();
        if (eVar3 == null || (infoExtendView2 = eVar3.f77468c) == null) {
            return;
        }
        c.k(infoExtendView2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        AppCompatImageView appCompatImageView;
        e eVar = (e) getMViewBinding();
        if (eVar == null || (appCompatImageView = eVar.f77472h) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: uu.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubjectEduInfoMoreDetailDialog.W0(this.f78636a, view);
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
        AppCompatImageView appCompatImageView;
        HashMap<String, String> mapG;
        HashMap<String, String> mapG2;
        HashMap<String, String> mapG3;
        String subjectId;
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("data_key_resource_detectors") : null;
        Subject subject = serializable instanceof Subject ? (Subject) serializable : null;
        this.f53454l = subject;
        this.f53455m = subject != null ? subject.getSubjectId() : null;
        h logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.j(true);
        }
        h logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null && (mapG3 = logViewConfig2.g()) != null) {
            Subject subject2 = this.f53454l;
            if (subject2 == null || (subjectId = subject2.getSubjectId()) == null) {
                subjectId = "";
            }
            mapG3.put("subject_id", subjectId);
        }
        h logViewConfig3 = getLogViewConfig();
        if (logViewConfig3 != null && (mapG2 = logViewConfig3.g()) != null) {
            Subject subject3 = this.f53454l;
            mapG2.put("subject_type", String.valueOf(subject3 != null ? subject3.getSubjectType() : null));
        }
        h logViewConfig4 = getLogViewConfig();
        if (logViewConfig4 != null && (mapG = logViewConfig4.g()) != null) {
            Subject subject4 = this.f53454l;
            mapG.put("has_resource", String.valueOf(subject4 != null ? subject4.getHasResource() : null));
        }
        Subject subject5 = this.f53454l;
        if (subject5 != null) {
            int iA = com.transsion.moviedetailapi.a.a(subject5.getSubjectType());
            e eVar = (e) getMViewBinding();
            if (eVar != null && (appCompatImageView = eVar.f77469d) != null) {
                appCompatImageView.setImageResource(iA);
            }
            e eVar2 = (e) getMViewBinding();
            AppCompatTextView appCompatTextView = eVar2 != null ? eVar2.f77476l : null;
            if (appCompatTextView != null) {
                appCompatTextView.setText(subject5.getTitle());
            }
            Y0(subject5);
        }
    }
}
