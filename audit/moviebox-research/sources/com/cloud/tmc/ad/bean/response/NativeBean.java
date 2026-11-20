package com.cloud.tmc.ad.bean.response;

import com.cloud.tmc.integration.R$string;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rc.b;
import ws.a;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class NativeBean extends b {
    private final ButtonDTO button;
    private final DescriptDTO descript;
    private final LogoDTO logo;
    private final List<MainImagesDTO> mainImages;
    private final Integer rating;
    private final TitleDTO title;
    private final String version;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class ButtonDTO implements Serializable {
        private final String text;

        public final String getText() {
            String str = this.text;
            return str == null ? "" : str;
        }

        public String toString() {
            return "ButtonDTO{text='" + this.text + "'}";
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class DescriptDTO implements Serializable {
        private final String text;

        public final String getText() {
            String str = this.text;
            return str == null ? "" : str;
        }

        public String toString() {
            return "DescriptDTO{text='" + this.text + "'}";
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class LogoDTO implements Serializable {
        private final Integer height;
        private final String url;
        private final Integer width;

        public final int getHeight() {
            Integer num = this.height;
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }

        public final String getUrl() {
            String str = this.url;
            return str == null ? "" : str;
        }

        public final int getWidth() {
            Integer num = this.width;
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }

        public String toString() {
            return "LogoDTO{url='" + this.url + "', width=" + this.width + ", height=" + this.height + '}';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class MainImagesDTO implements Serializable {
        private final Integer height;
        private final String url;
        private final Integer width;

        public final int getHeight() {
            Integer num = this.height;
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }

        public final String getUrl() {
            String str = this.url;
            return str == null ? "" : str;
        }

        public final int getWidth() {
            Integer num = this.width;
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }

        public String toString() {
            return "MainImagesDTO{url='" + this.url + "', width=" + this.width + ", height=" + this.height + '}';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class TitleDTO implements Serializable {
        private final String text;

        public final String getText() {
            String str = this.text;
            return str == null ? "" : str;
        }

        public String toString() {
            return "TitleDTO{text='" + this.text + "'}";
        }
    }

    public final String getButtonText() {
        String text;
        ButtonDTO buttonDTO = this.button;
        return (buttonDTO == null || (text = buttonDTO.getText()) == null) ? "" : text;
    }

    public final String getButtonTxt(int i11) {
        String text;
        if (i11 == 2) {
            String string = a.a().getResources().getString(R$string.open);
            Intrinsics.f(string, "getContext()\n           ….getString(R.string.open)");
            return string;
        }
        if (i11 != 3) {
            ButtonDTO buttonDTO = this.button;
            return (buttonDTO == null || (text = buttonDTO.getText()) == null) ? "" : text;
        }
        String string2 = a.a().getResources().getString(R$string.install);
        Intrinsics.f(string2, "getContext()\n           …tString(R.string.install)");
        return string2;
    }

    public final String getDescriptionTxt() {
        String text;
        DescriptDTO descriptDTO = this.descript;
        return (descriptDTO == null || (text = descriptDTO.getText()) == null) ? "" : text;
    }

    public final LogoDTO getLogo() {
        return this.logo;
    }

    public final String getLogoUrl() {
        String url;
        LogoDTO logoDTO = this.logo;
        return (logoDTO == null || (url = logoDTO.getUrl()) == null) ? "" : url;
    }

    public final List<MainImagesDTO> getMainImages() {
        return this.mainImages;
    }

    public final int getRating() {
        Integer num = this.rating;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final String getTitleTxt() {
        String text;
        TitleDTO titleDTO = this.title;
        return (titleDTO == null || (text = titleDTO.getText()) == null) ? "" : text;
    }

    public final String getVersion() {
        String str = this.version;
        return str == null ? "" : str;
    }

    public String toString() {
        return "NativeBean{version='" + this.version + "', rating=" + this.rating + ", title=" + this.title + ", descript=" + this.descript + ", button=" + this.button + ", logo=" + this.logo + ", mainImages=" + this.mainImages + '}';
    }
}
