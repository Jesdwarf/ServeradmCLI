package com.gr9001.Models;

import java.util.Date;

public class Droplet {
    int id;
    String name;
    int memory;
    int vcpus;
    int disk;
    boolean locked;
    String status;
    Kernel kernel;
    Date created_at;
    String[] features;

    int[] snapshot_ids;
    Image image;
    Size size;
    String size_slug;
    Networks networks;
    Region region;
    String vpc_uuid;

    class Kernel {
        int id;
        String name;
        String version;
    }

    class Image {
        int id;
        String name;
        String distribution;
        String slug;
        String[] regions;
        Date created_at;
        String type;
        int min_disk_size;
        int size_gigabytes;
    }

    class Size {
        String price_monthly;
        String price_hourly;
    }

    class v4 {
        String ip_address;
        String netmask;
        String gateway;
        String type;
    }

    class v6 {
        String ip_address;
        String netmask;
        String gateway;
        String type;
    }

    class Networks {
        v4[] v4;
        v6[] v6;
    }

    class Region {
        String name;
        String slug;
        String[] sizes;
        String[] features;
        boolean available;
    }

}