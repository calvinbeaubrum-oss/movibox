package com.transsnet.downloader.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.report.m;
import com.transsion.baselib.utils.o;
import com.transsion.baseui.activity.BaseActivity;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.fragment.DownloadMainFragment;
import com.transsnet.downloader.manager.DownloadStatusIconManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
@Route(path = "/download/panel_activity")
@Metadata
@SourceDebugExtension
public final class DownloadPanelActivity extends BaseActivity<h00.b> implements com.transsion.baselib.report.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f60291a = "download_panel_activity";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Function0<Unit>> f60292b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Autowired(name = "extra_page_index")
    @JvmField
    public int f60293c;

    public final void M(Intent intent) {
        int intExtra = intent.getIntExtra("from_page", 0);
        int intExtra2 = intent.getIntExtra("download_status", 0);
        if (intExtra > 0) {
            HashMap map = new HashMap();
            map.put("from_page", String.valueOf(intExtra));
            map.put("download_status", String.valueOf(intExtra2));
            m.f51277a.m(this.f60291a, "click", map);
        }
    }

    public final void O() {
        j.d(l0.a(w0.b()), null, null, new DownloadPanelActivity$getOutsideVideoList$1(null), 3, null);
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public h00.b getViewBinding() {
        h00.b bVarC = h00.b.c(getLayoutInflater());
        Intrinsics.f(bVarC, "inflate(layoutInflater)");
        return bVarC;
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseMusicFloatActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() == 0) {
            Iterator<T> it = this.f60292b.iterator();
            while (it.hasNext()) {
                ((Function0) it.next()).invoke();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isChangeStatusBar() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return !o.f51321a.a();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.alibaba.android.arouter.launcher.a.d().f(this);
        super.onCreate(bundle);
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().replace(R$id.container, DownloadMainFragment.f60643f.a(this.f60293c)).commitNow();
        }
        DownloadStatusIconManager.f61047h.a().s(true);
        O();
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f60292b.clear();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            M(intent);
        }
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public int statusColor() {
        return R$color.text_01;
    }
}
