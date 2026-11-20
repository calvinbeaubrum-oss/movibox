package com.permissionx.guolindev.request;

import android.view.View;
import com.permissionx.guolindev.callback.PermissionDialogClickType;
import com.permissionx.guolindev.dialog.RationaleDialog;
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
public final class PermissionBuilder$showHandlePermissionDialog$2 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ c $chainTask;
    final /* synthetic */ RationaleDialog $dialog;
    final /* synthetic */ boolean $showReasonOrGoSettings;
    final /* synthetic */ PermissionBuilder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionBuilder$showHandlePermissionDialog$2(PermissionBuilder permissionBuilder, RationaleDialog rationaleDialog, boolean z11, c cVar) {
        super(1);
        this.this$0 = permissionBuilder;
        this.$dialog = rationaleDialog;
        this.$showReasonOrGoSettings = z11;
        this.$chainTask = cVar;
    }

    public static final void b(PermissionBuilder this$0, RationaleDialog dialog, boolean z11, c chainTask, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(dialog, "$dialog");
        Intrinsics.g(chainTask, "$chainTask");
        ao.a aVar = this$0.f48683r;
        if (aVar != null) {
            aVar.a(dialog, Boolean.valueOf(!z11), PermissionDialogClickType.NEGATIVE);
        }
        dialog.dismiss();
        chainTask.finish();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.f68710a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        if (view != null) {
            final PermissionBuilder permissionBuilder = this.this$0;
            final RationaleDialog rationaleDialog = this.$dialog;
            final boolean z11 = this.$showReasonOrGoSettings;
            final c cVar = this.$chainTask;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.permissionx.guolindev.request.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PermissionBuilder$showHandlePermissionDialog$2.b(permissionBuilder, rationaleDialog, z11, cVar, view2);
                }
            });
        }
    }
}
