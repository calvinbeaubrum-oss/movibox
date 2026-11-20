package com.transsion.transfer;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.u;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.transsion.transfer.itransfer.ITransferApi;
import com.transsion.transfer.wifi.ui.WifiConnectActivity;
import com.transsion.transfer.wifi.ui.WifiCreateActivity;
import com.transsion.transfer.wifi.util.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.mvel2.ast.ASTNode;

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
/* JADX INFO: loaded from: classes8.dex */
@Route(path = "/transfer/transfer_provider")
@Metadata
public final class TransferProvider implements ITransferApi {
    private final String z1() {
        String simpleName = TransferProvider.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.transfer.itransfer.ITransferApi
    public void F0(u ctx) {
        Intrinsics.g(ctx, "ctx");
        Activity activity = (Activity) ctx;
        Intent intent = new Intent(activity, (Class<?>) WifiCreateActivity.class);
        intent.addFlags(ASTNode.DEOP);
        activity.startActivity(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.transfer.itransfer.ITransferApi
    public void J0(u ctx) {
        Intrinsics.g(ctx, "ctx");
        Activity activity = (Activity) ctx;
        Intent intent = new Intent(activity, (Class<?>) WifiConnectActivity.class);
        if (ctx instanceof Application) {
            intent.addFlags(ASTNode.DEOP);
        }
        activity.startActivity(intent);
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
        g.h(g.f59252a, z1() + " --> init()", false, 2, null);
    }
}
