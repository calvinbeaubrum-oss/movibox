package com.transsion.videofloat;

import android.app.PictureInPictureParams;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;
import com.transsion.player.orplayer.f;
import com.transsion.videofloat.bean.FloatActionType;
import com.transsion.videofloat.manager.VideoPipManagerImp;
import com.vungle.warren.error.VungleException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
public interface VideoPipManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f60024a = Companion.f60025a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f60025a = new Companion();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Lazy<VideoPipManagerImp> f60026b = LazyKt__LazyJVMKt.b(new Function0<VideoPipManagerImp>() { // from class: com.transsion.videofloat.VideoPipManager$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final VideoPipManagerImp invoke() {
                return new VideoPipManagerImp();
            }
        });

        public final VideoPipManager a() {
            return f60026b.getValue();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public static /* synthetic */ void a(VideoPipManager videoPipManager, boolean z11, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: closePip");
            }
            if ((i11 & 1) != 0) {
                z11 = true;
            }
            videoPipManager.d(z11);
        }

        public static /* synthetic */ PictureInPictureParams b(VideoPipManager videoPipManager, FragmentActivity fragmentActivity, boolean z11, boolean z12, ViewGroup viewGroup, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updatePictureInPictureParams");
            }
            if ((i11 & 4) != 0) {
                z12 = true;
            }
            if ((i11 & 8) != 0) {
                viewGroup = null;
            }
            return videoPipManager.i(fragmentActivity, z11, z12, viewGroup);
        }
    }

    boolean a(String str);

    boolean b();

    @RequiresApi(VungleException.WEB_CRASH)
    void c(FragmentActivity fragmentActivity, vz.a aVar);

    void d(boolean z11);

    void e();

    boolean f(f fVar);

    void g();

    boolean h();

    PictureInPictureParams i(FragmentActivity fragmentActivity, boolean z11, boolean z12, ViewGroup viewGroup);

    boolean isPlaying();

    void j(FragmentActivity fragmentActivity, vz.a aVar, FloatActionType floatActionType, boolean z11);

    boolean k();

    void onPipModeChanged(boolean z11);
}
