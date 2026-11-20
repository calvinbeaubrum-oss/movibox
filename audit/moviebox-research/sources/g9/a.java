package g9;

import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public abstract class a {

    /* JADX INFO: renamed from: g9.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class C0685a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f65462a;

        static {
            int[] iArr = new int[LoadMoreStatus.values().length];
            try {
                iArr[LoadMoreStatus.Complete.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadMoreStatus.Loading.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoadMoreStatus.Fail.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LoadMoreStatus.End.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f65462a = iArr;
        }
    }

    private final void isVisible(View view, boolean z11) {
        view.setVisibility(z11 ? 0 : 8);
    }

    public void convert(BaseViewHolder holder, int i11, LoadMoreStatus loadMoreStatus) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(loadMoreStatus, "loadMoreStatus");
        int i12 = C0685a.f65462a[loadMoreStatus.ordinal()];
        if (i12 == 1) {
            isVisible(getLoadingView(holder), false);
            isVisible(getLoadComplete(holder), true);
            isVisible(getLoadFailView(holder), false);
            isVisible(getLoadEndView(holder), false);
            return;
        }
        if (i12 == 2) {
            isVisible(getLoadingView(holder), true);
            isVisible(getLoadComplete(holder), false);
            isVisible(getLoadFailView(holder), false);
            isVisible(getLoadEndView(holder), false);
            return;
        }
        if (i12 == 3) {
            isVisible(getLoadingView(holder), false);
            isVisible(getLoadComplete(holder), false);
            isVisible(getLoadFailView(holder), true);
            isVisible(getLoadEndView(holder), false);
            return;
        }
        if (i12 != 4) {
            return;
        }
        isVisible(getLoadingView(holder), false);
        isVisible(getLoadComplete(holder), false);
        isVisible(getLoadFailView(holder), false);
        isVisible(getLoadEndView(holder), true);
    }

    public abstract View getLoadComplete(BaseViewHolder baseViewHolder);

    public abstract View getLoadEndView(BaseViewHolder baseViewHolder);

    public abstract View getLoadFailView(BaseViewHolder baseViewHolder);

    public abstract View getLoadingView(BaseViewHolder baseViewHolder);

    public abstract View getRootView(ViewGroup viewGroup);
}
