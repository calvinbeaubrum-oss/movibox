package p2;

import android.os.LocaleList;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.text.platform.p;
import androidx.compose.ui.text.platform.q;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(api = 24)
@Metadata
public final class e implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LocaleList f73506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f73507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q f73508c = p.a();

    @Override // p2.j
    public i a() {
        LocaleList localeList = LocaleList.getDefault();
        synchronized (this.f73508c) {
            i iVar = this.f73507b;
            if (iVar != null && localeList == this.f73506a) {
                return iVar;
            }
            int size = localeList.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i11 = 0; i11 < size; i11++) {
                arrayList.add(new h(localeList.get(i11)));
            }
            i iVar2 = new i(arrayList);
            this.f73506a = localeList;
            this.f73507b = iVar2;
            return iVar2;
        }
    }

    @Override // p2.j
    public Locale b(String str) {
        Locale localeForLanguageTag = Locale.forLanguageTag(str);
        if (Intrinsics.b(localeForLanguageTag.toLanguageTag(), C.LANGUAGE_UNDETERMINED)) {
            Log.e(f.f73509a, "The language tag " + str + " is not well-formed. Locale is resolved to Undetermined. Note that underscore '_' is not a valid subtag delimiter and must be replaced with '-'.");
        }
        return localeForLanguageTag;
    }
}
