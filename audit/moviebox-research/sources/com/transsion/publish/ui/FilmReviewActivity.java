package com.transsion.publish.ui;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.publish.R$id;
import com.transsion.publish.R$string;
import com.transsion.publish.api.GroupBean;
import com.transsion.publish.view.CustomPublishHeader;
import com.transsion.room.api.IFloatingApi;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Route(path = "/publish/activity/film_review")
@Metadata
public final class FilmReviewActivity extends BaseActivity<ew.b> implements com.transsion.publish.view.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FilmReviewFragment f56492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f56493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Subject f56494c;

    public static final void S(FilmReviewActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        FilmReviewFragment filmReviewFragment = this$0.f56492a;
        if (filmReviewFragment != null) {
            filmReviewFragment.closeAffirm();
        }
    }

    public static final void T(FilmReviewActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        FilmReviewFragment filmReviewFragment = this$0.f56492a;
        if (filmReviewFragment != null) {
            filmReviewFragment.checkPost();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U() {
        ((IFloatingApi) com.alibaba.android.arouter.launcher.a.d().h(IFloatingApi.class)).c0();
    }

    private final void initData() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        GroupBean groupBean;
        ((ew.b) getMViewBinding()).f64368c.setOnBackClick(new View.OnClickListener() { // from class: com.transsion.publish.ui.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilmReviewActivity.S(this.f56585a, view);
            }
        });
        ((ew.b) getMViewBinding()).f64368c.setOnEditClick(new View.OnClickListener() { // from class: com.transsion.publish.ui.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilmReviewActivity.T(this.f56587a, view);
            }
        });
        this.f56493b = getIntent().getIntExtra("sourceType", 1);
        int intExtra = getIntent().getIntExtra("sourceMode", 0);
        if (getIntent().hasExtra("subject")) {
            Serializable serializableExtra = getIntent().getSerializableExtra("subject");
            Intrinsics.e(serializableExtra, "null cannot be cast to non-null type com.transsion.moviedetailapi.bean.Subject");
            this.f56494c = (Subject) serializableExtra;
        }
        if (getIntent().hasExtra("group")) {
            Serializable serializableExtra2 = getIntent().getSerializableExtra("group");
            Intrinsics.e(serializableExtra2, "null cannot be cast to non-null type com.transsion.publish.api.GroupBean");
            groupBean = (GroupBean) serializableExtra2;
        } else {
            groupBean = null;
        }
        if (this.f56493b == 2) {
            V(this.f56494c, groupBean);
        } else {
            ((ew.b) getMViewBinding()).f64368c.setTitle(getString(R$string.film_review_title));
        }
        this.f56492a = FilmReviewFragment.Companion.a(this.f56493b, this.f56494c, intExtra, groupBean);
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        int i11 = R$id.fl_content;
        FilmReviewFragment filmReviewFragment = this.f56492a;
        Intrinsics.d(filmReviewFragment);
        fragmentTransactionBeginTransaction.replace(i11, filmReviewFragment).commitAllowingStateLoss();
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig == null) {
            return;
        }
        logViewConfig.j(true);
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public ew.b getViewBinding() {
        ew.b bVarC = ew.b.c(getLayoutInflater());
        Intrinsics.f(bVarC, "inflate(layoutInflater)");
        return bVarC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V(Subject subject, GroupBean groupBean) {
        if (subject != null) {
            CustomPublishHeader customPublishHeader = ((ew.b) getMViewBinding()).f64368c;
            String title = subject.getTitle();
            Cover cover = subject.getCover();
            customPublishHeader.setHeader(title, cover != null ? cover.getUrl() : null);
        }
        if (groupBean != null) {
            ((ew.b) getMViewBinding()).f64368c.setHeader(groupBean.getName(), groupBean.getAvatar());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void W(boolean z11) {
        CustomPublishHeader customPublishHeader = ((ew.b) getMViewBinding()).f64368c;
        if (customPublishHeader != null) {
            customPublishHeader.setPostEnable(z11);
        }
    }

    @Override // com.transsion.publish.view.a, android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        com.transsion.publish.view.a.C0591a.a(this, editable);
    }

    @Override // com.transsion.publish.view.a, android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        com.transsion.publish.view.a.C0591a.b(this, charSequence, i11, i12, i13);
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public String getPageName() {
        return this.f56493b == 2 ? "create_post" : "create_review";
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isChangeStatusBar() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return !com.transsion.baselib.utils.o.f51321a.a();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h(getPageName(), false, 2, null);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        FilmReviewFragment filmReviewFragment = this.f56492a;
        if (filmReviewFragment != null) {
            filmReviewFragment.closeAffirm();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData();
        ((ew.b) getMViewBinding()).f64367b.postDelayed(new Runnable() { // from class: com.transsion.publish.ui.e
            @Override // java.lang.Runnable
            public final void run() {
                FilmReviewActivity.U();
            }
        }, 100L);
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ((IFloatingApi) com.alibaba.android.arouter.launcher.a.d().h(IFloatingApi.class)).j0();
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseMusicFloatActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
    }
}
