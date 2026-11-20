package com.transsion.baseui.music;

import androidx.lifecycle.u;
import com.transsion.player.mediasession.MediaItem;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class a implements androidx.lifecycle.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f51428a = new a();

    @Override // androidx.lifecycle.f
    public /* synthetic */ void onCreate(u uVar) {
        androidx.lifecycle.e.a(this, uVar);
    }

    @Override // androidx.lifecycle.f
    public /* synthetic */ void onDestroy(u uVar) {
        androidx.lifecycle.e.b(this, uVar);
    }

    @Override // androidx.lifecycle.f
    public /* synthetic */ void onPause(u uVar) {
        androidx.lifecycle.e.c(this, uVar);
    }

    @Override // androidx.lifecycle.f
    public /* synthetic */ void onResume(u uVar) {
        androidx.lifecycle.e.d(this, uVar);
    }

    @Override // androidx.lifecycle.f
    public void onStart(u owner) {
        Intrinsics.g(owner, "owner");
        androidx.lifecycle.e.e(this, owner);
        MediaItem mediaItemO = MusicFloatManager.f51403i.b().o();
        if (mediaItemO == null) {
            return;
        }
        mediaItemO.setInBackground(Boolean.FALSE);
    }

    @Override // androidx.lifecycle.f
    public void onStop(u owner) {
        Intrinsics.g(owner, "owner");
        androidx.lifecycle.e.f(this, owner);
        MediaItem mediaItemO = MusicFloatManager.f51403i.b().o();
        if (mediaItemO != null) {
            mediaItemO.setInBackground(Boolean.TRUE);
        }
        MusicReport.f51422a.c();
    }
}
