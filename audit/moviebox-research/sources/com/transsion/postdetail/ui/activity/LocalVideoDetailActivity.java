package com.transsion.postdetail.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.transsion.baselib.report.d;
import com.transsion.baseui.R$color;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.memberapi.IMemberApi;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment;
import com.transsion.room.api.IFloatingApi;
import com.transsion.subtitle.dialog.SubtitleMainDialog2;
import com.transsion.videofloat.VideoPipManager;
import com.transsion.videofloat.manager.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;
import uo.b;

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
@Route(path = "/video/detail")
@Metadata
public final class LocalVideoDetailActivity extends BaseActivity<tv.a> implements d, c {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a f55521q = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Autowired(name = "extra_local_path")
    @JvmField
    public String f55522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Autowired(name = "extra_url")
    @JvmField
    public String f55523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Autowired(name = "extra_proxy_url")
    @JvmField
    public String f55524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Autowired(name = "extra_name")
    @JvmField
    public String f55525d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Autowired(name = "extra_resource_id")
    @JvmField
    public String f55526f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Autowired(name = "extra_post_id")
    @JvmField
    public String f55527g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Autowired(name = "extra_subject_id")
    @JvmField
    public String f55528h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Autowired(name = "extra_page_from")
    @JvmField
    public String f55531k;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LocalVideoDetailFragment f55536p;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Autowired(name = "extra_completed")
    @JvmField
    public Boolean f55529i = Boolean.TRUE;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Autowired(name = "extra_is_series")
    @JvmField
    public Boolean f55530j = Boolean.FALSE;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Autowired(name = "extra_height")
    @JvmField
    public Integer f55532l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Autowired(name = "extra_width")
    @JvmField
    public Integer f55533m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Autowired(name = "extra_parent_position")
    @JvmField
    public Integer f55534n = -1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Autowired(name = "extra_position")
    @JvmField
    public Integer f55535o = -1;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final void R() {
        ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).N0(0.0f);
    }

    private final void S() {
        LocalVideoDetailFragment localVideoDetailFragment = this.f55536p;
        if (localVideoDetailFragment != null) {
            localVideoDetailFragment.v3();
        }
        this.f55536p = LocalVideoDetailFragment.f55662w0.a(this.f55522a, this.f55523b, this.f55525d, this.f55526f, this.f55527g, this.f55528h, this.f55524c, this.f55529i, this.f55530j, this.f55531k, this.f55532l, this.f55533m, this.f55534n, this.f55535o);
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        int i11 = R$id.container;
        LocalVideoDetailFragment localVideoDetailFragment2 = this.f55536p;
        Intrinsics.d(localVideoDetailFragment2);
        fragmentTransactionBeginTransaction.replace(i11, localVideoDetailFragment2).commitAllowingStateLoss();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public tv.a getViewBinding() {
        tv.a aVarC = tv.a.c(getLayoutInflater());
        Intrinsics.f(aVarC, "inflate(layoutInflater)");
        return aVarC;
    }

    public final void Q() {
        Uri data = getIntent().getData();
        Intent intent = getIntent();
        String type = intent != null ? intent.getType() : null;
        if ((type == null || !l.L(type, "video/", false, 2, null)) && (type == null || !l.L(type, "audio/", false, 2, null))) {
            return;
        }
        if (l.L(String.valueOf(data), HttpHost.DEFAULT_SCHEME_NAME, false, 2, null)) {
            this.f55523b = String.valueOf(data);
        } else {
            this.f55522a = String.valueOf(data);
        }
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isAttach() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseMusicFloatActivity
    public boolean isMusicFloatingAttach() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return false;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        ((IFloatingApi) com.alibaba.android.arouter.launcher.a.d().h(IFloatingApi.class)).j0();
        super.onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.alibaba.android.arouter.launcher.a.d().f(this);
        super.onCreate(bundle);
        b.a aVar = b.f78622a;
        b.a.f(aVar, "LocalVideoDetail", "LocalVideoDetailActivity onCreate", false, 4, null);
        b.a.f(aVar, "VideoFloat", "LocalVideoDetailActivity onCreate, " + (bundle == null), false, 4, null);
        ((IFloatingApi) com.alibaba.android.arouter.launcher.a.d().h(IFloatingApi.class)).L0();
        ((IFloatingApi) com.alibaba.android.arouter.launcher.a.d().h(IFloatingApi.class)).c0();
        Q();
        if (bundle == null) {
            S();
        }
        ((tv.a) getMViewBinding()).getRoot().post(new Runnable() { // from class: com.transsion.postdetail.ui.activity.a
            @Override // java.lang.Runnable
            public final void run() {
                LocalVideoDetailActivity.R();
            }
        });
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        v();
        VideoPipManager.f60024a.a().g();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        boolean zB = Intrinsics.b(this.f55528h, intent != null ? intent.getStringExtra("extra_subject_id") : null);
        String stringExtra = intent != null ? intent.getStringExtra("extra_page_from") : null;
        setIntent(intent);
        com.alibaba.android.arouter.launcher.a.d().f(this);
        Q();
        if (Intrinsics.b(stringExtra, "media_notification")) {
            LocalVideoDetailFragment localVideoDetailFragment = this.f55536p;
            if (localVideoDetailFragment != null) {
                localVideoDetailFragment.q3();
                return;
            }
            return;
        }
        b.a.f(b.f78622a, "LocalVideoDetail", "LocalVideoDetailActivity onNewIntent,isCurrentSubject = " + zB, false, 4, null);
        if (zB) {
            LocalVideoDetailFragment localVideoDetailFragment2 = this.f55536p;
            if (localVideoDetailFragment2 != null) {
                localVideoDetailFragment2.t2(this.f55528h, this.f55526f);
                return;
            }
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag("fragment_subtitle_main_dialog");
            if (fragmentFindFragmentByTag != null && (fragmentFindFragmentByTag instanceof SubtitleMainDialog2)) {
                ((SubtitleMainDialog2) fragmentFindFragmentByTag).dismissAllowingStateLoss();
            }
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
        S();
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        LocalVideoDetailFragment localVideoDetailFragment;
        super.onPause();
        if (!isFinishing() || (localVideoDetailFragment = this.f55536p) == null) {
            return;
        }
        localVideoDetailFragment.v3();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public int statusColor() {
        return R$color.base_color_black;
    }

    @Override // com.transsion.videofloat.manager.c
    public void v() {
        LocalVideoDetailFragment localVideoDetailFragment = this.f55536p;
        if (localVideoDetailFragment != null) {
            localVideoDetailFragment.v3();
        }
    }
}
