package ly;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.transfer.R$id;
import com.transsion.transfer.R$layout;
import com.transsion.transfer.R$mipmap;
import com.transsion.transfer.R$string;
import com.transsion.transfer.impl.entity.FileData;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.l;
import kotlinx.coroutines.k0;
import so.c;

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
public final class b extends BaseQuickAdapter<FileData, BaseViewHolder> {
    public final k0 H;
    public final boolean I;
    public Function1<? super FileData, Unit> J;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(k0 scope, boolean z11, CopyOnWriteArrayList<FileData> data) {
        super(R$layout.adapter_transfer_file_state, data);
        Intrinsics.g(scope, "scope");
        Intrinsics.g(data, "data");
        this.H = scope;
        this.I = z11;
    }

    public static final void I0(b this$0, FileData item, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(item, "$item");
        Function1<? super FileData, Unit> function1 = this$0.J;
        if (function1 != null) {
            function1.invoke(item);
        }
    }

    private final int L0() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? GravityCompat.END : GravityCompat.START;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, final FileData item) {
        String strJ0;
        String string;
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        ShapeableImageView shapeableImageView = (ShapeableImageView) holder.getView(R$id.file_image);
        if (!this.I) {
            File coverFile = item.getCoverFile();
            if (coverFile.exists()) {
                shapeableImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                com.transsion.baseui.image.a.a(shapeableImageView).load(coverFile).into(shapeableImageView);
            } else if (item.getCoverUrl().length() > 0 && l.L(item.getCoverUrl(), "/", false, 2, null) && new File(item.getCoverUrl()).exists()) {
                com.transsion.baseui.image.a.a(shapeableImageView).load(new File(item.getCoverUrl())).into(shapeableImageView);
            } else {
                shapeableImageView.setScaleType(ImageView.ScaleType.CENTER);
                shapeableImageView.setImageResource(R$mipmap.transfer_img_loading_error);
            }
        } else if (item.getCoverUrl().length() <= 0 || !new File(item.getCoverUrl()).exists()) {
            File coverFile2 = item.getCoverFile();
            if (coverFile2.exists()) {
                shapeableImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                com.transsion.baseui.image.a.a(shapeableImageView).load(coverFile2).into(shapeableImageView);
            } else {
                shapeableImageView.setScaleType(ImageView.ScaleType.CENTER);
                shapeableImageView.setImageResource(R$mipmap.transfer_img_loading_error);
            }
        } else {
            shapeableImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            if (l.L(item.getCoverUrl(), "/", false, 2, null)) {
                com.transsion.baseui.image.a.a(shapeableImageView).load(new File(item.getCoverUrl())).into(shapeableImageView);
            } else {
                com.transsion.baseui.image.a.a(shapeableImageView).load(item.getCoverUrl()).into(shapeableImageView);
            }
        }
        TextView textView = (TextView) holder.getView(R$id.file_name);
        textView.setText(item.getFileShowName());
        textView.setGravity(L0());
        TextView textView2 = (TextView) holder.getView(R$id.file_trans_ratio);
        if (item.getState() == 2) {
            strJ0 = J0(item.getDownloadSize()) + "/" + J0(item.getFileSize());
        } else {
            strJ0 = J0(item.getFileSize());
        }
        textView2.setText(strJ0);
        ProgressBar progressBar = (ProgressBar) holder.getView(R$id.file_trans_ratio_pb);
        progressBar.setProgress(K0(item));
        if (item.getState() == 4) {
            c.h(progressBar);
        } else {
            c.k(progressBar);
        }
        ImageView imageView = (ImageView) holder.getView(R$id.file_trans_retry);
        if (item.getState() == 3) {
            c.k(imageView);
        } else {
            c.h(imageView);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ly.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.I0(this.f70580a, item, view);
            }
        });
        TextView textView3 = (TextView) holder.getView(R$id.file_trans_state);
        int state = item.getState();
        if (state != 0) {
            switch (state) {
                case 2:
                    string = textView3.getContext().getString(this.I ? R$string.transfer_server_transferring : R$string.transfer_receiver_transferring);
                    break;
                case 3:
                    string = textView3.getContext().getString(R$string.transfer_fail);
                    break;
                case 4:
                    string = textView3.getContext().getString(R$string.transfer_finished);
                    break;
                case 5:
                    string = textView3.getContext().getString(R$string.transfer_disconnect);
                    break;
                case 6:
                    string = textView3.getContext().getString(R$string.transfer_no_file);
                    break;
                case 7:
                    string = textView3.getContext().getString(R$string.transfer_space_limit);
                    break;
                default:
                    string = textView3.getContext().getString(R$string.transfer_connecting);
                    break;
            }
        } else {
            string = textView3.getContext().getString(R$string.transfer_connecting);
        }
        textView3.setText(string);
        int state2 = item.getState();
        String str = "#2ADC66";
        if (state2 != 0) {
            switch (state2) {
                case 3:
                case 5:
                case 6:
                case 7:
                    str = "#F03930";
                    break;
                case 4:
                    str = "#8E8E8E";
                    break;
            }
        }
        textView3.setTextColor(Color.parseColor(str));
    }

    @SuppressLint({"DefaultLocale"})
    public final String J0(long j11) {
        double dE = kotlin.ranges.a.e(j11, 1L) / 1048576.0d;
        StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
        String str = String.format("%.1fMB", Arrays.copyOf(new Object[]{Double.valueOf(dE)}, 1));
        Intrinsics.f(str, "format(...)");
        return str;
    }

    @SuppressLint({"DefaultLocale"})
    public final int K0(FileData fileData) {
        try {
            return (int) ((kotlin.ranges.a.e(fileData.getDownloadSize(), 0L) / kotlin.ranges.a.e(fileData.getFileSize(), 1L)) * 100.0f);
        } catch (Exception unused) {
            return 0;
        }
    }

    public final void M0() {
        for (FileData fileData : D()) {
            if (fileData.getState() != 4) {
                fileData.setState(5);
            }
        }
        notifyDataSetChanged();
    }

    public final void N0(String filePath, FileData changeInfo) {
        Object next;
        Intrinsics.g(filePath, "filePath");
        Intrinsics.g(changeInfo, "changeInfo");
        Iterator<T> it = D().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.b(((FileData) next).getFileRemotePath(), filePath));
        FileData fileData = (FileData) next;
        if (fileData != null) {
            int iIndexOf = D().indexOf(fileData);
            FileData fileData2 = D().get(iIndexOf);
            fileData2.setState(changeInfo.getState());
            fileData2.setDownloadSize(changeInfo.getDownloadSize());
            fileData2.setFileSize(changeInfo.getFileSize());
            notifyItemChanged(iIndexOf);
        }
    }

    public final void O0(Function1<? super FileData, Unit> function1) {
        this.J = function1;
    }
}
