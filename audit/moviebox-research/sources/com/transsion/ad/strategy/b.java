package com.transsion.ad.strategy;

import android.text.TextUtils;
import com.transsion.ad.monopoly.model.MbAdPlansBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;

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
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f50584a = new b();

    public final Map<String, Object> a(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (str == null) {
            str = "";
        }
        linkedHashMap.put("genre", str);
        return linkedHashMap;
    }

    public final String b() {
        String string = AdMmkv.f50558a.b().getString("ad_plan_genre", "");
        return string == null ? "" : string;
    }

    public final List<String> c() {
        ArrayList arrayList = new ArrayList();
        try {
            Result.Companion companion = Result.Companion;
            Iterator it = StringsKt__StringsKt.E0(b(), new String[]{","}, false, 0, 6, null).iterator();
            while (it.hasNext()) {
                String upperCase = ((String) it.next()).toUpperCase(Locale.ROOT);
                Intrinsics.f(upperCase, "toUpperCase(...)");
                arrayList.add(upperCase);
            }
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0065  */
    public final boolean d(Map<String, ? extends Object> map) {
        Object objM163constructorimpl;
        String str;
        String upperCase;
        List<String> arrayList;
        try {
            Result.Companion companion = Result.Companion;
            boolean zA = false;
            if (map != null) {
                Object obj = map.get("genre");
                String str2 = obj instanceof String ? (String) obj : null;
                if (str2 != null) {
                    String upperCase2 = str2.toUpperCase(Locale.ROOT);
                    Intrinsics.f(upperCase2, "toUpperCase(...)");
                    str = upperCase2;
                } else {
                    str = null;
                }
                String strF = str != null ? l.F(str, " ", "", false, 4, null) : null;
                List listE0 = strF != null ? StringsKt__StringsKt.E0(strF, new String[]{","}, false, 0, 6, null) : null;
                Object obj2 = map.get("channelId");
                String str3 = obj2 instanceof String ? (String) obj2 : null;
                if (str3 != null) {
                    upperCase = str3.toUpperCase(Locale.ROOT);
                    Intrinsics.f(upperCase, "toUpperCase(...)");
                    if (upperCase == null) {
                        upperCase = "";
                    }
                } else {
                    upperCase = "";
                }
                List listM0 = listE0 != null ? CollectionsKt___CollectionsKt.M0(listE0) : null;
                if (!TextUtils.isEmpty(upperCase) && listM0 != null) {
                    listM0.add(upperCase);
                }
                xq.i iVar = xq.i.f80680a;
                if (listM0 == null || (arrayList = CollectionsKt___CollectionsKt.M0(listM0)) == null) {
                    arrayList = new ArrayList<>();
                }
                zA = iVar.a(arrayList, f50584a.c());
            }
            objM163constructorimpl = Result.m163constructorimpl(Boolean.valueOf(zA));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            objM163constructorimpl = Boolean.FALSE;
        }
        return ((Boolean) objM163constructorimpl).booleanValue();
    }

    public final void e(MbAdPlansBean mbAdPlansBean) {
        AdMmkv.f50558a.b().putString("ad_plan_genre", mbAdPlansBean != null ? mbAdPlansBean.getGenre() : null);
        com.transsion.ad.a.b(com.transsion.ad.a.f50276a, b.class.getSimpleName() + " --> saveGenre() --> genre = " + (mbAdPlansBean != null ? mbAdPlansBean.getGenre() : null), false, 2, null);
    }
}
