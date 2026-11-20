package com.transsion.room.api;

import com.alibaba.android.arouter.facade.template.IProvider;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.player.orplayer.e;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public interface IAudioApi extends IProvider {

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a {
        public static /* synthetic */ void a(IAudioApi iAudioApi, AudioBean audioBean, boolean z11, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: start");
            }
            if ((i11 & 2) != 0) {
                z11 = true;
            }
            iAudioApi.s0(audioBean, z11);
        }
    }

    boolean D(AudioBean audioBean);

    boolean L();

    long U0();

    void addPlayerListener(e eVar);

    boolean p1();

    void pause();

    void prepare();

    void removePlayerListener(e eVar);

    void s0(AudioBean audioBean, boolean z11);

    void seekTo(long j11);

    void start();

    void stop();

    boolean u(String str);
}
