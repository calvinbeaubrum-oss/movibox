package com.transsion.baseui.music;

import androidx.appcompat.widget.AppCompatImageView;
import com.transsion.baseui.R$drawable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

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
public final class MusicFloatView$initListener$4$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MusicFloatView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MusicFloatView$initListener$4$1(MusicFloatView musicFloatView) {
        super(0);
        this.this$0 = musicFloatView;
    }

    public static final void b(MusicFloatView this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.refresh();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f68710a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        this.this$0.q();
        com.transsion.player.orplayer.f fVarQ = MusicFloatManager.f51403i.b().q();
        if (fVarQ == null || !fVarQ.isPlaying()) {
            fs.e eVar = this.this$0.f51413a;
            if (eVar != null && (appCompatImageView = eVar.f65273f) != null) {
                appCompatImageView.setImageResource(R$drawable.music_float_play);
            }
            if (fVarQ != null && fVarQ.isComplete()) {
                fVarQ.seekTo(0L);
            }
            if (fVarQ != null) {
                fVarQ.play();
            }
        } else {
            fs.e eVar2 = this.this$0.f51413a;
            if (eVar2 != null && (appCompatImageView2 = eVar2.f65273f) != null) {
                appCompatImageView2.setImageResource(R$drawable.music_float_pause);
            }
            fVarQ.pause();
        }
        final MusicFloatView musicFloatView = this.this$0;
        musicFloatView.postDelayed(new Runnable() { // from class: com.transsion.baseui.music.j
            @Override // java.lang.Runnable
            public final void run() {
                MusicFloatView$initListener$4$1.b(musicFloatView);
            }
        }, 200L);
    }
}
