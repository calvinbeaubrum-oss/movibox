package com.transsion.videodetail;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.transsion.baselib.report.RoomActivityLifecycleCallbacks;
import com.transsion.videofloat.VideoPipManager;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes8.dex */
@Route(path = "/playvideo/detail")
@Metadata
@SourceDebugExtension
public final class StreamDetailActivity extends BaseDetailActivity<tu.a> implements com.transsion.videofloat.manager.c {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final a f59796u = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.transsion.videodetail.BaseDetailActivity, com.transsion.baseui.activity.BaseNewActivity
    public void c0() {
        if (p0() == null) {
            q0(getSupportFragmentManager().findFragmentByTag("VideoDetailFragment"));
            if (p0() == null) {
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                Intrinsics.f(supportFragmentManager, "supportFragmentManager");
                FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
                Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
                StreamDetailFragment streamDetailFragmentA = StreamDetailFragment.T.a();
                Bundle bundle = new Bundle();
                bundle.putString("id", this.f59780i);
                bundle.putString("ops", this.f59781j);
                bundle.putBoolean("auto_download", this.f59782k);
                bundle.putBoolean("auto_play", this.f59783l);
                bundle.putString("auto_play_resource_id", this.f59784m);
                bundle.putString("module_name", this.f59785n);
                bundle.putInt("yy_preload_id", this.f59786o);
                bundle.putInt("season", this.f59787p);
                bundle.putInt("episode", this.f59788q);
                streamDetailFragmentA.setArguments(bundle);
                fragmentTransactionBeginTransaction.replace(com.transsion.moviedetail.R$id.container, streamDetailFragmentA, "VideoDetailFragment");
                q0(streamDetailFragmentA);
                fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            }
        }
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public String getPageName() {
        return "subjectdetail";
    }

    @Override // com.transsion.videodetail.BaseDetailActivity, com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
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
        if (isFinishing() && (p0() instanceof StreamDetailFragment)) {
            Fragment fragmentP0 = p0();
            StreamDetailFragment streamDetailFragment = fragmentP0 instanceof StreamDetailFragment ? (StreamDetailFragment) fragmentP0 : null;
            if (streamDetailFragment != null) {
                streamDetailFragment.y2();
            }
        }
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseMusicFloatActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.transsion.videodetail.BaseDetailActivity, com.transsion.baseui.activity.BaseNewActivity
    public void retryLoadData() {
        i0();
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            k0();
        } else {
            g0();
            c0();
        }
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
    public tu.a getViewBinding() {
        tu.a aVarC = tu.a.c(getLayoutInflater());
        Intrinsics.f(aVarC, "inflate(layoutInflater)");
        return aVarC;
    }

    @Override // com.transsion.videofloat.manager.c
    public void v() {
        if (p0() instanceof StreamDetailFragment) {
            Fragment fragmentP0 = p0();
            StreamDetailFragment streamDetailFragment = fragmentP0 instanceof StreamDetailFragment ? (StreamDetailFragment) fragmentP0 : null;
            if (streamDetailFragment != null) {
                streamDetailFragment.y2();
            }
        }
    }
}
