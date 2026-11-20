package com.transsion.player.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class LandSpaceHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f54860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f54861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f54862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f54863d;

    public LandSpaceHelper(View startView, View endView) {
        Intrinsics.g(startView, "startView");
        Intrinsics.g(endView, "endView");
        this.f54860a = startView;
        this.f54861b = endView;
        this.f54863d = LazyKt__LazyJVMKt.b(new Function0<d>() { // from class: com.transsion.player.utils.LandSpaceHelper$orientationEventListener$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final d invoke() {
                Context context = this.this$0.f54860a.getContext();
                Intrinsics.e(context, "null cannot be cast to non-null type android.app.Activity");
                final LandSpaceHelper landSpaceHelper = this.this$0;
                return new d((Activity) context, new Function1<Integer, Unit>() { // from class: com.transsion.player.utils.LandSpaceHelper$orientationEventListener$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(int i11) {
                        if (i11 == 0 || i11 == 1 || i11 == 3) {
                            LandSpaceHelper landSpaceHelper2 = landSpaceHelper;
                            landSpaceHelper2.h(landSpaceHelper2.f54862c, i11);
                        }
                    }
                });
            }
        });
    }

    public final void d() {
        d dVarF = f();
        if (dVarF != null) {
            dVarF.disable();
        }
    }

    public final void e() {
        d dVarF = f();
        if (dVarF != null) {
            dVarF.enable();
        }
    }

    public final d f() {
        return (d) this.f54863d.getValue();
    }

    public final void g(boolean z11) {
        this.f54862c = z11;
        h(z11, z11 ? 1 : 0);
    }

    public final void h(boolean z11, int i11) {
        int iC = com.blankj.utilcode.util.d.c();
        int i12 = (z11 && i11 == 1) ? iC : 0;
        if (!z11 || i11 != 3) {
            iC = 0;
        }
        ViewGroup.LayoutParams layoutParams = this.f54860a.getLayoutParams();
        layoutParams.width = i12;
        this.f54860a.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f54861b.getLayoutParams();
        layoutParams2.width = iC;
        this.f54861b.setLayoutParams(layoutParams2);
    }
}
