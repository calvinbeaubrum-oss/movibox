package com.mbridge.msdk.video.module.a.a;

import android.os.Handler;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class m extends o {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private MBridgeVideoView f48041l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private MBridgeContainerView f48042m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f48043n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Timer f48044o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Handler f48045p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f48046q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f48047r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f48048s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f48049t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f48050u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private MBridgeVideoView.a f48051v;

    public m(MBridgeVideoView mBridgeVideoView, MBridgeContainerView mBridgeContainerView, CampaignEx campaignEx, com.mbridge.msdk.videocommon.b.c cVar, com.mbridge.msdk.videocommon.download.a aVar, String str, String str2, int i11, int i12, com.mbridge.msdk.video.module.a.a aVar2, int i13, boolean z11, int i14) {
        super(campaignEx, cVar, aVar, str, str2, aVar2, i13, z11);
        this.f48045p = new Handler();
        this.f48046q = false;
        this.f48047r = false;
        this.f48048s = false;
        this.f48041l = mBridgeVideoView;
        this.f48042m = mBridgeContainerView;
        this.f48050u = i11;
        this.f48043n = i12;
        this.f48049t = i14;
        if (mBridgeVideoView != null) {
            this.f48046q = mBridgeVideoView.getVideoSkipTime() == 0;
        }
        if (mBridgeVideoView == null || mBridgeContainerView == null) {
            this.f48024a = false;
        }
    }

    private void i() {
        try {
            Timer timer = this.f48044o;
            if (timer != null) {
                timer.cancel();
                this.f48044o = null;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x005c  */
    private void j() {
        CampaignEx campaignEx;
        CampaignEx campaignEx2 = this.f48025b;
        if (campaignEx2 == null || campaignEx2.getDynamicTempCode() != 5) {
            return;
        }
        MBridgeVideoView mBridgeVideoView = this.f48041l;
        if (mBridgeVideoView == null || mBridgeVideoView.mCampOrderViewData == null) {
            campaignEx = null;
        } else {
            int i11 = 0;
            for (int i12 = 0; i12 < this.f48041l.mCampOrderViewData.size(); i12++) {
                if (this.f48041l.mCampOrderViewData.get(i12) != null && this.f48041l.mCampOrderViewData.get(i12).getId() == this.f48025b.getId()) {
                    i11 = i12 - 1;
                    break;
                }
            }
            if (i11 < 0 || this.f48041l.mCampOrderViewData.get(i11) == null) {
                campaignEx = null;
            } else {
                campaignEx = this.f48041l.mCampOrderViewData.get(i11);
            }
        }
        if (campaignEx != null) {
            MBridgeVideoView mBridgeVideoView2 = this.f48041l;
            if (mBridgeVideoView2 != null) {
                mBridgeVideoView2.setCampaign(campaignEx);
            }
            MBridgeContainerView mBridgeContainerView = this.f48042m;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.setCampaign(campaignEx);
            }
            a(campaignEx);
        }
    }

    /* JADX WARN: Code duplicated, block: B:129:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:136:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:138:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:139:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:167:0x0276  */
    /* JADX WARN: Code duplicated, block: B:179:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:182:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:184:0x02c7  */
    @Override // com.mbridge.msdk.video.module.a.a.o, com.mbridge.msdk.video.module.a.a.k, com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
    public final void a(int i11, Object obj) {
        CampaignEx campaignEx;
        CampaignEx campaignEx2;
        int i12;
        CampaignEx campaignEx3;
        if (this.f48024a) {
            if (i11 != 1) {
                if (i11 == 2) {
                    this.f48041l.dismissAllAlert();
                    this.f48041l.videoOperate(3);
                    campaignEx = this.f48025b;
                    if (campaignEx == null && campaignEx.isDynamicView() && this.f48025b.getDynamicTempCode() == 5) {
                        if (this.f48042m != null) {
                            MBridgeVideoView mBridgeVideoView = this.f48041l;
                            if (mBridgeVideoView.mCurrPlayNum == mBridgeVideoView.mCampaignSize) {
                                if (this.f48025b.getAdSpaceT() == 2) {
                                    i11 = 16;
                                } else {
                                    this.f48042m.setRewardStatus(true);
                                    this.f48042m.showOrderCampView();
                                }
                            }
                        }
                        com.mbridge.msdk.video.bt.module.b.f.a(this.f48025b, this.f48030g, this.f48041l.mCurrentPlayProgressTime);
                        if (this.f48050u == 2) {
                            i11 = 16;
                        } else {
                            i11 = 16;
                        }
                    } else if (this.f48050u == 2 || this.f48042m.endCardShowing() || this.f48025b.getAdSpaceT() == 2) {
                        i11 = 16;
                    } else {
                        this.f48042m.showEndcard(this.f48025b.getVideo_end_type());
                    }
                } else if (i11 != 5) {
                    if (i11 == 6) {
                        this.f48041l.dismissAllAlert();
                        this.f48041l.videoOperate(3);
                        campaignEx = this.f48025b;
                        if (campaignEx == null) {
                            if (this.f48050u == 2) {
                                i11 = 16;
                            } else {
                                i11 = 16;
                            }
                        } else if (this.f48050u == 2) {
                            i11 = 16;
                        } else {
                            i11 = 16;
                        }
                    } else if (i11 == 8) {
                        MBridgeContainerView mBridgeContainerView = this.f48042m;
                        if (mBridgeContainerView == null) {
                            MBridgeVideoView mBridgeVideoView2 = this.f48041l;
                            if (mBridgeVideoView2 != null) {
                                mBridgeVideoView2.showAlertView();
                            }
                        } else if (mBridgeContainerView.showAlertWebView()) {
                            MBridgeVideoView mBridgeVideoView3 = this.f48041l;
                            if (mBridgeVideoView3 != null) {
                                mBridgeVideoView3.alertWebViewShowed();
                            }
                        } else {
                            MBridgeVideoView mBridgeVideoView4 = this.f48041l;
                            if (mBridgeVideoView4 != null) {
                                mBridgeVideoView4.showAlertView();
                            }
                        }
                    } else if (i11 != 20) {
                        switch (i11) {
                            case 10:
                                this.f48047r = true;
                                this.f48041l.soundOperate(0, 2);
                                this.f48041l.progressOperate(0, 2);
                                break;
                            case 11:
                                this.f48041l.videoOperate(3);
                                this.f48041l.dismissAllAlert();
                                CampaignEx campaignEx4 = this.f48025b;
                                if (campaignEx4 == null || campaignEx4.getVideo_end_type() == 3 || this.f48025b.getRewardTemplateMode() == null || this.f48025b.getRewardTemplateMode().f() == 5002010) {
                                    this.f48041l.setVisibility(0);
                                } else if (this.f48025b.getAdSpaceT() != 2) {
                                    this.f48041l.setVisibility(8);
                                }
                                CampaignEx campaignEx5 = this.f48025b;
                                if (campaignEx5 != null && campaignEx5.getDynamicTempCode() == 5) {
                                    MBridgeVideoView mBridgeVideoView5 = this.f48041l;
                                    if (mBridgeVideoView5.mCurrPlayNum != mBridgeVideoView5.mCampaignSize) {
                                        campaignEx2 = this.f48025b;
                                        if (campaignEx2 == null) {
                                            if (this.f48025b.getAdSpaceT() != 2) {
                                                this.f48042m.showEndcard(this.f48025b.getVideo_end_type());
                                            } else {
                                                this.f48042m.showVideoEndCover();
                                            }
                                        } else if (this.f48025b.getAdSpaceT() != 2) {
                                            this.f48042m.showEndcard(this.f48025b.getVideo_end_type());
                                        } else {
                                            this.f48042m.showVideoEndCover();
                                        }
                                    } else {
                                        MBridgeContainerView mBridgeContainerView2 = this.f48042m;
                                        if (mBridgeContainerView2 != null) {
                                            mBridgeContainerView2.setRewardStatus(true);
                                            this.f48042m.showOrderCampView();
                                        }
                                    }
                                } else {
                                    campaignEx2 = this.f48025b;
                                    if (campaignEx2 == null || campaignEx2.getRewardTemplateMode() == null || this.f48025b.getRewardTemplateMode().f() != 5002010) {
                                        if (this.f48025b.getAdSpaceT() != 2) {
                                            this.f48042m.showEndcard(this.f48025b.getVideo_end_type());
                                        } else {
                                            this.f48042m.showVideoEndCover();
                                        }
                                    }
                                }
                                break;
                            case 12:
                                h();
                                this.f48041l.videoOperate(3);
                                this.f48041l.dismissAllAlert();
                                if (this.f48025b.getVideo_end_type() != 3) {
                                    this.f48041l.setVisibility(8);
                                } else {
                                    this.f48041l.setVisibility(0);
                                }
                                if (this.f48047r || this.f48049t != 0) {
                                    if (this.f48025b.isDynamicView() && this.f48025b.getDynamicTempCode() == 5 && TextUtils.isEmpty(this.f48025b.getendcard_url())) {
                                        j();
                                        this.f48049t = 0;
                                    }
                                    if (!this.f48047r && this.f48049t == 1) {
                                        g();
                                        f();
                                        e();
                                        if (af.a().a("i_l_s_t_r_i", false) && !this.f48048s) {
                                            this.f48048s = true;
                                            MBridgeVideoView.a aVar = this.f48051v;
                                            if (aVar != null) {
                                                aVar.a();
                                            }
                                        }
                                    }
                                    if (this.f48025b.getAdSpaceT() == 2) {
                                        this.f48042m.showVideoEndCover();
                                    } else {
                                        this.f48042m.showEndcard(this.f48025b.getVideo_end_type());
                                    }
                                }
                                break;
                            case 13:
                                this.f48041l.closeVideoOperate(0, 2);
                                break;
                            case 14:
                                if (!this.f48046q) {
                                    this.f48041l.closeVideoOperate(0, 1);
                                }
                                break;
                            case 15:
                                if (obj != null && (obj instanceof MBridgeVideoView.b)) {
                                    MBridgeVideoView.b bVar = (MBridgeVideoView.b) obj;
                                    int videoInteractiveType = this.f48042m.getVideoInteractiveType();
                                    if (this.f48025b.getAdSpaceT() == 2) {
                                        this.f48042m.showVideoClickView(1);
                                    } else if (videoInteractiveType >= 0 && bVar.f47992a >= videoInteractiveType) {
                                        this.f48042m.showVideoClickView(1);
                                        this.f48041l.soundOperate(0, 1);
                                    }
                                    this.f48046q = bVar.f47994c;
                                    if (this.f48025b.getDynamicTempCode() != 5) {
                                        int i13 = this.f48043n;
                                        if (((i13 >= 0 && ((i12 = bVar.f47992a) >= i13 || i12 == bVar.f47993b)) || (this.f48025b.getVideoCompleteTime() > 0 && (bVar.f47992a > this.f48025b.getVideoCompleteTime() || bVar.f47992a == bVar.f47993b))) && !this.f48046q) {
                                            this.f48041l.closeVideoOperate(0, 2);
                                            this.f48046q = true;
                                        }
                                    } else {
                                        int i14 = bVar.f47992a;
                                        int i15 = bVar.f47993b;
                                        if (!this.f48046q && this.f48041l != null && (campaignEx3 = this.f48025b) != null) {
                                            int i16 = this.f48043n;
                                            int i17 = (i16 < 0 || i14 < i16) ? 1 : 2;
                                            if (i17 != 2 && (campaignEx3.getVideoCompleteTime() != 0 ? i14 > this.f48025b.getVideoCompleteTime() : this.f48041l.mCurrPlayNum > 1)) {
                                                i17 = 2;
                                            }
                                            if (i17 != 2 && this.f48041l.mCurrPlayNum > 1 && i14 == i15) {
                                                i17 = 2;
                                            }
                                            if (i17 == 2) {
                                                this.f48041l.closeVideoOperate(0, i17);
                                                this.f48046q = true;
                                            }
                                        }
                                    }
                                }
                                break;
                        }
                    } else if (af.a().a("i_l_s_t_r_i", false) && (obj instanceof MBridgeVideoView.a)) {
                        this.f48051v = (MBridgeVideoView.a) obj;
                    }
                } else if (obj != null && (obj instanceof Integer)) {
                    this.f48041l.soundOperate((((Integer) obj).intValue() == 1 ? 2 : 1).intValue(), -1);
                }
            } else if (!this.f48042m.endCardShowing()) {
                int videoInteractiveType2 = this.f48042m.getVideoInteractiveType();
                if (videoInteractiveType2 != -2) {
                    if (videoInteractiveType2 == -1) {
                        if (this.f48042m.isLast()) {
                            this.f48042m.showVideoClickView(1);
                            this.f48041l.soundOperate(0, 1);
                            try {
                                i();
                                this.f48044o = new Timer();
                                this.f48044o.schedule(new TimerTask() { // from class: com.mbridge.msdk.video.module.a.a.m.1
                                    @Override // java.util.TimerTask, java.lang.Runnable
                                    public final void run() {
                                        try {
                                            m.this.f48045p.post(new Runnable() { // from class: com.mbridge.msdk.video.module.a.a.m.1.1
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    m.this.f48042m.showVideoClickView(-1);
                                                    m.this.f48041l.soundOperate(0, 2);
                                                }
                                            });
                                        } catch (Throwable th2) {
                                            if (MBridgeConstans.DEBUG) {
                                                th2.printStackTrace();
                                            }
                                        }
                                    }
                                }, 3000L);
                            } catch (Exception e11) {
                                e11.printStackTrace();
                            }
                        } else {
                            this.f48042m.showVideoClickView(-1);
                            this.f48041l.soundOperate(0, 2);
                            i();
                        }
                    }
                } else if (this.f48042m.miniCardLoaded()) {
                    this.f48042m.showVideoClickView(2);
                }
            }
        }
        super.a(i11, obj);
    }
}
