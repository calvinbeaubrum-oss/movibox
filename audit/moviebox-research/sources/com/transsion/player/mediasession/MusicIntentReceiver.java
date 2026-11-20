package com.transsion.player.mediasession;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.transsion.player.orplayer.f;
import com.transsion.player.orplayer.global.TnPlayerManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
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
public final class MusicIntentReceiver extends BroadcastReceiver {
    public final String a() {
        String simpleName = MusicIntentReceiver.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Object objM163constructorimpl;
        Unit unit;
        Intrinsics.g(context, "context");
        Intrinsics.g(intent, "intent");
        try {
            Result.Companion companion = Result.Companion;
            String action = intent.getAction();
            if (action != null && action.hashCode() == 1997055314 && action.equals("android.intent.action.MEDIA_BUTTON")) {
                Bundle extras = intent.getExtras();
                unit = null;
                Object obj = extras != null ? extras.get("android.intent.extra.KEY_EVENT") : null;
                KeyEvent keyEvent = obj instanceof KeyEvent ? (KeyEvent) obj : null;
                if (keyEvent != null) {
                    d.f54622a.a(a() + " --> onReceive --> 接收到通知点击事件, = " + keyEvent + ", " + keyEvent.getKeyCode());
                    int keyCode = keyEvent.getKeyCode();
                    if (keyCode == 126) {
                        f fVarB = TnPlayerManager.f54684a.b();
                        if (fVarB != null) {
                            fVarB.play();
                            unit = Unit.f68710a;
                        }
                    } else if (keyCode != 127) {
                        switch (keyCode) {
                            case ModuleDescriptor.MODULE_VERSION /* 86 */:
                                f fVarB2 = TnPlayerManager.f54684a.b();
                                if (fVarB2 != null) {
                                    fVarB2.stop();
                                    unit = Unit.f68710a;
                                }
                                break;
                            case 87:
                                MediaBrowserCompatHelper.f54597h.a().p();
                                unit = Unit.f68710a;
                                break;
                            case 88:
                                MediaBrowserCompatHelper.f54597h.a().q();
                                unit = Unit.f68710a;
                                break;
                            default:
                                unit = Unit.f68710a;
                                break;
                        }
                    } else {
                        f fVarB3 = TnPlayerManager.f54684a.b();
                        if (fVarB3 != null) {
                            fVarB3.pause();
                            unit = Unit.f68710a;
                        }
                    }
                }
            } else {
                unit = Unit.f68710a;
            }
            objM163constructorimpl = Result.m163constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl == null) {
            return;
        }
        d.f54622a.a(a() + " --> onReceive --> 接收到通知点击事件 --- it = " + thM166exceptionOrNullimpl);
    }
}
