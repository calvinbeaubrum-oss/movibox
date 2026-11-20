package com.transsion.push.bean;

import eu.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class TrackerResponse {

    @a(name = "data")
    public TrackerConfig config;
    public String message;
    public int status;

    public String toString() {
        return "TrackerResponse{status=" + this.status + ", message='" + this.message + "', config=" + this.config + '}';
    }
}
