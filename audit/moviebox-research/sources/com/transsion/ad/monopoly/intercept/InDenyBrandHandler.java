package com.transsion.ad.monopoly.intercept;

import android.text.TextUtils;
import com.blankj.utilcode.util.n;
import com.tencent.mmkv.MMKV;
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
public final class InDenyBrandHandler extends a {
    /* JADX WARN: Code duplicated, block: B:38:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.ad.monopoly.intercept.a
    public Object b(String str, MbAdDbPlans mbAdDbPlans, Map<String, ? extends Object> map, Continuation<? super AdPlansHitResponse> continuation) throws Throwable {
        InDenyBrandHandler$doHandle$1 inDenyBrandHandler$doHandle$1;
        InDenyBrandHandler inDenyBrandHandler;
        String str2;
        String string;
        if (continuation instanceof InDenyBrandHandler$doHandle$1) {
            inDenyBrandHandler$doHandle$1 = (InDenyBrandHandler$doHandle$1) continuation;
            int i11 = inDenyBrandHandler$doHandle$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                inDenyBrandHandler$doHandle$1.label = i11 - Integer.MIN_VALUE;
            } else {
                inDenyBrandHandler$doHandle$1 = new InDenyBrandHandler$doHandle$1(this, continuation);
            }
        } else {
            inDenyBrandHandler$doHandle$1 = new InDenyBrandHandler$doHandle$1(this, continuation);
        }
        Object objB = inDenyBrandHandler$doHandle$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = inDenyBrandHandler$doHandle$1.label;
        if (i12 == 0) {
            ResultKt.b(objB);
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            String str3 = "";
            objectRef.element = "";
            String[] denyBrandFromJson = (String[]) n.d(mbAdDbPlans != null ? mbAdDbPlans.getDenyBrand() : null, String[].class);
            if (denyBrandFromJson == null || denyBrandFromJson.length == 0) {
                booleanRef.element = false;
            } else {
                MMKV mmkvC = ip.a.f67589a.c();
                if (mmkvC != null && (string = mmkvC.getString("phone_brand", "")) != null) {
                    str2 = str3;
                    str2 = str3;
                    str2 = string;
                }
                str2 = str3;
                str2 = str3;
                str2 = str3;
                boolean zIsEmpty = TextUtils.isEmpty(str2);
                T tC = str2;
                if (zIsEmpty) {
                    tC = TNDeviceHelper.f49455a.c();
                }
                objectRef.element = tC;
                Intrinsics.f(denyBrandFromJson, "denyBrandFromJson");
                int length = denyBrandFromJson.length;
                int i13 = 0;
                while (i13 < length) {
                    String str4 = denyBrandFromJson[i13];
                    Locale locale = Locale.ROOT;
                    String lowerCase = str4.toLowerCase(locale);
                    Intrinsics.f(lowerCase, "toLowerCase(...)");
                    String lowerCase2 = ((String) objectRef.element).toLowerCase(locale);
                    Intrinsics.f(lowerCase2, "toLowerCase(...)");
                    int i14 = length;
                    if (StringsKt__StringsKt.Q(lowerCase, lowerCase2, false, 2, null)) {
                        booleanRef.element = true;
                    } else {
                        String lowerCase3 = ((String) objectRef.element).toLowerCase(locale);
                        Intrinsics.f(lowerCase3, "toLowerCase(...)");
                        String lowerCase4 = str4.toLowerCase(locale);
                        Intrinsics.f(lowerCase4, "toLowerCase(...)");
                        if (StringsKt__StringsKt.Q(lowerCase3, lowerCase4, false, 2, null)) {
                            booleanRef.element = true;
                        }
                    }
                    i13++;
                    length = i14;
                }
            }
            if (booleanRef.element) {
                return new AdPlansHitResponse(false, "当前手机品牌在黑名单中");
            }
            a aVarC = c();
            if (aVarC != null) {
                inDenyBrandHandler$doHandle$1.L$0 = this;
                inDenyBrandHandler$doHandle$1.label = 1;
                objB = aVarC.b(str, mbAdDbPlans, map, inDenyBrandHandler$doHandle$1);
                if (objB == objE) {
                    return objE;
                }
                inDenyBrandHandler = this;
            } else {
                inDenyBrandHandler = this;
            }
            return inDenyBrandHandler.e();
        }
        if (i12 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        inDenyBrandHandler = (InDenyBrandHandler) inDenyBrandHandler$doHandle$1.L$0;
        ResultKt.b(objB);
        AdPlansHitResponse adPlansHitResponse = (AdPlansHitResponse) objB;
        if (adPlansHitResponse != null) {
            return adPlansHitResponse;
        }
        return inDenyBrandHandler.e();
    }
}
