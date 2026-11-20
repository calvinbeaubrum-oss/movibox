package com.transsion.home.adapter.trending.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.u;
import androidx.lifecycle.v;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$drawable;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.R$mipmap;
import com.transsion.home.p003enum.HomeTabType;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.LiveListItem;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.TeamInfo;
import com.transsion.usercenter.R$string;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.q1;
import so.c;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class SportLiveAdapter extends BaseQuickAdapter<LiveListItem, SportLiveViewHolder> {
    public static final a N = new a(null);
    public static final int O = 8;
    public final OperateItem H;
    public final int I;
    public final boolean J;
    public final int K;
    public final int L;
    public final int M;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class SportLiveViewHolder extends BaseViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f52226b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public q1 f52227c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public LiveListItem f52228d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SportLiveViewHolder(View rootView) {
            super(rootView);
            Intrinsics.g(rootView, "rootView");
            this.f52226b = rootView;
        }

        public final String f(long j11) {
            int iK = TimeUtilKt.k(j11);
            if (iK == 0) {
                long jCurrentTimeMillis = j11 - System.currentTimeMillis();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(" · HH:mm:ss");
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
                h();
                String str = simpleDateFormat.format(Long.valueOf(jCurrentTimeMillis));
                Intrinsics.f(str, "format.format(timeInMillis)");
                return str;
            }
            if (iK < 0) {
                return "";
            }
            return " · " + this.f52226b.getContext().getResources().getString(iK == 1 ? R$string.user_day_left : R$string.user_days_left, Integer.valueOf(iK));
        }

        public final void g() {
            q1 q1Var = this.f52227c;
            if (q1Var != null) {
                q1.a.b(q1Var, null, 1, null);
            }
            this.f52227c = null;
        }

        public final void h() {
            LiveListItem liveListItem = this.f52228d;
            if (liveListItem != null) {
                if (Intrinsics.b(liveListItem != null ? liveListItem.getStatus() : null, "MatchIng")) {
                    return;
                }
                q1 q1Var = this.f52227c;
                if (q1Var != null) {
                    q1.a.b(q1Var, null, 1, null);
                }
                Object context = this.itemView.getContext();
                u uVar = context instanceof u ? (u) context : null;
                if (uVar == null) {
                    return;
                }
                this.f52227c = j.d(v.a(uVar), null, null, new SportLiveAdapter$SportLiveViewHolder$startCutDown$1(uVar, this, null), 3, null);
            }
        }

        @SuppressLint({"SetTextI18n"})
        public final void i(LiveListItem liveListItem) {
            if (liveListItem == null) {
                return;
            }
            this.f52228d = liveListItem;
            Long startTime = liveListItem.getStartTime();
            long jLongValue = startTime != null ? startTime.longValue() : 0L;
            TextView textView = (TextView) getView(R$id.main_op_sport_live_status_text);
            c.k(textView);
            long jCurrentTimeMillis = jLongValue - System.currentTimeMillis();
            if (liveListItem.getStartTime() == null || jCurrentTimeMillis > 0) {
                liveListItem.setStatus("MatchNotStart");
            } else {
                liveListItem.setStatus("MatchIng");
            }
            String status = liveListItem.getStatus();
            if (!Intrinsics.b(status, "MatchNotStart")) {
                if (!Intrinsics.b(status, "MatchIng")) {
                    c.h(textView);
                    return;
                } else {
                    textView.setText("");
                    textView.setBackgroundResource(R$mipmap.ic_op_sport_live_status);
                    return;
                }
            }
            textView.setText(this.f52226b.getContext().getString(com.transsion.home.R$string.sport_live_upcoming) + f(jLongValue));
            textView.setBackgroundResource(R$drawable.bg_corner_tips_rectangle_2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SportLiveAdapter(int i11, OperateItem operateItem, int i12, boolean z11) {
        super(i11, null, 2, null);
        Intrinsics.g(operateItem, "operateItem");
        this.H = operateItem;
        this.I = i12;
        this.J = z11;
        this.M = f0.a(30.0f);
        int i13 = z11 ? 3 : 2;
        int iA = f0.a(((((f0.b(kotlin.ranges.a.g(d0.e(), d0.c())) - 12) - (i13 * 8)) - 8) * 1.0f) / i13);
        this.K = iA;
        this.L = (int) (((double) iA) * 0.56d);
    }

    public /* synthetic */ SportLiveAdapter(int i11, OperateItem operateItem, int i12, boolean z11, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? R$layout.item_main_operation_sport_live : i11, operateItem, i12, z11);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(SportLiveViewHolder holder, LiveListItem item) {
        String avatar;
        String avatar2;
        String url;
        String thumbnail;
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        r(holder, getItemViewType(holder.getBindingAdapterPosition()));
        ShapeableImageView shapeableImageView = (ShapeableImageView) holder.getViewOrNull(R$id.main_op_sport_live_image);
        if (shapeableImageView != null) {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context context = shapeableImageView.getContext();
            Intrinsics.f(context, "context");
            Image image = item.getImage();
            if (image == null || (url = image.getUrl()) == null) {
                url = "";
            }
            int i11 = this.K;
            int i12 = this.L;
            Image image2 = item.getImage();
            if (image2 == null || (thumbnail = image2.getThumbnail()) == null) {
                thumbnail = "";
            }
            companion.q(context, shapeableImageView, url, (8120 & 8) != 0 ? companion.d() : i11, (8120 & 16) != 0 ? companion.c() : i12, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
        }
        holder.i(item);
        ImageHelper.Companion companion2 = ImageHelper.f51371a;
        Context context2 = getContext();
        ImageView imageView = (ImageView) holder.getView(R$id.main_op_sport_live_team1_image);
        TeamInfo team1 = item.getTeam1();
        String str = (team1 == null || (avatar2 = team1.getAvatar()) == null) ? "" : avatar2;
        int i13 = this.M;
        companion2.o(context2, imageView, str, (32704 & 8) != 0 ? R$color.skeleton : R$mipmap.ic_op_live_default, (32704 & 16) != 0 ? companion2.d() : i13, (32704 & 32) != 0 ? companion2.c() : i13, (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : null, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
        Context context3 = getContext();
        ImageView imageView2 = (ImageView) holder.getView(R$id.main_op_sport_live_team2_image);
        TeamInfo team2 = item.getTeam2();
        String str2 = (team2 == null || (avatar = team2.getAvatar()) == null) ? "" : avatar;
        int i14 = this.M;
        companion2.o(context3, imageView2, str2, (32704 & 8) != 0 ? R$color.skeleton : R$mipmap.ic_op_live_default, (32704 & 16) != 0 ? companion2.d() : i14, (32704 & 32) != 0 ? companion2.c() : i14, (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : null, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
        int i15 = R$id.main_op_sport_live_team1;
        TeamInfo team3 = item.getTeam1();
        holder.setText(i15, team3 != null ? team3.getName() : null);
        int i16 = R$id.main_op_sport_live_team2;
        TeamInfo team4 = item.getTeam2();
        holder.setText(i16, team4 != null ? team4.getName() : null);
        L0(item, this.H, holder.getBindingAdapterPosition());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public SportLiveViewHolder onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_main_operation_sport_live, parent, false);
        Intrinsics.f(viewInflate, "from(parent.context)\n   …port_live, parent, false)");
        ShapeableImageView shapeableImageView = (ShapeableImageView) new SportLiveViewHolder(viewInflate).getViewOrNull(R$id.main_op_sport_live_image);
        if (shapeableImageView != null) {
            shapeableImageView.getLayoutParams().width = this.K;
            shapeableImageView.getLayoutParams().height = this.L;
        }
        return (SportLiveViewHolder) super.onCreateViewHolder(parent, i11);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(SportLiveViewHolder holder) {
        Intrinsics.g(holder, "holder");
        super.onViewAttachedToWindow(holder);
        holder.h();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: J0, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(SportLiveViewHolder holder) {
        Intrinsics.g(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        holder.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: K0, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(SportLiveViewHolder holder) {
        Intrinsics.g(holder, "holder");
        super.onViewRecycled(holder);
        holder.g();
    }

    public final void L0(LiveListItem liveListItem, OperateItem operateItem, int i11) {
        HashMap map = new HashMap();
        map.put("event_type", "browse_sport_live_item");
        map.put("sequence", String.valueOf(i11));
        map.put("tabId", String.valueOf(this.I));
        ot.b.a(operateItem, map);
        String matchId = liveListItem.getMatchId();
        if (matchId == null) {
            matchId = "";
        }
        map.put("match_id", matchId);
        String status = liveListItem.getStatus();
        if (status == null) {
            status = "";
        }
        map.put("match_status", status);
        String ops = liveListItem.getOps();
        map.put("ops", ops != null ? ops : "");
        com.transsion.baselib.helper.a.f51183a.a(HomeTabType.TAB_CODE_TRENDING, map);
    }
}
