package com.transsion.audio;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.transsion.audio.player.AudioPlayer;
import com.transsion.audio.view.d;
import com.transsion.audio.viewmodel.HistoryListManager;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.player.orplayer.e;
import com.transsion.room.api.IAudioApi;
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
@Route(path = "/audio/api")
@Metadata
public class AudioApiImpl implements IAudioApi {
    @Override // com.transsion.room.api.IAudioApi
    public boolean D(AudioBean audio) {
        Intrinsics.g(audio, "audio");
        return AudioPlayer.f50830i.a().w(audio);
    }

    @Override // com.transsion.room.api.IAudioApi
    public boolean L() {
        return AudioPlayer.f50830i.a().o();
    }

    @Override // com.transsion.room.api.IAudioApi
    public long U0() {
        return AudioPlayer.f50830i.a().r();
    }

    @Override // com.transsion.room.api.IAudioApi
    public void addPlayerListener(e listener) {
        Intrinsics.g(listener, "listener");
        AudioPlayer.f50830i.a().l(listener);
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
    }

    @Override // com.transsion.room.api.IAudioApi
    public boolean p1() {
        return AudioPlayer.f50830i.a().H();
    }

    @Override // com.transsion.room.api.IAudioApi
    public void pause() {
        AudioPlayer.f50830i.a().E();
    }

    @Override // com.transsion.room.api.IAudioApi
    public void prepare() {
        AudioPlayer.f50830i.a().I();
    }

    @Override // com.transsion.room.api.IAudioApi
    public void removePlayerListener(e listener) {
        Intrinsics.g(listener, "listener");
        AudioPlayer.f50830i.a().M(listener);
    }

    @Override // com.transsion.room.api.IAudioApi
    public void s0(AudioBean audio, boolean z11) {
        Intrinsics.g(audio, "audio");
        AudioPlayer.a aVar = AudioPlayer.f50830i;
        AudioBean audioBeanS = aVar.a().s();
        if (TextUtils.equals(audioBeanS != null ? audioBeanS.getAudioUrl() : null, audio.getAudioUrl())) {
            if (aVar.a().H()) {
                return;
            }
            aVar.a().I();
            return;
        }
        HistoryListManager.a aVar2 = HistoryListManager.f50901e;
        aVar2.b().p(audio);
        aVar.a().J(audio);
        d.k().t(audio);
        String subjectId = audio.getSubjectId();
        String str = subjectId == null ? "" : subjectId;
        String postId = audio.getPostId();
        String str2 = postId == null ? "" : postId;
        if (!z11 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        HistoryListManager.m(aVar2.b(), str, str2, 0, 4, null);
    }

    @Override // com.transsion.room.api.IAudioApi
    public void seekTo(long j11) {
        AudioPlayer.f50830i.a().N(j11);
    }

    @Override // com.transsion.room.api.IAudioApi
    public void start() {
        AudioPlayer.f50830i.a().Q();
    }

    @Override // com.transsion.room.api.IAudioApi
    public void stop() {
        AudioPlayer.f50830i.a().R();
    }

    @Override // com.transsion.room.api.IAudioApi
    public boolean u(String audioUrl) {
        Intrinsics.g(audioUrl, "audioUrl");
        return AudioPlayer.f50830i.a().x(audioUrl);
    }
}
