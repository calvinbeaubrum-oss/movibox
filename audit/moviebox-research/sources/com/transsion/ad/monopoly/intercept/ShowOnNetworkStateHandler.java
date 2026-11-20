package com.transsion.ad.monopoly.intercept;

import com.tn.lib.util.networkinfo.f;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdPlansHitResponse;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

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
public final class ShowOnNetworkStateHandler extends a {
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.transsion.ad.monopoly.intercept.a
    public Object b(String str, MbAdDbPlans mbAdDbPlans, Map<String, ? extends Object> map, Continuation<? super AdPlansHitResponse> continuation) throws Throwable {
        ShowOnNetworkStateHandler$doHandle$1 showOnNetworkStateHandler$doHandle$1;
        ShowOnNetworkStateHandler showOnNetworkStateHandler;
        if (continuation instanceof ShowOnNetworkStateHandler$doHandle$1) {
            showOnNetworkStateHandler$doHandle$1 = (ShowOnNetworkStateHandler$doHandle$1) continuation;
            int i11 = showOnNetworkStateHandler$doHandle$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                showOnNetworkStateHandler$doHandle$1.label = i11 - Integer.MIN_VALUE;
            } else {
                showOnNetworkStateHandler$doHandle$1 = new ShowOnNetworkStateHandler$doHandle$1(this, continuation);
            }
        } else {
            showOnNetworkStateHandler$doHandle$1 = new ShowOnNetworkStateHandler$doHandle$1(this, continuation);
        }
        Object objB = showOnNetworkStateHandler$doHandle$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = showOnNetworkStateHandler$doHandle$1.label;
        if (i12 == 0) {
            ResultKt.b(objB);
            Boolean boolG = g(mbAdDbPlans);
            boolean zE = f.f49475a.e();
            if (!zE ? boolG == null || Intrinsics.b(boolG, Boxing.a(false)) : boolG == null || Intrinsics.b(boolG, Boxing.a(true))) {
                return new AdPlansHitResponse(false, "当前网络状态 = " + zE + " -- isShowOnNetwork = " + boolG);
            }
            a aVarC = c();
            if (aVarC != null) {
                showOnNetworkStateHandler$doHandle$1.L$0 = this;
                showOnNetworkStateHandler$doHandle$1.label = 1;
                objB = aVarC.b(str, mbAdDbPlans, map, showOnNetworkStateHandler$doHandle$1);
                if (objB == objE) {
                    return objE;
                }
                showOnNetworkStateHandler = this;
            } else {
                showOnNetworkStateHandler = this;
            }
            return showOnNetworkStateHandler.e();
        }
        if (i12 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        showOnNetworkStateHandler = (ShowOnNetworkStateHandler) showOnNetworkStateHandler$doHandle$1.L$0;
        ResultKt.b(objB);
        AdPlansHitResponse adPlansHitResponse = (AdPlansHitResponse) objB;
        if (adPlansHitResponse != null) {
            return adPlansHitResponse;
        }
        return showOnNetworkStateHandler.e();
    }

    public final Boolean g(MbAdDbPlans mbAdDbPlans) {
        String extraConfig;
        if (mbAdDbPlans != null && (extraConfig = mbAdDbPlans.getExtraConfig()) != null) {
            try {
                String network = new JSONObject(extraConfig).getString("network");
                Intrinsics.f(network, "network");
                String lowerCase = network.toLowerCase(Locale.ROOT);
                Intrinsics.f(lowerCase, "toLowerCase(...)");
                return Boolean.valueOf(Intrinsics.b(lowerCase, "on"));
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
