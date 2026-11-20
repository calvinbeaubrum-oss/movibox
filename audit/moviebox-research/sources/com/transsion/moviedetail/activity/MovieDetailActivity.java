package com.transsion.moviedetail.activity;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.report.RoomActivityLifecycleCallbacks;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.memberapi.IMemberApi;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.fragment.MovieDetailFragment;
import com.transsion.videofloat.VideoPipManager;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@Route(path = "/movie/detail")
@Metadata
@SourceDebugExtension
public final class MovieDetailActivity extends BaseNewActivity<tu.a> implements com.transsion.videofloat.manager.c {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final a f53423s = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Autowired
    @JvmField
    public String f53424i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Autowired
    @JvmField
    public String f53425j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Autowired(name = "autoDownload")
    @JvmField
    public boolean f53426k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Autowired(name = "autoPlay")
    @JvmField
    public boolean f53427l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Autowired(name = "resourceId")
    @JvmField
    public String f53428m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Autowired(name = "module_name")
    @JvmField
    public String f53429n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Autowired(name = "yy_preload_id")
    @JvmField
    public int f53430o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Autowired(name = "season")
    @JvmField
    public int f53431p = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Autowired(name = "subject_type")
    @JvmField
    public int f53432q = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Fragment f53433r;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(String msg) {
            Intrinsics.g(msg, "msg");
            Log.w("zxb_log_movie_detail", msg);
        }
    }

    public static final void q0() {
        ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).N0(0.0f);
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public String U() {
        return "";
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void X() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void Y() {
        e0();
        ((tu.a) getMViewBinding()).getRoot().post(new Runnable() { // from class: com.transsion.moviedetail.activity.a
            @Override // java.lang.Runnable
            public final void run() {
                MovieDetailActivity.q0();
            }
        });
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void Z() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean a0() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean b0() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void c0() {
        if (this.f53433r == null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.f(supportFragmentManager, "supportFragmentManager");
            FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
            Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
            MovieDetailFragment movieDetailFragmentA = MovieDetailFragment.N.a();
            Bundle bundle = new Bundle();
            bundle.putString("id", this.f53424i);
            bundle.putString("ops", this.f53425j);
            bundle.putBoolean("auto_download", this.f53426k);
            bundle.putBoolean("auto_play", this.f53427l);
            bundle.putString("auto_play_resource_id", this.f53428m);
            bundle.putString("module_name", this.f53429n);
            bundle.putInt("season", this.f53431p);
            bundle.putInt("subject_type", this.f53432q);
            bundle.putInt("yy_preload_id", this.f53430o);
            movieDetailFragmentA.setArguments(bundle);
            fragmentTransactionBeginTransaction.replace(R$id.container, movieDetailFragmentA);
            this.f53433r = movieDetailFragmentA;
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        }
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public String getPageName() {
        return "subjectdetail";
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isChangeStatusBar() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public boolean isMonitorNetworkState() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseMusicFloatActivity
    public boolean isMusicFloatingAttach() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isStatusDark() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.alibaba.android.arouter.launcher.a.d().f(this);
        super.onCreate(bundle);
        RoomActivityLifecycleCallbacks.f51239a.m(3, this);
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        v();
        VideoPipManager.f60024a.a().g();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (isFinishing()) {
            Fragment fragment = this.f53433r;
            if (fragment instanceof MovieDetailFragment) {
                MovieDetailFragment movieDetailFragment = fragment instanceof MovieDetailFragment ? (MovieDetailFragment) fragment : null;
                if (movieDetailFragment != null) {
                    movieDetailFragment.c2();
                }
            }
        }
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public tu.a getViewBinding() {
        tu.a aVarC = tu.a.c(getLayoutInflater());
        Intrinsics.f(aVarC, "inflate(layoutInflater)");
        return aVarC;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void retryLoadData() {
        i0();
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            k0();
        } else {
            g0();
            c0();
        }
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public int statusColor() {
        return R$color.black;
    }

    @Override // com.transsion.videofloat.manager.c
    public void v() {
        Fragment fragment = this.f53433r;
        if (fragment instanceof MovieDetailFragment) {
            MovieDetailFragment movieDetailFragment = fragment instanceof MovieDetailFragment ? (MovieDetailFragment) fragment : null;
            if (movieDetailFragment != null) {
                movieDetailFragment.c2();
            }
        }
    }
}
