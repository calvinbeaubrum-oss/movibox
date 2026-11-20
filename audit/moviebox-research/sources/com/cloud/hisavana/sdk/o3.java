package com.cloud.hisavana.sdk;

import android.text.TextUtils;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import com.cloud.hisavana.sdk.common.bean.VastData;
import com.cloud.hisavana.sdk.common.bean.VastIcon;
import com.cloud.hisavana.sdk.common.bean.VideoMask;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class o3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<AdsDTO> f29956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f29957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f29958c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f29959d;

    /* JADX INFO: compiled from: source.java */
    public class a implements DownLoadRequest.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f29960a;

        public a(List list) {
            this.f29960a = list;
        }

        @Override // com.cloud.hisavana.sdk.common.http.DownLoadRequest.c
        public void onSuccess() {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (TaNativeInfo taNativeInfo : this.f29960a) {
                if (taNativeInfo != null && (taNativeInfo.getAdItem().getExt() == null || taNativeInfo.getAdItem().getExt().getStoreFlag().intValue() <= 0 || taNativeInfo.getAdType() == 6 || o3.this.g(taNativeInfo.getStore()))) {
                    if (taNativeInfo.getAdType() != 6 ? o3.this.g(taNativeInfo.getImage()) : o3.this.g(taNativeInfo.getIconImage())) {
                        arrayList.add(taNativeInfo);
                        arrayList2.add(taNativeInfo.getAdItem());
                    }
                    if (taNativeInfo.getAdItem() != null && taNativeInfo.getAdItem().getPslinkInfoStatus() && taNativeInfo.getIconImage() != null && taNativeInfo.getIconImage().isCached()) {
                        taNativeInfo.getAdItem().getPslinkInfo().setIconUri(w9.f.d(taNativeInfo.getIconImage().getFilePath()));
                        z.a().d("ssp", "pslink half set icon uri");
                    }
                    if (taNativeInfo.getAdItem() != null && taNativeInfo.getAdItem().getVideoInfo() != null) {
                        AdsDTO adItem = taNativeInfo.getAdItem();
                        VastData videoInfo = adItem.getVideoInfo();
                        if (adItem.getDspType().intValue() == 2) {
                            if (videoInfo != null && videoInfo.checkVast()) {
                                arrayList.add(taNativeInfo);
                                arrayList2.add(taNativeInfo.getAdItem());
                            }
                        } else if (videoInfo != null && videoInfo.checkVast()) {
                            arrayList.add(taNativeInfo);
                            arrayList2.add(taNativeInfo.getAdItem());
                        }
                    }
                }
            }
            if (arrayList.isEmpty()) {
                o3.this.b(TaErrorCode.ERROR_AD_MATERIAL_TAKE_FAILED);
            } else {
                e1.k(arrayList);
                o3.this.f(arrayList, arrayList2);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(TaErrorCode taErrorCode);

        void b(List<TaNativeInfo> list, List<AdsDTO> list2);
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f29962a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TaNativeInfo f29963b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final DownLoadRequest.c f29964c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public AtomicInteger f29965d = new AtomicInteger(0);

        /* JADX INFO: compiled from: source.java */
        public class a extends DrawableResponseListener {
            public a() {
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
            public void a(TaErrorCode taErrorCode) {
                c.this.c();
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
            public void g(int i11, AdImage adImage) {
                c.this.f29963b.getImage().setCached(true);
                c.this.c();
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class b extends DrawableResponseListener {
            public b() {
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
            public void a(TaErrorCode taErrorCode) {
                c.this.c();
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
            public void g(int i11, AdImage adImage) {
                AdImage iconImage = c.this.f29963b.getIconImage();
                iconImage.setCached(true);
                if (com.cloud.sdk.commonutil.util.m.a()) {
                    iconImage.setDrawable(adImage != null ? adImage.getDrawable() : null);
                } else {
                    iconImage.setFilePath(adImage != null ? adImage.getFilePath() : "");
                }
                c.this.c();
            }
        }

        /* JADX INFO: renamed from: com.cloud.hisavana.sdk.o3$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0329c extends DrawableResponseListener {
            public C0329c() {
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
            public void a(TaErrorCode taErrorCode) {
                if (c.this.f29963b == null || c.this.f29963b.getAdItem() == null) {
                    return;
                }
                c.this.f29963b.getAdItem().setACReady(Boolean.FALSE);
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
            public void g(int i11, AdImage adImage) {
                if (c.this.f29963b == null || c.this.f29963b.getAdItem() == null) {
                    return;
                }
                c.this.f29963b.getAdItem().setACReady(Boolean.TRUE);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class d extends DrawableResponseListener {
            public d() {
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
            public void a(TaErrorCode taErrorCode) {
                c.this.c();
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
            public void g(int i11, AdImage adImage) {
                c.this.f29963b.getStore().setCached(true);
                c.this.c();
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class e extends DrawableResponseListener {
            public e() {
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
            public void a(TaErrorCode taErrorCode) {
                c.this.c();
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
            public void g(int i11, AdImage adImage) {
                c.this.c();
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class f extends DrawableResponseListener {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ VastData f29971b;

            public f(VastData vastData) {
                this.f29971b = vastData;
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
            public void a(TaErrorCode taErrorCode) {
                c.this.c();
            }

            @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
            public void g(int i11, AdImage adImage) {
                this.f29971b.setVideoCached(Boolean.TRUE);
                c.this.c();
            }
        }

        public c(TaNativeInfo taNativeInfo, DownLoadRequest.c cVar) {
            this.f29963b = taNativeInfo;
            this.f29964c = cVar;
        }

        public final void c() {
            AtomicInteger atomicInteger = this.f29965d;
            if (atomicInteger == null || atomicInteger.decrementAndGet() > 0) {
                return;
            }
            k();
        }

        public final void d(AdImage adImage, AdsDTO adsDTO, int i11, boolean z11, DrawableResponseListener drawableResponseListener) {
            if (adImage != null && !TextUtils.isEmpty(adImage.getImgUrl())) {
                DownLoadRequest.l(adImage.getImgUrl(), adsDTO, i11, z11, drawableResponseListener);
                return;
            }
            z.a().d("NativeLoadManager", "image url is null");
            if (drawableResponseListener != null) {
                drawableResponseListener.a(TaErrorCode.ERROR_AD_MATERIAL_TAKE_FAILED);
            }
        }

        public final boolean f() {
            TaNativeInfo taNativeInfo = this.f29963b;
            if (taNativeInfo == null || TextUtils.isEmpty(taNativeInfo.getAcImageUrl())) {
                return false;
            }
            if (!DownLoadRequest.f29427p) {
                DownLoadRequest.l(this.f29963b.getAcImageUrl(), this.f29963b.getAdItem(), 3, false, new C0329c());
                return true;
            }
            TaNativeInfo taNativeInfo2 = this.f29963b;
            if (taNativeInfo2 == null || taNativeInfo2.getAdItem() == null) {
                return true;
            }
            this.f29963b.getAdItem().setACReady(Boolean.TRUE);
            return true;
        }

        public final boolean h() {
            TaNativeInfo taNativeInfo = this.f29963b;
            if (taNativeInfo == null) {
                return false;
            }
            d(taNativeInfo.getImage(), this.f29963b.getAdItem(), 2, false, new a());
            return true;
        }

        public final boolean j() {
            TaNativeInfo taNativeInfo = this.f29963b;
            if (taNativeInfo == null) {
                return false;
            }
            d(taNativeInfo.getIconImage(), this.f29963b.getAdItem(), 1, true, new b());
            return true;
        }

        public final void k() {
            c cVar = this.f29962a;
            if (cVar != null) {
                cVar.o();
                return;
            }
            DownLoadRequest.c cVar2 = this.f29964c;
            if (cVar2 != null) {
                cVar2.onSuccess();
            }
        }

        public final boolean l() {
            TaNativeInfo taNativeInfo = this.f29963b;
            if (taNativeInfo == null || taNativeInfo.getAdItem() == null) {
                z.a().d("NativeLoadManager", "downloadStoreIcon nativeInfo of adItem is null");
                return false;
            }
            d(this.f29963b.getStore(), this.f29963b.getAdItem(), 2, false, new d());
            return true;
        }

        public final boolean m() {
            VastData videoInfo;
            VastIcon icon;
            AdsDTO adItem = this.f29963b.getAdItem();
            if (adItem == null || (videoInfo = adItem.getVideoInfo()) == null || (icon = videoInfo.getIcon()) == null || icon.getIconResource() == null || TextUtils.isEmpty(icon.getIconResource())) {
                return false;
            }
            DownLoadRequest.l(icon.getIconResource(), adItem, 11, true, new e());
            return true;
        }

        public final boolean n() {
            VastData videoInfo;
            VideoMask videoMask;
            AdsDTO adItem = this.f29963b.getAdItem();
            if (adItem == null || (videoInfo = adItem.getVideoInfo()) == null || (videoMask = videoInfo.getVideoMask()) == null || videoMask.getResource() == null || TextUtils.isEmpty(videoMask.getResource())) {
                return false;
            }
            DownLoadRequest.l(videoMask.getResource(), adItem, 12, true, new f(videoInfo));
            return true;
        }

        /* JADX WARN: Code duplicated, block: B:40:0x0084  */
        /* JADX WARN: Code duplicated, block: B:51:0x00a6  */
        public final void o() {
            boolean z11;
            TaNativeInfo taNativeInfo = this.f29963b;
            if (taNativeInfo == null) {
                k();
                return;
            }
            AdsDTO adItem = taNativeInfo.getAdItem();
            if (adItem == null) {
                k();
                return;
            }
            if (adItem.getExt() == null || adItem.getExt().getStoreFlag().intValue() <= 0 || adItem.getAdType() == 6) {
                z11 = false;
            } else {
                String storeImageurl = adItem.getExt().getStoreImageurl();
                AdImage store = this.f29963b.getStore();
                if (store != null) {
                    store.setImgUrl(storeImageurl);
                }
                z11 = true;
            }
            if (z11) {
                this.f29965d.addAndGet(1);
            }
            if (this.f29963b.getAdType() == 1) {
                VastData videoInfo = adItem.getVideoInfo();
                this.f29965d.addAndGet(2);
                if (videoInfo == null || !videoInfo.checkVast()) {
                    if (!h()) {
                        c();
                    }
                    if (!j()) {
                        c();
                    }
                } else {
                    if (!m()) {
                        c();
                    }
                    if (!n()) {
                        c();
                    }
                }
                if (z11 && !l()) {
                    c();
                }
            } else {
                this.f29965d.addAndGet(1);
                if (!j()) {
                    c();
                }
                if (z11 && !l()) {
                    c();
                }
            }
            f();
        }
    }

    public o3(List<AdsDTO> list, int i11, b bVar) {
        this.f29956a = list;
        this.f29959d = i11;
        this.f29957b = bVar;
    }

    public void a() {
        if (this.f29958c) {
            return;
        }
        this.f29958c = true;
        if (!w9.e.a(this.f29956a)) {
            b(TaErrorCode.ERROR_AD_DATA_IS_NULL);
            return;
        }
        List<TaNativeInfo> listX = e1.x(this.f29956a);
        int i11 = this.f29959d;
        if (i11 == 3 || i11 == 2) {
            f(listX, this.f29956a);
        } else {
            e(listX);
        }
    }

    public final void b(TaErrorCode taErrorCode) {
        this.f29958c = false;
        b bVar = this.f29957b;
        if (bVar != null) {
            bVar.a(taErrorCode);
        }
    }

    public final void e(List<TaNativeInfo> list) {
        z.a().d("NativeLoadManager", "downloadMaterial start");
        List<AdsDTO> list2 = this.f29956a;
        if (list2 == null || list2.isEmpty()) {
            z.a().d("NativeLoadManager", "downloadMaterial ads is null");
            b(TaErrorCode.ERROR_AD_MATERIAL_TAKE_FAILED);
            return;
        }
        a aVar = new a(list);
        c cVar = null;
        c cVar2 = null;
        for (TaNativeInfo taNativeInfo : list) {
            if (cVar == null) {
                cVar2 = new c(taNativeInfo, aVar);
                cVar = cVar2;
            } else {
                cVar2.f29962a = new c(taNativeInfo, aVar);
                cVar2 = cVar2.f29962a;
            }
        }
        if (cVar != null) {
            cVar.o();
        }
    }

    public final void f(List<TaNativeInfo> list, List<AdsDTO> list2) {
        this.f29958c = false;
        if (this.f29956a == null) {
            b(TaErrorCode.ERROR_AD_DATA_IS_NULL);
            return;
        }
        b bVar = this.f29957b;
        if (bVar != null) {
            bVar.b(list, list2);
        }
        if (this.f29959d == 1) {
            b1.c().p(list2);
        }
    }

    public final boolean g(AdImage adImage) {
        return adImage != null && adImage.isCached();
    }

    public void i() {
        this.f29957b = null;
    }
}
