package com.tongming.materialbili.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Tongming on 2016/4/4.
 */
public class LiveVideo {


    private DataEntity data;

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public static class DataEntity {

        private List<PartitionsEntity> partitions;

        public List<PartitionsEntity> getPartitions() {
            return partitions;
        }

        public void setPartitions(List<PartitionsEntity> partitions) {
            this.partitions = partitions;
        }

        public static class PartitionsEntity {

            private PartitionEntity partition;

            private List<LivesEntity> lives;

            public PartitionEntity getPartition() {
                return partition;
            }

            public void setPartition(PartitionEntity partition) {
                this.partition = partition;
            }

            public List<LivesEntity> getLives() {
                return lives;
            }

            public void setLives(List<LivesEntity> lives) {
                this.lives = lives;
            }

            public static class PartitionEntity {
                private int id;
                private String name;
                private String area;

                private SubIconEntity sub_icon;
                private int count;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getArea() {
                    return area;
                }

                public void setArea(String area) {
                    this.area = area;
                }

                public SubIconEntity getSub_icon() {
                    return sub_icon;
                }

                public void setSub_icon(SubIconEntity sub_icon) {
                    this.sub_icon = sub_icon;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public static class SubIconEntity {
                    private String src;
                    private String height;
                    private String width;

                    public String getSrc() {
                        return src;
                    }

                    public void setSrc(String src) {
                        this.src = src;
                    }

                    public String getHeight() {
                        return height;
                    }

                    public void setHeight(String height) {
                        this.height = height;
                    }

                    public String getWidth() {
                        return width;
                    }

                    public void setWidth(String width) {
                        this.width = width;
                    }
                }
            }

            public static class LivesEntity implements Parcelable{

                private OwnerEntity owner;

                private CoverEntity cover;
                private String title;
                private int room_id;
                private int online;

                public OwnerEntity getOwner() {
                    return owner;
                }

                public void setOwner(OwnerEntity owner) {
                    this.owner = owner;
                }

                public CoverEntity getCover() {
                    return cover;
                }

                public void setCover(CoverEntity cover) {
                    this.cover = cover;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getRoom_id() {
                    return room_id;
                }

                public void setRoom_id(int room_id) {
                    this.room_id = room_id;
                }

                public int getOnline() {
                    return online;
                }

                public void setOnline(int online) {
                    this.online = online;
                }

                public static class OwnerEntity implements Parcelable {
                    private String face;
                    private int mid;
                    private String name;

                    public String getFace() {
                        return face;
                    }

                    public void setFace(String face) {
                        this.face = face;
                    }

                    public int getMid() {
                        return mid;
                    }

                    public void setMid(int mid) {
                        this.mid = mid;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }


                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    @Override
                    public void writeToParcel(Parcel dest, int flags) {
                        dest.writeString(this.face);
                        dest.writeInt(this.mid);
                        dest.writeString(this.name);
                    }

                    public OwnerEntity() {
                    }

                    protected OwnerEntity(Parcel in) {
                        this.face = in.readString();
                        this.mid = in.readInt();
                        this.name = in.readString();
                    }

                    public static final Creator<OwnerEntity> CREATOR = new Creator<OwnerEntity>() {
                        @Override
                        public OwnerEntity createFromParcel(Parcel source) {
                            return new OwnerEntity(source);
                        }

                        @Override
                        public OwnerEntity[] newArray(int size) {
                            return new OwnerEntity[size];
                        }
                    };
                }

                public static class CoverEntity implements Parcelable {
                    private String src;
                    private int height;
                    private int width;

                    public String getSrc() {
                        return src;
                    }

                    public void setSrc(String src) {
                        this.src = src;
                    }

                    public int getHeight() {
                        return height;
                    }

                    public void setHeight(int height) {
                        this.height = height;
                    }

                    public int getWidth() {
                        return width;
                    }

                    public void setWidth(int width) {
                        this.width = width;
                    }


                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    @Override
                    public void writeToParcel(Parcel dest, int flags) {
                        dest.writeString(this.src);
                        dest.writeInt(this.height);
                        dest.writeInt(this.width);
                    }

                    public CoverEntity() {
                    }

                    protected CoverEntity(Parcel in) {
                        this.src = in.readString();
                        this.height = in.readInt();
                        this.width = in.readInt();
                    }

                    public static final Creator<CoverEntity> CREATOR = new Creator<CoverEntity>() {
                        @Override
                        public CoverEntity createFromParcel(Parcel source) {
                            return new CoverEntity(source);
                        }

                        @Override
                        public CoverEntity[] newArray(int size) {
                            return new CoverEntity[size];
                        }
                    };
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeParcelable(this.owner, flags);
                    dest.writeParcelable(this.cover, flags);
                    dest.writeString(this.title);
                    dest.writeInt(this.room_id);
                    dest.writeInt(this.online);
                }

                public LivesEntity() {
                }

                protected LivesEntity(Parcel in) {
                    this.owner = in.readParcelable(OwnerEntity.class.getClassLoader());
                    this.cover = in.readParcelable(CoverEntity.class.getClassLoader());
                    this.title = in.readString();
                    this.room_id = in.readInt();
                    this.online = in.readInt();
                }

                public static final Creator<LivesEntity> CREATOR = new Creator<LivesEntity>() {
                    @Override
                    public LivesEntity createFromParcel(Parcel source) {
                        return new LivesEntity(source);
                    }

                    @Override
                    public LivesEntity[] newArray(int size) {
                        return new LivesEntity[size];
                    }
                };
            }
        }
    }
}
