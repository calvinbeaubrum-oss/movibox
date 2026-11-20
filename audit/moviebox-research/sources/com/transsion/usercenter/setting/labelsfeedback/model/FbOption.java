package com.transsion.usercenter.setting.labelsfeedback.model;

import android.content.Context;
import com.blankj.utilcode.util.n;
import com.google.gson.annotations.SerializedName;
import com.tencent.mmkv.MMKV;
import com.transsion.usercenter.R$string;
import java.io.Serializable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.g;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class FbOption implements Serializable {
    public static final a Companion = new a(null);
    private static final Lazy<MMKV> mmkv$delegate = LazyKt__LazyJVMKt.b(new Function0<MMKV>() { // from class: com.transsion.usercenter.setting.labelsfeedback.model.FbOption$Companion$mmkv$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MMKV invoke() {
            return MMKV.z("feedback_mmkv");
        }
    });

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("labelId")
    private int f59744id;

    @SerializedName("labelName")
    private String name;
    private List<FbOption> options;
    private Integer selectedIndex;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<FbOption> a(Context context) {
            Intrinsics.g(context, "context");
            FbOptionList fbOptionListB = b();
            if (fbOptionListB != null) {
                return fbOptionListB.getLabelList();
            }
            String string = context.getString(R$string.feedback_viewing_experience);
            Intrinsics.f(string, "context.getString(R.stri…dback_viewing_experience)");
            String string2 = context.getString(R$string.feedback_subtitls);
            Intrinsics.f(string2, "context.getString(R.string.feedback_subtitls)");
            String string3 = context.getString(R$string.feedback_download);
            Intrinsics.f(string3, "context.getString(R.string.feedback_download)");
            String string4 = context.getString(R$string.feedback_file_management);
            Intrinsics.f(string4, "context.getString(R.stri…feedback_file_management)");
            String string5 = context.getString(R$string.feedback_copyright);
            Intrinsics.f(string5, "context.getString(R.string.feedback_copyright)");
            String string6 = context.getString(R$string.feedback_pornographic_content);
            Intrinsics.f(string6, "context.getString(R.stri…ack_pornographic_content)");
            String string7 = context.getString(R$string.other);
            Intrinsics.f(string7, "context.getString(R.string.other)");
            return g.o(new FbOption(1, string), new FbOption(2, string2), new FbOption(3, string3), new FbOption(4, string4), new FbOption(6, string5), new FbOption(7, string6), new FbOption(5, string7));
        }

        public final FbOptionList b() {
            String strF = c().f("LAST_SERVER_OPTION");
            if (strF == null) {
                strF = "";
            }
            try {
                return (FbOptionList) n.d(strF, FbOptionList.class);
            } catch (Exception e11) {
                e11.printStackTrace();
                return null;
            }
        }

        public final MMKV c() {
            Object value = FbOption.mmkv$delegate.getValue();
            Intrinsics.f(value, "<get-mmkv>(...)");
            return (MMKV) value;
        }

        public final void d(FbOptionList fbOptionList) {
            if (fbOptionList != null) {
                try {
                    FbOption.Companion.c().p("LAST_SERVER_OPTION", n.j(fbOptionList));
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        }
    }

    public FbOption() {
        this.name = "";
        this.options = g.l();
    }

    public FbOption(int i11, String name) {
        Intrinsics.g(name, "name");
        this.name = "";
        this.options = g.l();
        this.f59744id = i11;
        this.name = name;
    }

    public final int getId() {
        return this.f59744id;
    }

    public final String getName() {
        return this.name;
    }

    public final List<FbOption> getOptions() {
        return this.options;
    }

    public final Integer getSelectedIndex() {
        return this.selectedIndex;
    }

    public final void setId(int i11) {
        this.f59744id = i11;
    }

    public final void setName(String str) {
        Intrinsics.g(str, "<set-?>");
        this.name = str;
    }

    public final void setOptions(List<FbOption> list) {
        Intrinsics.g(list, "<set-?>");
        this.options = list;
    }

    public final void setSelectedIndex(Integer num) {
        this.selectedIndex = num;
    }
}
