package pz;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blankj.utilcode.util.d0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.videodetail.R$id;
import com.transsion.videodetail.bean.VideoDetailMediaSource;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class b extends BaseQuickAdapter<VideoDetailMediaSource, BaseViewHolder> {
    public final int H;
    public final boolean I;
    public VideoDetailMediaSource J;
    public boolean K;
    public boolean L;
    public final int M;
    public final int N;

    public b(int i11, boolean z11, int i12) {
        super(i12, null, 2, null);
        this.H = i11;
        this.I = z11;
        this.K = i11 == SubjectType.MOVIE.getValue();
        this.L = i11 == SubjectType.EDUCATION.getValue();
        this.N = gs.a.a(8);
        this.M = Math.min(d0.e(), d0.c());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, VideoDetailMediaSource item) {
        VideoDetailMediaSource videoDetailMediaSource;
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        if (this.I || (this.K && getItemCount() > 1)) {
            ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
            int i11 = this.M;
            int i12 = this.N;
            layoutParams.width = ((i11 - (i12 * 6)) / 6) - i12;
        }
        VideoDetailMediaSource videoDetailMediaSource2 = this.J;
        J0(holder, videoDetailMediaSource2 != null && videoDetailMediaSource2.getSe() == item.getSe() && (videoDetailMediaSource = this.J) != null && videoDetailMediaSource.getEp() == item.getEp());
        TextUtils.TruncateAt truncateAt = null;
        if (this.L) {
            String str = new DecimalFormat("00").format(Integer.valueOf(item.getEp()));
            TextView textView = (TextView) holder.getView(R$id.tvName);
            textView.setEllipsize(str.length() > 20 ? TextUtils.TruncateAt.MIDDLE : null);
            textView.setText(str);
            GradientTextView gradientTextView = (GradientTextView) holder.getView(R$id.tvNameSelected);
            gradientTextView.setEllipsize(str.length() > 20 ? TextUtils.TruncateAt.MIDDLE : null);
            gradientTextView.setText(str);
        } else {
            TextView textView2 = (TextView) holder.getView(R$id.tvName);
            String name = item.getName();
            textView2.setEllipsize((name == null || name.length() <= 20) ? null : TextUtils.TruncateAt.MIDDLE);
            String name2 = item.getName();
            if (name2 == null) {
                name2 = "";
            }
            textView2.setText(name2);
            GradientTextView gradientTextView2 = (GradientTextView) holder.getView(R$id.tvNameSelected);
            String name3 = item.getName();
            if (name3 != null && name3.length() > 20) {
                truncateAt = TextUtils.TruncateAt.MIDDLE;
            }
            gradientTextView2.setEllipsize(truncateAt);
            String name4 = item.getName();
            gradientTextView2.setText(name4 != null ? name4 : "");
        }
        View view = holder.getView(R$id.iv_download_status);
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 0) {
            view.setRotationY(0.0f);
        } else {
            view.setRotationY(180.0f);
        }
        view.setVisibility(item.getDownloadBean() != null ? 0 : 8);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public void y(BaseViewHolder holder, VideoDetailMediaSource item, List<? extends Object> payloads) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        Intrinsics.g(payloads, "payloads");
        super.y(holder, item, payloads);
        if (item.getSe() == 0) {
            item.getEp();
        }
        J0(holder, Intrinsics.b(this.J, item));
    }

    public final void I0(VideoDetailMediaSource videoDetailMediaSource) {
        this.J = videoDetailMediaSource;
        notifyDataSetChanged();
    }

    public final void J0(BaseViewHolder baseViewHolder, boolean z11) {
        baseViewHolder.itemView.setSelected(z11);
        baseViewHolder.getView(R$id.tvName).setVisibility(z11 ^ true ? 0 : 8);
        baseViewHolder.getView(R$id.tvNameSelected).setVisibility(z11 ? 0 : 8);
    }

    public final void K0(VideoDetailMediaSource videoDetailMediaSource) {
        int i11;
        if (Intrinsics.b(this.J, videoDetailMediaSource) || videoDetailMediaSource == null) {
            return;
        }
        int i12 = 0;
        int i13 = -1;
        if (this.J == null) {
            i11 = -1;
            break;
        }
        Iterator<VideoDetailMediaSource> it = D().iterator();
        i11 = 0;
        while (true) {
            if (!it.hasNext()) {
                i11 = -1;
                break;
            } else if (Intrinsics.b(it.next(), this.J)) {
                break;
            } else {
                i11++;
            }
        }
        this.J = videoDetailMediaSource;
        if (i11 >= 0) {
            notifyItemChanged(i11, videoDetailMediaSource);
        }
        Iterator<VideoDetailMediaSource> it2 = D().iterator();
        while (it2.hasNext()) {
            if (Intrinsics.b(it2.next(), videoDetailMediaSource)) {
                i13 = i12;
                break;
            }
            i12++;
        }
        if (i13 >= 0) {
            notifyItemChanged(i13, videoDetailMediaSource);
        }
    }
}
