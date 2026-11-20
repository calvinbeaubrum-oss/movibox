package com.transsion.videodetail.music.ui;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.transsion.baselib.report.RoomActivityLifecycleCallbacks;
import com.transsion.moviedetail.R$id;
import com.transsion.videodetail.BaseDetailActivity;
import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Route(path = "/playvideo/music_detail")
@Metadata
@SourceDebugExtension
public final class MusicDetailActivity extends BaseDetailActivity<tu.a> {
    @Override // com.transsion.videodetail.BaseDetailActivity, com.transsion.baseui.activity.BaseNewActivity
    public boolean a0() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void d0() {
        super.d0();
        if (p0() == null) {
            q0(getSupportFragmentManager().findFragmentByTag("MusicDetailFragment"));
            if (p0() == null) {
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                Intrinsics.f(supportFragmentManager, "supportFragmentManager");
                FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
                Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
                MusicDetailFragment musicDetailFragmentA = MusicDetailFragment.W.a();
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
                bundle.putBoolean("is_music_liked_fragment", this.f59789r);
                bundle.putBoolean("is_music_float_view_click", this.f59790s);
                sz.a.f76638a.c(musicDetailFragmentA.j0() + " --> loadDefaultData() --> isMusicLikedFragment = " + this.f59789r);
                musicDetailFragmentA.setArguments(bundle);
                fragmentTransactionBeginTransaction.replace(R$id.container, musicDetailFragmentA, "MusicDetailFragment");
                q0(musicDetailFragmentA);
                fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            }
        }
    }

    @Override // com.transsion.videodetail.BaseDetailActivity, com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RoomActivityLifecycleCallbacks.f51239a.m(1, this);
        sz.a.f76638a.c("MusicDetailActivity --> onCreate() --> 音乐详情页单独处理");
        com.transsion.videofloat.a.f60027a.a();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
    public tu.a getViewBinding() {
        tu.a aVarC = tu.a.c(getLayoutInflater());
        Intrinsics.f(aVarC, "inflate(layoutInflater)");
        return aVarC;
    }
}
