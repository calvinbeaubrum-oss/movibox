package com.mbridge.msdk.video.module.a.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.signal.factory.IJSFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class n extends o {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private IJSFactory f48054l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f48055m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f48056n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f48057o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f48058p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f48059q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private MBridgeVideoView.a f48060r;

    public n(IJSFactory iJSFactory, CampaignEx campaignEx, com.mbridge.msdk.videocommon.b.c cVar, com.mbridge.msdk.videocommon.download.a aVar, String str, String str2, int i11, int i12, com.mbridge.msdk.video.module.a.a aVar2, int i13, boolean z11, int i14) {
        super(campaignEx, cVar, aVar, str, str2, aVar2, i13, z11);
        this.f48056n = false;
        this.f48057o = false;
        this.f48059q = false;
        this.f48054l = iJSFactory;
        this.f48055m = i11;
        this.f48056n = i12 == 0;
        this.f48058p = i14;
        if (iJSFactory == null) {
            this.f48024a = false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:103:0x028b  */
    /* JADX WARN: Code duplicated, block: B:105:0x0293  */
    /* JADX WARN: Code duplicated, block: B:106:0x029d  */
    /* JADX WARN: Code duplicated, block: B:97:0x025f  */
    /* JADX WARN: Code duplicated, block: B:99:0x026a  */
    @Override // com.mbridge.msdk.video.module.a.a.o, com.mbridge.msdk.video.module.a.a.k, com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
    public final void a(int i11, Object obj) {
        int i12;
        int i13;
        int i14 = i11;
        if (this.f48024a) {
            if (i14 != 1) {
                if (i14 == 2) {
                    this.f48054l.getJSVideoModule().dismissAllAlert();
                    if (i14 == 2) {
                        this.f48054l.getJSNotifyProxy().a(2, "");
                    }
                    this.f48054l.getJSVideoModule().videoOperate(3);
                    i12 = 16;
                    if (this.f48054l.getJSCommon().g() != 2) {
                        if (this.f48025b.getVideo_end_type() != 3) {
                            this.f48054l.getJSVideoModule().setVisible(8);
                        } else {
                            this.f48054l.getJSVideoModule().setVisible(0);
                        }
                        if (this.f48055m == 2 && !this.f48054l.getJSContainerModule().endCardShowing() && this.f48025b.getAdSpaceT() != 2) {
                            this.f48054l.getJSContainerModule().showEndcard(this.f48025b.getVideo_end_type());
                            i12 = i14;
                        }
                    }
                    this.f48054l.getJSNotifyProxy().a(1);
                    i14 = i12;
                } else if (i14 != 5) {
                    if (i14 == 6) {
                        this.f48054l.getJSVideoModule().dismissAllAlert();
                        if (i14 == 2) {
                            this.f48054l.getJSNotifyProxy().a(2, "");
                        }
                        this.f48054l.getJSVideoModule().videoOperate(3);
                        i12 = 16;
                        if (this.f48054l.getJSCommon().g() != 2) {
                            if (this.f48025b.getVideo_end_type() != 3) {
                                this.f48054l.getJSVideoModule().setVisible(8);
                            } else {
                                this.f48054l.getJSVideoModule().setVisible(0);
                            }
                            if (this.f48055m == 2) {
                                this.f48054l.getJSContainerModule().showEndcard(this.f48025b.getVideo_end_type());
                                i12 = i14;
                            }
                        }
                        this.f48054l.getJSNotifyProxy().a(1);
                        i14 = i12;
                    } else if (i14 != 8) {
                        if (i14 != 20) {
                            if (i14 != 114) {
                                if (i14 != 116) {
                                    switch (i14) {
                                        case 10:
                                            this.f48059q = true;
                                            this.f48054l.getJSNotifyProxy().a(0);
                                            break;
                                        case 11:
                                        case 12:
                                            this.f48054l.getJSVideoModule().videoOperate(3);
                                            if (this.f48025b.getVideo_end_type() == 3) {
                                                this.f48054l.getJSVideoModule().setVisible(0);
                                            } else if (this.f48025b.getAdSpaceT() != 2) {
                                                this.f48054l.getJSVideoModule().setVisible(8);
                                            }
                                            if (i14 == 12) {
                                                h();
                                                i13 = 2;
                                            } else {
                                                i13 = 1;
                                            }
                                            this.f48054l.getJSNotifyProxy().a(i13);
                                            if (this.f48054l.getJSCommon().g() == 2) {
                                                this.f48054l.getJSVideoModule().setVisible(0);
                                                com.mbridge.msdk.video.signal.j jSVideoModule = this.f48054l.getJSVideoModule();
                                                this.f48054l.getJSContainerModule().showMiniCard(jSVideoModule.getBorderViewTop(), jSVideoModule.getBorderViewLeft(), jSVideoModule.getBorderViewWidth(), jSVideoModule.getBorderViewHeight(), jSVideoModule.getBorderViewRadius());
                                            } else if (i14 == 12) {
                                                if (this.f48058p == 1) {
                                                    if (this.f48025b.getAdSpaceT() != 2) {
                                                        this.f48054l.getJSContainerModule().showEndcard(this.f48025b.getVideo_end_type());
                                                    } else {
                                                        this.f48054l.getJSContainerModule().showVideoEndCover();
                                                    }
                                                }
                                            } else if (this.f48025b.getAdSpaceT() != 2) {
                                                this.f48054l.getJSContainerModule().showEndcard(this.f48025b.getVideo_end_type());
                                            } else {
                                                this.f48054l.getJSContainerModule().showVideoEndCover();
                                            }
                                            this.f48054l.getJSVideoModule().dismissAllAlert();
                                            if (i14 == 12 && !this.f48059q && this.f48058p == 1) {
                                                h();
                                                g();
                                                f();
                                                e();
                                                if (af.a().a("i_l_s_t_r_i", false) && !this.f48057o) {
                                                    this.f48057o = true;
                                                    MBridgeVideoView.a aVar = this.f48060r;
                                                    if (aVar != null) {
                                                        aVar.a();
                                                    }
                                                }
                                            }
                                            break;
                                        case 13:
                                            if (!this.f48054l.getJSVideoModule().isH5Canvas()) {
                                                this.f48054l.getJSVideoModule().closeVideoOperate(0, 2);
                                            }
                                            this.f48054l.getJSNotifyProxy().a(-1);
                                            break;
                                        case 14:
                                            if (!this.f48056n) {
                                                this.f48054l.getJSVideoModule().closeVideoOperate(0, 1);
                                            }
                                            break;
                                        case 15:
                                            if (obj != null && (obj instanceof MBridgeVideoView.b)) {
                                                this.f48056n = true;
                                                this.f48054l.getJSNotifyProxy().a((MBridgeVideoView.b) obj);
                                            }
                                            break;
                                        default:
                                            switch (i14) {
                                                case 123:
                                                case 124:
                                                    this.f48054l.getJSNotifyProxy().a(i14 == 123 ? 7 : 6, "");
                                                    break;
                                                case 125:
                                                    this.f48054l.getJSContainerModule().hideAlertWebview();
                                                    break;
                                            }
                                            break;
                                    }
                                } else {
                                    com.mbridge.msdk.video.signal.j jSVideoModule2 = this.f48054l.getJSVideoModule();
                                    this.f48054l.getJSContainerModule().configurationChanged(jSVideoModule2.getBorderViewWidth(), jSVideoModule2.getBorderViewHeight(), jSVideoModule2.getBorderViewRadius());
                                }
                            } else if (this.f48054l.getJSCommon().g() == 2) {
                                com.mbridge.msdk.video.signal.j jSVideoModule3 = this.f48054l.getJSVideoModule();
                                this.f48054l.getJSContainerModule().showMiniCard(jSVideoModule3.getBorderViewTop(), jSVideoModule3.getBorderViewLeft(), jSVideoModule3.getBorderViewWidth(), jSVideoModule3.getBorderViewHeight(), jSVideoModule3.getBorderViewRadius());
                            }
                        } else if (af.a().a("i_l_s_t_r_i", false) && (obj instanceof MBridgeVideoView.a)) {
                            this.f48060r = (MBridgeVideoView.a) obj;
                        }
                    } else if (this.f48054l.getJSContainerModule().showAlertWebView()) {
                        this.f48054l.getJSVideoModule().alertWebViewShowed();
                    } else {
                        this.f48054l.getJSVideoModule().showAlertView();
                    }
                } else if (obj != null && (obj instanceof Integer)) {
                    Integer num = ((Integer) obj).intValue() == 1 ? 2 : 1;
                    this.f48054l.getJSVideoModule().soundOperate(num.intValue(), -1);
                    this.f48054l.getJSNotifyProxy().a(5, num + "");
                }
            } else if (!this.f48054l.getJSContainerModule().endCardShowing()) {
                this.f48054l.getJSNotifyProxy().a(1, obj != null ? obj.toString() : "");
            }
        }
        super.a(i14, obj);
    }
}
