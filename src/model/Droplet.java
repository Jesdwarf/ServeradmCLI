package model;

import java.util.Date;

public class Droplet {
    public int id;
    public String name;
    public int memory;
    public int vcpus;
    public int disk;
    public boolean locked;
    public String status;
    public Kernel kernel;
    public Date created_at;
    public String[] features;

    public int[] snapshot_ids;
    public Image image;
    public Size size;
    public String size_slug;
    public Networks networks;
    public Region region;
    public String vpc_uuid;

    @Override
    public String toString() {
        return String.format("%-20.20s | %-29.29s | %-17.17s | %-9.9s | %s$ / %s$", name, created_at, networks.v4[0].ip_address, status, size.price_monthly, size.price_hourly);
    }

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
        double size_gigabytes;
    }

    public class Size {
        public String price_monthly;
        public String price_hourly;
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