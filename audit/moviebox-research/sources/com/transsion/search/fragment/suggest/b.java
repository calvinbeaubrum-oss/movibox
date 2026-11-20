package com.transsion.search.fragment.suggest;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.transsion.search.bean.SuggestEntity;
import hx.c;
import hx.d;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class b extends BaseProviderMultiAdapter<SuggestEntity> {
    public static final a J = new a(null);
    public String I;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CharSequence a(String mKeyWord, String str) {
            String str2;
            Intrinsics.g(mKeyWord, "mKeyWord");
            try {
                Result.Companion companion = Result.Companion;
                Locale locale = Locale.ROOT;
                String upperCase = mKeyWord.toUpperCase(locale);
                Intrinsics.f(upperCase, "toUpperCase(...)");
                if (str != null) {
                    String upperCase2 = str.toUpperCase(locale);
                    Intrinsics.f(upperCase2, "toUpperCase(...)");
                    str2 = upperCase2 == null ? "" : upperCase2;
                }
                int length = upperCase.length() - 1;
                int i11 = 0;
                boolean z11 = false;
                while (i11 <= length) {
                    boolean z12 = Intrinsics.i(upperCase.charAt(!z11 ? i11 : length), 32) <= 0;
                    if (z11) {
                        if (!z12) {
                            break;
                        }
                        length--;
                    } else if (z12) {
                        i11++;
                    } else {
                        z11 = true;
                    }
                }
                if (upperCase.subSequence(i11, length + 1).toString().length() == 0 || !StringsKt__StringsKt.Q(str2, upperCase, false, 2, null)) {
                    return str;
                }
                int iD0 = StringsKt__StringsKt.d0(str2, upperCase, 0, false, 6, null);
                int length2 = upperCase.length() + iD0;
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) str);
                if (length2 != 0 && iD0 != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#10A84D")), iD0, length2, 33);
                }
                return spannableStringBuilder;
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th2));
                return "";
            }
        }
    }

    public b() {
        super(null, 1, null);
        K0(new d());
        K0(new hx.b());
        K0(new c());
        K0(new hx.a());
        this.I = "";
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int S0(List<? extends SuggestEntity> data, int i11) {
        Intrinsics.g(data, "data");
        Integer type = data.get(i11).getType();
        if (type != null && type.intValue() == 2) {
            return 2;
        }
        if (type != null && type.intValue() == 1) {
            return 1;
        }
        return ((type != null && type.intValue() == 0) || type == null || type.intValue() != 3) ? 0 : 3;
    }

    public final String V0() {
        return this.I;
    }

    public final void W0(String keyWord) {
        Intrinsics.g(keyWord, "keyWord");
        this.I = keyWord;
    }
}
