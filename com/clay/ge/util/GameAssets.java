package com.clay.ge.util;

import java.io.File;

public class GameAssets {
    private static final File rootAssets = new File(System.getProperty("user.dir"), "assets");
    private static final File assetsImages = new File(rootAssets, "images");
    private static final File assetsAudio = new File(rootAssets, "audio");
    private static final File assetsData = new File(rootAssets, "data");
    private static final File assetsFont = new File(rootAssets, "font");
    private static final File assetsVideo = new File(rootAssets, "video");

    public static void InitAssets() {
        if (!rootAssets.exists()) rootAssets.mkdir();
        if (rootAssets.exists()) {
            assetsImages.mkdir();
            assetsAudio.mkdir();
            assetsData.mkdir();
            assetsFont.mkdir();
            assetsVideo.mkdir();
        }
    }

    public static File Load(String dirname) {
        File file = new File(dirname);
        if (file.exists()) return file;
        else return null;
    }

    public static File LoadAssetsAudio(String name) {
        if (!rootAssets.exists()) {
            System.out.println("rootAssets null: use 'GameAssets.InitAssets()'");
            return null;
        }
        if (name == null || name.equals("")) return null;
        File file = new File(assetsAudio, name);
        if (file.exists()) {
            return file;
        } else {
            return null;
        }
    }

    public static File LoadAssetsData(String name) {
        if (!rootAssets.exists()) {
            System.out.println("rootAssets null: use 'GameAssets.InitAssets()'");
            return null;
        }
        if (name == null || name.equals("")) return null;
        File file = new File(assetsData, name);
        if (file.exists()) {
            return file;
        } else {
            return null;
        }
    }

    public static File LoadAssetsFont(String name) {
        if (!rootAssets.exists()) {
            System.out.println("rootAssets null: use 'GameAssets.InitAssets()'");
            return null;
        }
        if (name == null || name.equals("")) return null;
        File file = new File(assetsFont, name);
        if (file.exists()) {
            return file;
        } else {
            return null;
        }
    }

    public static File LoadAssetsImages(String name) {
        if (!rootAssets.exists()) {
            System.out.println("rootAssets null: use 'GameAssets.InitAssets()'");
            return null;
        }
        if (name == null || name.equals("")) return null;
        File file = new File(assetsImages, name);
        if (file.exists()) {
            return file;
        } else {
            return null;
        }
    }

    public static File LoadAssetsVideo(String name) {
        if (!rootAssets.exists()) {
            System.out.println("rootAssets null: use 'GameAssets.InitAssets()'");
            return null;
        }
        if (name == null || name.equals("")) return null;
        File file = new File(assetsVideo, name);
        if (file.exists()) {
            return file;
        } else {
            return null;
        }
    }

}
