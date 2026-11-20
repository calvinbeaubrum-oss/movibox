package com.transsion.home.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.alibaba.android.arouter.facade.Postcard;
import com.blankj.utilcode.util.f0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.tn.lib.widget.R$string;
import com.tn.lib.widget.TnTextView;
import com.transsion.banner.adapter.OpPlayListAdapter;
import com.transsion.banner.adapter.StaffAdapter;
import com.transsion.banner.view.HRecyclerView;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.home.p003enum.HomeTabType;
import com.transsion.home.utils.HomeUtilsKt;
import com.transsion.moviedetailapi.bean.AppointSubject;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PlayListIcon;
import com.transsion.moviedetailapi.bean.PlayListItem;
import com.transsion.moviedetailapi.bean.PlayListType;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.Subject;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import lt.c0;

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
public final class OpPlayListView extends LinearLayoutCompat {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public c0 f52671q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f52672r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f52673s;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OpPlayListView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OpPlayListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpPlayListView(Context context, AttributeSet attributeSet, int i11) {
        HRecyclerView hRecyclerView;
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f52673s = HomeTabType.TAB_CODE_TRENDING;
        this.f52671q = c0.b(LayoutInflater.from(getContext()), this);
        setOrientation(1);
        c0 c0Var = this.f52671q;
        if (c0Var == null || (hRecyclerView = c0Var.f70406f) == null) {
            return;
        }
        hRecyclerView.setLayoutManager(new NpaGridLayoutManager(hRecyclerView.getContext(), 3));
        hRecyclerView.addItemDecoration(new ro.b(f0.a(4.0f), f0.a(4.0f), 0, 0));
    }

    public static final void A(OpPlayListView this$0, OperateItem item, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(item, "$item");
        this$0.G(item);
    }

    public static final void B(OpPlayListView this$0, OperateItem item, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(item, "$item");
        this$0.G(item);
    }

    public static final void D(OperateItem operateItem, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(operateItem, "$operateItem");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "<anonymous parameter 1>");
        Object item = adapter.getItem(i11);
        if (item instanceof Staff) {
            com.alibaba.android.arouter.launcher.a.d().b("/movie/staff").withSerializable("staff", (Serializable) item).navigation();
            pr.a.f74040a.A(operateItem, (Staff) item, i11);
        }
    }

    public static final void F(OperateItem operateItem, OpPlayListView this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(operateItem, "$operateItem");
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "<anonymous parameter 1>");
        Object item = adapter.getItem(i11);
        if (item instanceof Subject) {
            Subject subject = (Subject) item;
            HomeUtilsKt.b(subject, "opt_playlist");
            pr.a.f74040a.v(operateItem, subject, i11, this$0.f52672r, this$0.f52673s);
        }
    }

    public static /* synthetic */ List z(OpPlayListView opPlayListView, List list, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 3;
        }
        return opPlayListView.y(list, i11);
    }

    public final void C(List<? extends Staff> list, final OperateItem operateItem) {
        PlayListItem playListData = operateItem.getPlayListData();
        boolean z11 = false;
        if (playListData != null && playListData.getBuiltIn()) {
            z11 = true;
        }
        c0 c0Var = this.f52671q;
        HRecyclerView hRecyclerView = c0Var != null ? c0Var.f70406f : null;
        if (hRecyclerView == null) {
            return;
        }
        StaffAdapter staffAdapter = new StaffAdapter(CollectionsKt___CollectionsKt.M0(list), z11);
        staffAdapter.B0(new f9.d() { // from class: com.transsion.home.view.c
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                OpPlayListView.D(operateItem, baseQuickAdapter, view, i11);
            }
        });
        hRecyclerView.setAdapter(staffAdapter);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x000f  */
    public final void E(List<? extends Subject> list, boolean z11, final OperateItem operateItem) {
        boolean z12;
        PlayListItem playListData = operateItem.getPlayListData();
        if (playListData != null) {
            z12 = playListData.getBuiltIn();
        }
        List listZ = z(this, list, 0, 2, null);
        c0 c0Var = this.f52671q;
        HRecyclerView hRecyclerView = c0Var != null ? c0Var.f70406f : null;
        if (hRecyclerView == null) {
            return;
        }
        OpPlayListAdapter opPlayListAdapter = new OpPlayListAdapter(CollectionsKt___CollectionsKt.M0(listZ), z11, z12);
        opPlayListAdapter.B0(new f9.d() { // from class: com.transsion.home.view.d
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                OpPlayListView.F(operateItem, this, baseQuickAdapter, view, i11);
            }
        });
        hRecyclerView.setAdapter(opPlayListAdapter);
    }

    public final void G(OperateItem operateItem) {
        List<Staff> staffs;
        StringBuilder sb2 = new StringBuilder();
        PlayListItem playListData = operateItem.getPlayListData();
        if (Intrinsics.b(playListData != null ? playListData.getCategory() : null, PlayListType.CAST.getValue())) {
            PlayListItem playListData2 = operateItem.getPlayListData();
            if (playListData2 != null && (staffs = playListData2.getStaffs()) != null) {
                Iterator<T> it = staffs.iterator();
                while (it.hasNext()) {
                    sb2.append(((Staff) it.next()).getStaffId());
                    sb2.append(",");
                }
            }
        } else {
            List<AppointSubject> subjects = operateItem.getSubjects();
            if (subjects != null) {
                Iterator<T> it2 = subjects.iterator();
                while (it2.hasNext()) {
                    sb2.append(((AppointSubject) it2.next()).getSubjectId());
                    sb2.append(",");
                }
            }
        }
        int iLastIndexOf = sb2.lastIndexOf(",");
        if (iLastIndexOf >= 0) {
            sb2.deleteCharAt(iLastIndexOf);
        }
        Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/home/playlist");
        PlayListItem playListData3 = operateItem.getPlayListData();
        Postcard postcardWithString = postcardB.withString("label", playListData3 != null ? playListData3.getLabel() : null);
        PlayListItem playListData4 = operateItem.getPlayListData();
        Postcard postcardWithString2 = postcardWithString.withString("category", playListData4 != null ? playListData4.getCategory() : null);
        PlayListItem playListData5 = operateItem.getPlayListData();
        postcardWithString2.withString("recType", playListData5 != null ? playListData5.getRecType() : null).withString("topIds", sb2.toString()).withInt("tabId", this.f52672r).navigation();
        pr.a.f74040a.w(operateItem, this.f52673s);
    }

    public final void setCurrentTab(int i11, String pageName) {
        Intrinsics.g(pageName, "pageName");
        this.f52672r = i11;
        this.f52673s = pageName;
    }

    public final void setData(final OperateItem item) {
        PlayListIcon icon;
        PlayListItem playListData;
        PlayListIcon icon2;
        String color;
        PlayListIcon icon3;
        Boolean showRank;
        List<Staff> staffs;
        PlayListIcon icon4;
        String iconUrl;
        PlayListIcon icon5;
        Intrinsics.g(item, "item");
        c0 c0Var = this.f52671q;
        if (c0Var != null) {
            c0Var.f70410j.setTextWithString(item.getTitle());
            PlayListItem playListData2 = item.getPlayListData();
            if (playListData2 == null || (icon4 = playListData2.getIcon()) == null || !Intrinsics.b(icon4.isPic(), Boolean.TRUE)) {
                LinearLayoutCompat tagGroup = c0Var.f70407g;
                Intrinsics.f(tagGroup, "tagGroup");
                so.c.k(tagGroup);
                AppCompatImageView ivTag = c0Var.f70404c;
                Intrinsics.f(ivTag, "ivTag");
                so.c.g(ivTag);
                PlayListItem playListData3 = item.getPlayListData();
                if (playListData3 == null || !playListData3.getBuiltIn()) {
                    RequestManager requestManagerWith = Glide.with(getContext());
                    PlayListItem playListData4 = item.getPlayListData();
                    requestManagerWith.load((playListData4 == null || (icon = playListData4.getIcon()) == null) ? null : icon.getIconUrl()).into(c0Var.f70408h);
                } else {
                    j.d(l0.a(w0.c()), null, null, new OpPlayListView$setData$1$2(item, c0Var, null), 3, null);
                }
                TnTextView tnTextView = c0Var.f70409i;
                PlayListItem playListData5 = item.getPlayListData();
                tnTextView.setTextWithString((playListData5 == null || (icon3 = playListData5.getIcon()) == null) ? null : icon3.getName());
                Drawable background = c0Var.f70407g.getBackground();
                if ((background instanceof GradientDrawable) && (playListData = item.getPlayListData()) != null && (icon2 = playListData.getIcon()) != null && (color = icon2.getColor()) != null) {
                    ((GradientDrawable) background).setColor(Color.parseColor(color));
                }
            } else {
                LinearLayoutCompat tagGroup2 = c0Var.f70407g;
                Intrinsics.f(tagGroup2, "tagGroup");
                so.c.g(tagGroup2);
                AppCompatImageView ivTag2 = c0Var.f70404c;
                Intrinsics.f(ivTag2, "ivTag");
                so.c.k(ivTag2);
                PlayListItem playListData6 = item.getPlayListData();
                if (playListData6 == null || !playListData6.getBuiltIn()) {
                    ImageHelper.Companion companion = ImageHelper.f51371a;
                    Context context = getContext();
                    Intrinsics.f(context, "context");
                    AppCompatImageView ivTag3 = c0Var.f70404c;
                    Intrinsics.f(ivTag3, "ivTag");
                    PlayListItem playListData7 = item.getPlayListData();
                    if (playListData7 == null || (icon5 = playListData7.getIcon()) == null || (iconUrl = icon5.getIconUrl()) == null) {
                        iconUrl = "";
                    }
                    companion.r(context, ivTag3, iconUrl, (4088 & 8) != 0 ? companion.d() : 0, (4088 & 16) != 0 ? companion.c() : 0, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
                } else {
                    j.d(l0.a(w0.c()), null, null, new OpPlayListView$setData$1$1(item, c0Var, null), 3, null);
                }
            }
            PlayListItem playListData8 = item.getPlayListData();
            if (Intrinsics.b(playListData8 != null ? playListData8.getCategory() : null, PlayListType.CAST.getValue())) {
                PlayListItem playListData9 = item.getPlayListData();
                if (playListData9 != null && (staffs = playListData9.getStaffs()) != null) {
                    C(staffs, item);
                }
            } else {
                List<AppointSubject> subjects = item.getSubjects();
                if (subjects != null) {
                    PlayListItem playListData10 = item.getPlayListData();
                    E(subjects, (playListData10 == null || (showRank = playListData10.getShowRank()) == null) ? false : showRank.booleanValue(), item);
                }
            }
            c0Var.f70403b.setTextWithString(getContext().getString(R$string.player_more));
            c0Var.f70403b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.view.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OpPlayListView.A(this.f52694a, item, view);
                }
            });
            c0Var.f70405d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.view.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OpPlayListView.B(this.f52696a, item, view);
                }
            });
        }
    }

    public final <T> List<T> y(List<? extends T> list, int i11) {
        List<T> listM0 = CollectionsKt___CollectionsKt.M0(list);
        while (listM0.size() < i11) {
            listM0.add(null);
        }
        return listM0;
    }
}
