package sz;

import android.graphics.drawable.Drawable;
import com.blankj.utilcode.util.Utils;
import com.transsion.videodetail.R$drawable;
import com.transsion.videodetail.music.bean.MusicLoopEnum;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f76641a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static MusicLoopEnum f76642b = MusicLoopEnum.NORMAL;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f76643a;

        static {
            int[] iArr = new int[MusicLoopEnum.values().length];
            try {
                iArr[MusicLoopEnum.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MusicLoopEnum.LIST_LOOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MusicLoopEnum.SINGLE_LOOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f76643a = iArr;
        }
    }

    public final Drawable a(MusicLoopEnum loop) {
        Intrinsics.g(loop, "loop");
        int i11 = a.f76643a[loop.ordinal()];
        if (i11 == 1) {
            return z2.a.getDrawable(Utils.a(), R$drawable.music_iv_loop_normal);
        }
        if (i11 == 2) {
            return z2.a.getDrawable(Utils.a(), R$drawable.music_iv_loop_list);
        }
        if (i11 == 3) {
            return z2.a.getDrawable(Utils.a(), R$drawable.music_iv_loop_single);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final MusicLoopEnum b() {
        return f76642b;
    }

    public final MusicLoopEnum c() {
        MusicLoopEnum musicLoopEnum;
        int i11 = a.f76643a[f76642b.ordinal()];
        if (i11 == 1) {
            musicLoopEnum = MusicLoopEnum.LIST_LOOP;
        } else if (i11 == 2) {
            musicLoopEnum = MusicLoopEnum.SINGLE_LOOP;
        } else {
            if (i11 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            musicLoopEnum = MusicLoopEnum.NORMAL;
        }
        f76642b = musicLoopEnum;
        return musicLoopEnum;
    }
}
