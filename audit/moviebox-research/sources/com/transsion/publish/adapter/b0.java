package com.transsion.publish.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.publish.R$drawable;
import com.transsion.publish.R$layout;
import com.transsion.publish.R$string;
import com.transsion.publish.api.AudioEntity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class b0 extends RecyclerView.Adapter<c0> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FrameLayout.LayoutParams f56381j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public x f56382k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AudioEntity f56384m;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<AudioEntity> f56380i = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f56383l = (com.blankj.utilcode.util.d0.b() - (com.blankj.utilcode.util.f0.a(3.0f) * 5)) / 4;

    public b0() {
        int i11 = this.f56383l;
        this.f56381j = new FrameLayout.LayoutParams(i11, i11);
    }

    public static final void k(b0 this$0, AudioEntity info, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(info, "$info");
        if (this$0.i(info.getSize())) {
            zp.b.f82110a.e(Utils.a().getResources().getString(R$string.add_media_max_size_tips, 50));
            return;
        }
        if (info.getEnableSelect()) {
            Iterator<T> it = this$0.f56380i.iterator();
            while (it.hasNext()) {
                ((AudioEntity) it.next()).setEnableSelect(false);
            }
            info.setPlay(false);
            this$0.f56384m = null;
            this$0.notifyDataSetChanged();
            return;
        }
        Iterator<T> it2 = this$0.f56380i.iterator();
        while (it2.hasNext()) {
            ((AudioEntity) it2.next()).setEnableSelect(false);
        }
        info.setPlay(true);
        info.setEnableSelect(true);
        this$0.f56384m = info;
        x xVar = this$0.f56382k;
        if (xVar != null) {
            xVar.a(info);
        }
        this$0.notifyDataSetChanged();
    }

    public final void e(List<AudioEntity> data) {
        Intrinsics.g(data, "data");
        int size = this.f56380i.size();
        this.f56380i.addAll(data);
        notifyItemRangeInserted(size, data.size());
    }

    public final List<AudioEntity> f() {
        return this.f56380i;
    }

    public final AudioEntity g() {
        return this.f56384m;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f56380i.size();
    }

    public final String h(long j11) {
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(j11));
        BigDecimal bigDecimal2 = new BigDecimal("1024");
        double dDoubleValue = bigDecimal.divide(bigDecimal2, 1, 1).doubleValue();
        if (dDoubleValue < 1024.0d) {
            return dDoubleValue + "KB";
        }
        String string = new BigDecimal(dDoubleValue).divide(bigDecimal2, 1, 1).toString();
        Intrinsics.f(string, "BigDecimal(size).divide(…al.ROUND_DOWN).toString()");
        return string + "MB";
    }

    public final boolean i(long j11) {
        long j12 = 1024;
        long j13 = j11 / j12;
        return j13 >= 1024 && j13 / j12 >= 50;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c0 holder, int i11) {
        Intrinsics.g(holder, "holder");
        final AudioEntity audioEntity = this.f56380i.get(i11);
        holder.h().setText(audioEntity.getImageTitle());
        TextView textViewF = holder.f();
        String strH = h(audioEntity.getSize());
        Long duration = audioEntity.getDuration();
        textViewF.setText(strH + " " + TimeUtilKt.j((duration != null ? duration.longValue() : 0L) / ((long) 1000)));
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b0.k(this.f56374a, audioEntity, view);
            }
        });
        if (audioEntity.getEnableSelect()) {
            holder.g().setVisibility(0);
        } else {
            holder.g().setVisibility(8);
        }
        if (audioEntity.getPlay()) {
            holder.e().setImageResource(R$drawable.ic_audio_pause);
        } else {
            holder.e().setImageResource(R$drawable.ic_audio_play);
        }
        if (!i(audioEntity.getSize())) {
            holder.i().setVisibility(8);
        } else {
            holder.i().getBackground().mutate().setAlpha(178);
            holder.i().setVisibility(0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public c0 onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_select_music, parent, false);
        Intrinsics.f(view, "view");
        return new c0(view);
    }

    public final void m() {
        List<AudioEntity> list = this.f56380i;
        if (list != null) {
            for (AudioEntity audioEntity : list) {
                if (audioEntity.getPlay()) {
                    audioEntity.setPlay(false);
                }
            }
        }
        notifyDataSetChanged();
    }

    public final void n(x selectItemClickListener) {
        Intrinsics.g(selectItemClickListener, "selectItemClickListener");
        this.f56382k = selectItemClickListener;
    }
}
