package com.transsion.baseui.activity;

import android.view.MotionEvent;
import com.transsion.baseui.music.MusicFloatManager;
import kotlin.Metadata;
import n6.a;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class BaseMusicFloatActivity<T extends n6.a> extends BaseCommonActivity<T> {
    public static final int $stable = 0;

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Integer numValueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            MusicFloatManager.f51403i.b().g(this, motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getMarginBottom() {
        return 0;
    }

    public int getMarginLeft() {
        return 0;
    }

    public int getMarginRight() {
        return 0;
    }

    public int getMarginTop() {
        return 0;
    }

    public boolean isMusicFloatingAttach() {
        return true;
    }

    public boolean isShowedMusicFloatView() {
        return MusicFloatManager.f51403i.b().v(this);
    }

    public void onCloseMusicFloating() {
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (isMusicFloatingAttach()) {
            MusicFloatManager.f51403i.b().j(this, getMarginBottom());
        }
    }

    public final void showMusicFloating() {
        MusicFloatManager.f51403i.b().j(this, getMarginBottom());
    }
}
