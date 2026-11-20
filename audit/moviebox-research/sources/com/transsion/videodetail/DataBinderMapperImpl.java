package com.transsion.videodetail;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class DataBinderMapperImpl extends androidx.databinding.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseIntArray f59792a = new SparseIntArray(0);

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HashMap<String, Integer> f59793a = new HashMap<>(0);
    }

    @Override // androidx.databinding.e
    public List<androidx.databinding.e> a() {
        ArrayList arrayList = new ArrayList(30);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.avery.subtitle.DataBinderMapperImpl());
        arrayList.add(new com.tn.lib.libcommon.DataBinderMapperImpl());
        arrayList.add(new com.tn.lib.net.DataBinderMapperImpl());
        arrayList.add(new com.tn.lib.widget.DataBinderMapperImpl());
        arrayList.add(new com.transsion.ad.DataBinderMapperImpl());
        arrayList.add(new com.transsion.baselib.DataBinderMapperImpl());
        arrayList.add(new com.transsion.baseui.DataBinderMapperImpl());
        arrayList.add(new com.transsion.commercializationapi.DataBinderMapperImpl());
        arrayList.add(new com.transsion.downloadapi.DataBinderMapperImpl());
        arrayList.add(new com.transsion.edcation.DataBinderMapperImpl());
        arrayList.add(new com.transsion.fissionapi.DataBinderMapperImpl());
        arrayList.add(new com.transsion.lib_web.DataBinderMapperImpl());
        arrayList.add(new com.transsion.libpreloader.DataBinderMapperImpl());
        arrayList.add(new com.transsion.mb.config.DataBinderMapperImpl());
        arrayList.add(new com.transsion.memberapi.DataBinderMapperImpl());
        arrayList.add(new com.transsion.moviedetail.DataBinderMapperImpl());
        arrayList.add(new com.transsion.ninegridview.DataBinderMapperImpl());
        arrayList.add(new com.transsion.play.detail.DataBinderMapperImpl());
        arrayList.add(new com.transsion.player.DataBinderMapperImpl());
        arrayList.add(new com.transsion.player.longvideo.DataBinderMapperImpl());
        arrayList.add(new com.transsion.postdetailapi.DataBinderMapperImpl());
        arrayList.add(new com.transsion.publish.DataBinderMapperImpl());
        arrayList.add(new com.transsion.share.DataBinderMapperImpl());
        arrayList.add(new com.transsion.subtitle.DataBinderMapperImpl());
        arrayList.add(new com.transsion.subtitle_download.DataBinderMapperImpl());
        arrayList.add(new com.transsion.usercenter.DataBinderMapperImpl());
        arrayList.add(new com.transsion.videofloat.DataBinderMapperImpl());
        arrayList.add(new com.transsion.web.DataBinderMapperImpl());
        arrayList.add(new com.transsnet.downloader.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.e
    public ViewDataBinding b(androidx.databinding.f fVar, View view, int i11) {
        if (f59792a.get(i11) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.e
    public int c(String str) {
        Integer num;
        if (str == null || (num = a.f59793a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }
}
