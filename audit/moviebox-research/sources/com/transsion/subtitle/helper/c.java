package com.transsion.subtitle.helper;

import android.os.Build;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.download.SubtitleBean;
import com.transsion.baselib.db.download.SubtitleLanguageMapBean;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

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
@Metadata
public final class c {
    public static final Locale a() {
        String string = RoomAppMMKV.f51271a.a().getString("k_language_short_name", null);
        Locale locale = Build.VERSION.SDK_INT >= 24 ? Utils.a().getResources().getConfiguration().getLocales().get(0) : Utils.a().getResources().getConfiguration().locale;
        if (!Intrinsics.b(locale.getLanguage(), string) && string != null && string.length() > 0) {
            return new Locale(string, locale.getCountry());
        }
        Intrinsics.f(locale, "{\n        locale\n    }");
        return locale;
    }

    public static final String b(vx.a aVar) {
        SubtitleDownloadTable subtitleDownloadTableB;
        String fileCharsetName;
        if (aVar != null && (subtitleDownloadTableB = aVar.b()) != null && (fileCharsetName = subtitleDownloadTableB.getFileCharsetName()) != null) {
            return fileCharsetName;
        }
        String strName = Charsets.f69091b.name();
        Intrinsics.f(strName, "UTF_8.name()");
        return strName;
    }

    public static final boolean c(String language, List<SubtitleBean> list) {
        String upperCase;
        Intrinsics.g(language, "language");
        Intrinsics.g(list, "list");
        Iterator<SubtitleBean> it = list.iterator();
        while (it.hasNext()) {
            String lan = it.next().getLan();
            if (lan != null) {
                upperCase = lan.toUpperCase(Locale.ROOT);
                Intrinsics.f(upperCase, "toUpperCase(...)");
            } else {
                upperCase = null;
            }
            String upperCase2 = language.toUpperCase(Locale.ROOT);
            Intrinsics.f(upperCase2, "toUpperCase(...)");
            if (Intrinsics.b(upperCase, upperCase2)) {
                return true;
            }
        }
        return false;
    }

    public static final void d(List<SubtitleLanguageMapBean> list) {
        Intrinsics.g(list, "list");
        Locale locale = Build.VERSION.SDK_INT >= 24 ? Utils.a().getResources().getConfiguration().getLocales().get(0) : Utils.a().getResources().getConfiguration().locale;
        int size = list.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                i11 = -1;
                break;
            }
            SubtitleLanguageMapBean subtitleLanguageMapBean = list.get(i11);
            if (Intrinsics.b(Intrinsics.b(subtitleLanguageMapBean.getLan(), "in_id") ? "in" : subtitleLanguageMapBean.getLan(), locale.getLanguage())) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 > 0) {
            list.add(0, list.remove(i11));
        }
    }
}
