package com.transsion.ad.monopoly.intercept;

import com.blankj.utilcode.util.n;
import com.tn.lib.util.device.TNDeviceHelper;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdPlansHitResponse;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;

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
@SourceDebugExtension
public final class InDenyModelHandler extends a {
    /* JADX WARN: Code duplicated, block: B:29:0x009c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    @Override // com.transsion.ad.monopoly.intercept.a
    public Object b(String str, MbAdDbPlans mbAdDbPlans, Map<String, ? extends Object> map, Continuation<? super AdPlansHitResponse> continuation) throws Throwable {
        InDenyModelHandler$doHandle$1 inDenyModelHandler$doHandle$1;
        InDenyModelHandler inDenyModelHandler;
        if (continuation instanceof InDenyModelHandler$doHandle$1) {
            inDenyModelHandler$doHandle$1 = (InDenyModelHandler$doHandle$1) continuation;
            int i11 = inDenyModelHandler$doHandle$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                inDenyModelHandler$doHandle$1.label = i11 - Integer.MIN_VALUE;
            } else {
                inDenyModelHandler$doHandle$1 = new InDenyModelHandler$doHandle$1(this, continuation);
            }
        } else {
            inDenyModelHandler$doHandle$1 = new InDenyModelHandler$doHandle$1(this, continuation);
        }
        Object objB = inDenyModelHandler$doHandle$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = inDenyModelHandler$doHandle$1.label;
        if (i12 == 0) {
            ResultKt.b(objB);
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            String strK = TNDeviceHelper.f49455a.k();
            String[] denyModelFromJson = (String[]) n.d(mbAdDbPlans != null ? mbAdDbPlans.getDenyModel() : null, String[].class);
            if (denyModelFromJson == null || denyModelFromJson.length == 0) {
                booleanRef.element = false;
            } else {
                Intrinsics.f(denyModelFromJson, "denyModelFromJson");
                int length = denyModelFromJson.length;
                int i13 = 0;
                while (i13 < length) {
                    String str2 = denyModelFromJson[i13];
                    Locale locale = Locale.ROOT;
                    String lowerCase = str2.toLowerCase(locale);
                    Intrinsics.f(lowerCase, "toLowerCase(...)");
                    String lowerCase2 = strK.toLowerCase(locale);
                    Intrinsics.f(lowerCase2, "toLowerCase(...)");
                    String[] strArr = denyModelFromJson;
                    if (StringsKt__StringsKt.Q(lowerCase, lowerCase2, false, 2, null)) {
                        booleanRef.element = true;
                    } else {
                        String lowerCase3 = strK.toLowerCase(locale);
                        Intrinsics.f(lowerCase3, "toLowerCase(...)");
                        String lowerCase4 = str2.toLowerCase(locale);
                        Intrinsics.f(lowerCase4, "toLowerCase(...)");
                        if (StringsKt__StringsKt.Q(lowerCase3, lowerCase4, false, 2, null)) {
                            booleanRef.element = true;
                        }
                    }
                    i13++;
                    denyModelFromJson = strArr;
                }
            }
            if (booleanRef.element) {
                return new AdPlansHitResponse(false, "当前手机机型在黑名单中");
            }
            a aVarC = c();
            if (aVarC != null) {
                inDenyModelHandler$doHandle$1.L$0 = this;
                inDenyModelHandler$doHandle$1.label = 1;
                objB = aVarC.b(str, mbAdDbPlans, map, inDenyModelHandler$doHandle$1);
                if (objB == objE) {
                    return objE;
                }
                inDenyModelHandler = this;
            } else {
                inDenyModelHandler = this;
            }
            return inDenyModelHandler.e();
        }
        if (i12 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        inDenyModelHandler = (InDenyModelHandler) inDenyModelHandler$doHandle$1.L$0;
        ResultKt.b(objB);
        AdPlansHitResponse adPlansHitResponse = (AdPlansHitResponse) objB;
        if (adPlansHitResponse != null) {
            return adPlansHitResponse;
        }
        return inDenyModelHandler.e();
    }
}
