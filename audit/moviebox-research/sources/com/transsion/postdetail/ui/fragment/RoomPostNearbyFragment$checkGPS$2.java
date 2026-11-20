package com.transsion.postdetail.ui.fragment;

import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class RoomPostNearbyFragment$checkGPS$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ RoomPostNearbyFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomPostNearbyFragment$checkGPS$2(RoomPostNearbyFragment roomPostNearbyFragment) {
        super(1);
        this.this$0 = roomPostNearbyFragment;
    }

    public static final void b(RoomPostNearbyFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.s2(true);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.f68710a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void invoke(boolean z11) {
        FrameLayout root;
        if (!this.this$0.isAdded() || this.this$0.isDetached() || this.this$0.isRemoving()) {
            return;
        }
        uo.b.a.f(uo.b.f78622a, "NearbyLocation", "openGPS result:" + z11, false, 4, null);
        tv.p pVar = (tv.p) this.this$0.getMViewBinding();
        if (pVar == null || (root = pVar.getRoot()) == null) {
            return;
        }
        final RoomPostNearbyFragment roomPostNearbyFragment = this.this$0;
        root.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.v0
            @Override // java.lang.Runnable
            public final void run() {
                RoomPostNearbyFragment$checkGPS$2.b(roomPostNearbyFragment);
            }
        });
    }
}
