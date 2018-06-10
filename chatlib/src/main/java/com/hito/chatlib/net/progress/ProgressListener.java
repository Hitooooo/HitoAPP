package com.hito.chatlib.net.progress;

public interface ProgressListener {
    void onProgress(long soFarBytes, long totalBytes);

    void onError(Throwable throwable);
}