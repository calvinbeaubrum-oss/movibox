package com.aliyun.player.bean;

import com.transsion.gslb.Worker;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public enum InfoCode {
    Unknown(-1),
    LoopingStart(0),
    BufferedPosition(1),
    CurrentPosition(2),
    AutoPlayStart(3),
    CurrentDownloadSpeed(4),
    UtcTime(5),
    LocalCacheLoaded(6),
    SwitchToSoftwareVideoDecoder(100),
    AudioCodecNotSupport(101),
    AudioDecoderDeviceError(102),
    VideoCodecNotSupport(Worker.WHAT_SYNC_DATA),
    VideoDecoderDeviceError(104),
    VideoRenderInitError(105),
    DemuxerTraceID(106),
    NetworkRetry(108),
    CacheSuccess(109),
    CacheError(Worker.WHAT_QUIT),
    LowMemory(111),
    NetworkRetrySuccess(113),
    SubtitleSelectError(114),
    DirectComponentMSG(116),
    RTSServerMaybeDisconnect(805371905),
    RTSServerRecover(805371906);

    private int value;

    InfoCode(int i11) {
        this.value = i11;
    }

    public int getValue() {
        return this.value;
    }
}
