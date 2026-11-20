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
public final class BrandInWhitelistHandler extends a {
    /* JADX WARN: Code duplicated, block: B:31:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001d  */
    @Override // com.transsion.ad.monopoly.intercept.a
    public Object b(String str, MbAdDbPlans mbAdDbPlans, Map<String, ? extends Object> map, Continuation<? super AdPlansHitResponse> continuation) throws Throwable {
        BrandInWhitelistHandler$doHandle$1 brandInWhitelistHandler$doHandle$1;
        BrandInWhitelistHandler brandInWhitelistHandler;
        BrandInWhitelistHandler brandInWhitelistHandler2;
        AdPlansHitResponse adPlansHitResponse;
        AdPlansHitResponse adPlansHitResponse2;
        if (continuation instanceof BrandInWhitelistHandler$doHandle$1) {
            brandInWhitelistHandler$doHandle$1 = (BrandInWhitelistHandler$doHandle$1) continuation;
            int i11 = brandInWhitelistHandler$doHandle$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                brandInWhitelistHandler$doHandle$1.label = i11 - Integer.MIN_VALUE;
            } else {
                brandInWhitelistHandler$doHandle$1 = new BrandInWhitelistHandler$doHandle$1(this, continuation);
            }
        } else {
            brandInWhitelistHandler$doHandle$1 = new BrandInWhitelistHandler$doHandle$1(this, continuation);
        }
        Object objB = brandInWhitelistHandler$doHandle$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = brandInWhitelistHandler$doHandle$1.label;
        if (i12 != 0) {
            if (i12 == 1) {
                brandInWhitelistHandler = (BrandInWhitelistHandler) brandInWhitelistHandler$doHandle$1.L$0;
                ResultKt.b(objB);
                adPlansHitResponse = (AdPlansHitResponse) objB;
                if (adPlansHitResponse != null) {
                    return adPlansHitResponse;
                }
                return brandInWhitelistHandler.e();
            }
            if (i12 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            brandInWhitelistHandler2 = (BrandInWhitelistHandler) brandInWhitelistHandler$doHandle$1.L$0;
            ResultKt.b(objB);
            adPlansHitResponse2 = (AdPlansHitResponse) objB;
            if (adPlansHitResponse2 != null) {
                return adPlansHitResponse2;
            }
            return brandInWhitelistHandler2.e();
        }
        ResultKt.b(objB);
        String[] brandFromJson = (String[]) n.d(mbAdDbPlans != null ? mbAdDbPlans.getBrand() : null, String[].class);
        if (brandFromJson == null || brandFromJson.length == 0) {
            a aVarC = c();
            if (aVarC != null) {
                brandInWhitelistHandler$doHandle$1.L$0 = this;
                brandInWhitelistHandler$doHandle$1.label = 1;
                objB = aVarC.b(str, mbAdDbPlans, map, brandInWhitelistHandler$doHandle$1);
                if (objB == objE) {
                    return objE;
                }
                brandInWhitelistHandler = this;
                adPlansHitResponse = (AdPlansHitResponse) objB;
                if (adPlansHitResponse != null) {
                    return adPlansHitResponse;
                }
            } else {
                brandInWhitelistHandler = this;
            }
            return brandInWhitelistHandler.e();
        }
        String strC = TNDeviceHelper.f49455a.c();
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Intrinsics.f(brandFromJson, "brandFromJson");
        int length = brandFromJson.length;
        int i13 = 0;
        while (i13 < length) {
            String str2 = brandFromJson[i13];
            Locale locale = Locale.ROOT;
            String lowerCase = str2.toLowerCase(locale);
            Intrinsics.f(lowerCase, "toLowerCase(...)");
            String[] strArr = brandFromJson;
            String lowerCase2 = strC.toLowerCase(locale);
            Intrinsics.f(lowerCase2, "toLowerCase(...)");
            Object obj = objE;
            int i14 = length;
            if (StringsKt__StringsKt.Q(lowerCase, lowerCase2, false, 2, null)) {
                booleanRef.element = true;
            } else {
                String lowerCase3 = strC.toLowerCase(locale);
                Intrinsics.f(lowerCase3, "toLowerCase(...)");
                String lowerCase4 = str2.toLowerCase(locale);
                Intrinsics.f(lowerCase4, "toLowerCase(...)");
                if (StringsKt__StringsKt.Q(lowerCase3, lowerCase4, false, 2, null)) {
                    booleanRef.element = true;
                }
            }
            i13++;
            objE = obj;
            brandFromJson = strArr;
            length = i14;
        }
        Object obj2 = objE;
        if (!booleanRef.element) {
            return new AdPlansHitResponse(false, "当前手机品牌不在白名单中");
        }
        a aVarC2 = c();
        if (aVarC2 != null) {
            brandInWhitelistHandler$doHandle$1.L$0 = this;
            brandInWhitelistHandler$doHandle$1.label = 2;
            objB = aVarC2.b(str, mbAdDbPlans, map, brandInWhitelistHandler$doHandle$1);
            if (objB == obj2) {
                return obj2;
            }
            brandInWhitelistHandler2 = this;
            adPlansHitResponse2 = (AdPlansHitResponse) objB;
            if (adPlansHitResponse2 != null) {
                return adPlansHitResponse2;
            }
        } else {
            brandInWhitelistHandler2 = this;
        }
        return brandInWhitelistHandler2.e();
    }
}
