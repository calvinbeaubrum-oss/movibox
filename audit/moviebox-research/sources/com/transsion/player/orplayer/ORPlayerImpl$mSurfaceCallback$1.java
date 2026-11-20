package com.transsion.player.orplayer;

import android.os.Handler;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.aliyun.player.AliPlayer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class ORPlayerImpl$mSurfaceCallback$1 implements SurfaceHolder.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ORPlayerImpl f54649a;

    public ORPlayerImpl$mSurfaceCallback$1(ORPlayerImpl oRPlayerImpl) {
        this.f54649a = oRPlayerImpl;
    }

    public static final void b(SurfaceHolder holder, ORPlayerImpl this$0) {
        AliPlayer aliPlayer;
        Intrinsics.g(holder, "$holder");
        Intrinsics.g(this$0, "this$0");
        Surface surface = holder.getSurface();
        if (!surface.isValid() || (aliPlayer = this$0.f54624b) == null) {
            return;
        }
        aliPlayer.setSurface(surface);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder holder, int i11, int i12, int i13) {
        Intrinsics.g(holder, "holder");
        final ORPlayerImpl oRPlayerImpl = this.f54649a;
        oRPlayerImpl.E(new Function0<Unit>() { // from class: com.transsion.player.orplayer.ORPlayerImpl$mSurfaceCallback$1$surfaceChanged$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AliPlayer aliPlayer = oRPlayerImpl.f54624b;
                if (aliPlayer != null) {
                    aliPlayer.surfaceChanged();
                }
            }
        });
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(final SurfaceHolder holder) {
        Intrinsics.g(holder, "holder");
        Handler handler = this.f54649a.f54640s;
        if (handler != null) {
            final ORPlayerImpl oRPlayerImpl = this.f54649a;
            handler.post(new Runnable() { // from class: com.transsion.player.orplayer.q
                @Override // java.lang.Runnable
                public final void run() {
                    ORPlayerImpl$mSurfaceCallback$1.b(holder, oRPlayerImpl);
                }
            });
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder holder) {
        Intrinsics.g(holder, "holder");
        final ORPlayerImpl oRPlayerImpl = this.f54649a;
        oRPlayerImpl.E(new Function0<Unit>() { // from class: com.transsion.player.orplayer.ORPlayerImpl$mSurfaceCallback$1$surfaceDestroyed$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AliPlayer aliPlayer = oRPlayerImpl.f54624b;
                if (aliPlayer != null) {
                    aliPlayer.setSurface(null);
                }
            }
        });
    }
}
