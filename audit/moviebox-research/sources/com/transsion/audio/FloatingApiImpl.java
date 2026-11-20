package com.transsion.audio;

import android.app.Activity;
import android.content.Context;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.transsion.audio.player.AudioPlayer;
import com.transsion.audio.view.d;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.room.api.IFloatingApi;
import java.lang.ref.WeakReference;
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
/* JADX INFO: loaded from: classes.dex */
@Route(path = "/audio/float")
@Metadata
public class FloatingApiImpl implements IFloatingApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f50761a;

    @Override // com.transsion.room.api.IFloatingApi
    public void L0() {
        d.k().r();
    }

    @Override // com.transsion.room.api.IFloatingApi
    public void W0(WeakReference<Activity> refer) {
        Intrinsics.g(refer, "refer");
        d.k().h(refer.get());
    }

    @Override // com.transsion.room.api.IFloatingApi
    public void X() {
        d.k().s();
    }

    @Override // com.transsion.room.api.IFloatingApi
    public void c0() {
        AudioPlayer.a aVar = AudioPlayer.f50830i;
        if (aVar.a().H()) {
            aVar.a().E();
            this.f50761a = true;
        }
        hide();
    }

    @Override // com.transsion.room.api.IFloatingApi
    public void h0(IFloatingApi.a aVar) {
        d.k().v(aVar);
    }

    @Override // com.transsion.room.api.IFloatingApi
    public void hide() {
        d.k().w(8);
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
    }

    @Override // com.transsion.room.api.IFloatingApi
    public void j0() {
        if (this.f50761a) {
            AudioPlayer.f50830i.a().Q();
            this.f50761a = false;
            show();
        }
    }

    @Override // com.transsion.room.api.IFloatingApi
    public void m1(IFloatingApi.a aVar) {
        d.k().u(aVar);
    }

    @Override // com.transsion.room.api.IFloatingApi
    public void p0(String name) {
        Intrinsics.g(name, "name");
        d.k().x(name);
    }

    @Override // com.transsion.room.api.IFloatingApi
    public void r0(WeakReference<Activity> refer) {
        Intrinsics.g(refer, "refer");
        d.k().f(refer.get());
    }

    @Override // com.transsion.room.api.IFloatingApi
    public void show() {
        d.k().w(0);
    }

    @Override // com.transsion.room.api.IFloatingApi
    public void y(WeakReference<Activity> refer, AudioBean audioBean) {
        Intrinsics.g(refer, "refer");
        Intrinsics.g(audioBean, "audioBean");
        d.k().d(refer.get(), audioBean);
        d.k().f(refer.get());
    }
}
