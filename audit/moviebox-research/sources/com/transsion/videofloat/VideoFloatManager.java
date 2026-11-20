package com.transsion.videofloat;

import androidx.fragment.app.FragmentActivity;
import com.transsion.player.orplayer.f;
import com.transsion.videofloat.manager.VideoFloatManagerImp;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

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
public interface VideoFloatManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f60019a = Companion.f60020a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f60020a = new Companion();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f60021b = "pip_permission_dialog";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f60022c = "key_video_float_permission";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Lazy<VideoFloatManagerImp> f60023d = LazyKt__LazyJVMKt.b(new Function0<VideoFloatManagerImp>() { // from class: com.transsion.videofloat.VideoFloatManager$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final VideoFloatManagerImp invoke() {
                return new VideoFloatManagerImp();
            }
        });

        public final String a() {
            return f60022c;
        }

        public final VideoFloatManager b() {
            return f60023d.getValue();
        }

        public final String c() {
            return f60021b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public static /* synthetic */ void a(VideoFloatManager videoFloatManager, boolean z11, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopFloat");
            }
            if ((i11 & 1) != 0) {
                z11 = true;
            }
            videoFloatManager.f(z11);
        }
    }

    boolean a(String str);

    void b(FragmentActivity fragmentActivity, String str, String str2);

    boolean c(f fVar);

    void d();

    void e(FragmentActivity fragmentActivity, vz.a aVar, boolean z11, boolean z12, Function1<? super Boolean, Unit> function1, yz.a aVar2);

    void f(boolean z11);

    boolean isPlaying();
}
