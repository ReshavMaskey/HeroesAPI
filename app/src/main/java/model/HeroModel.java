package model;

import com.google.gson.annotations.SerializedName;

public class HeroModel {

    private String _id;
    private String name;
    private String desc;

    public HeroModel(String id, String name, String desc) {
        this._id = id;
        this.name = name;
        this.desc = desc;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
