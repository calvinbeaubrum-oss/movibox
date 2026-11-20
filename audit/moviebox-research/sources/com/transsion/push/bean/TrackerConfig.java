package com.transsion.push.bean;

import eu.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class TrackerConfig {

    @a(name = "report_time")
    public long reportTime;

    @a(name = "report_type")
    public int reportType;

    @a(name = "version")
    public int version;

    public String toString() {
        return "TrackerConfig{reportType=" + this.reportType + ", reportTime=" + this.reportTime + ", version=" + this.version + '}';
    }
}
