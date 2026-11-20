package com.cloud.tmc.miniapp.base;

import com.cloud.tmc.integration.chain.page.PageChainContext;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.p;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f31429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f31430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f31431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f31432d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ShowPageStatus f31433e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f31434f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f31435g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PageChainContext f31436h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f31437i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ConcurrentHashMap<Integer, Long> f31438j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public MiniAppH5BaseFragment.ProgressStep f31439k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f31440l;

    public a(String originalUrl, String url, String requestUrl, String virtual_h5PageId, ShowPageStatus status, boolean z11, String pageRandomIdByGAID, PageChainContext pageChainContext, boolean z12, ConcurrentHashMap<Integer, Long> progressCollectList, MiniAppH5BaseFragment.ProgressStep progressStep, long j11) {
        Intrinsics.g(originalUrl, "originalUrl");
        Intrinsics.g(url, "url");
        Intrinsics.g(requestUrl, "requestUrl");
        Intrinsics.g(virtual_h5PageId, "virtual_h5PageId");
        Intrinsics.g(status, "status");
        Intrinsics.g(pageRandomIdByGAID, "pageRandomIdByGAID");
        Intrinsics.g(progressCollectList, "progressCollectList");
        this.f31429a = originalUrl;
        this.f31430b = url;
        this.f31431c = requestUrl;
        this.f31432d = virtual_h5PageId;
        this.f31433e = status;
        this.f31434f = z11;
        this.f31435g = pageRandomIdByGAID;
        this.f31436h = pageChainContext;
        this.f31437i = z12;
        this.f31438j = progressCollectList;
        this.f31439k = progressStep;
        this.f31440l = j11;
    }

    public /* synthetic */ a(String str, String str2, String str3, String str4, ShowPageStatus showPageStatus, boolean z11, String str5, PageChainContext pageChainContext, boolean z12, ConcurrentHashMap concurrentHashMap, MiniAppH5BaseFragment.ProgressStep progressStep, long j11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i11 & 16) != 0 ? ShowPageStatus.SHOULDOVERRIDEURKLOADING : showPageStatus, (i11 & 32) != 0 ? false : z11, (i11 & 64) != 0 ? "" : str5, (i11 & 128) != 0 ? null : pageChainContext, (i11 & 256) != 0 ? false : z12, (i11 & 512) != 0 ? new ConcurrentHashMap() : concurrentHashMap, (i11 & 1024) != 0 ? null : progressStep, (i11 & 2048) != 0 ? System.currentTimeMillis() : j11);
    }

    public final boolean a() {
        return this.f31434f;
    }

    public final String b() {
        return this.f31429a;
    }

    public final PageChainContext c() {
        return this.f31436h;
    }

    public final ConcurrentHashMap<Integer, Long> d() {
        return this.f31438j;
    }

    public final MiniAppH5BaseFragment.ProgressStep e() {
        return this.f31439k;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.b(this.f31429a, aVar.f31429a) && Intrinsics.b(this.f31430b, aVar.f31430b) && Intrinsics.b(this.f31431c, aVar.f31431c) && Intrinsics.b(this.f31432d, aVar.f31432d) && this.f31433e == aVar.f31433e && this.f31434f == aVar.f31434f && Intrinsics.b(this.f31435g, aVar.f31435g) && Intrinsics.b(this.f31436h, aVar.f31436h) && this.f31437i == aVar.f31437i && Intrinsics.b(this.f31438j, aVar.f31438j) && this.f31439k == aVar.f31439k && this.f31440l == aVar.f31440l;
    }

    public final long f() {
        return this.f31440l;
    }

    public final String g() {
        return this.f31431c;
    }

    public final ShowPageStatus h() {
        return this.f31433e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = (this.f31433e.hashCode() + ((this.f31432d.hashCode() + ((this.f31431c.hashCode() + ((this.f31430b.hashCode() + (this.f31429a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z11 = this.f31434f;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int iHashCode2 = (this.f31435g.hashCode() + ((iHashCode + r11) * 31)) * 31;
        PageChainContext pageChainContext = this.f31436h;
        int iHashCode3 = (iHashCode2 + (pageChainContext == null ? 0 : pageChainContext.hashCode())) * 31;
        boolean z12 = this.f31437i;
        int iHashCode4 = (this.f31438j.hashCode() + ((iHashCode3 + (z12 ? 1 : z12)) * 31)) * 31;
        MiniAppH5BaseFragment.ProgressStep progressStep = this.f31439k;
        return p.a(this.f31440l) + ((iHashCode4 + (progressStep != null ? progressStep.hashCode() : 0)) * 31);
    }

    public final String i() {
        return this.f31430b;
    }

    public final String j() {
        return this.f31432d;
    }

    public final void k(boolean z11) {
        this.f31434f = z11;
    }

    public final void l(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f31429a = str;
    }

    public final void m(MiniAppH5BaseFragment.ProgressStep progressStep) {
        this.f31439k = progressStep;
    }

    public final void n(long j11) {
        this.f31440l = j11;
    }

    public final void o(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f31431c = str;
    }

    public final void p(ShowPageStatus showPageStatus) {
        Intrinsics.g(showPageStatus, "<set-?>");
        this.f31433e = showPageStatus;
    }

    public final void q(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f31430b = str;
    }

    public String toString() {
        return "ShowPageData(originalUrl=" + this.f31429a + ", url=" + this.f31430b + ", requestUrl=" + this.f31431c + ", virtual_h5PageId=" + this.f31432d + ", status=" + this.f31433e + ", loadFail=" + this.f31434f + ", pageRandomIdByGAID=" + this.f31435g + ", pageChainContext=" + this.f31436h + ", isRedirect=" + this.f31437i + ", progressCollectList=" + this.f31438j + ", progressCurrentStep=" + this.f31439k + ", progressStartTime=" + this.f31440l + ')';
    }
}
