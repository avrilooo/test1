package lianxi;

import java.util.Objects;

public class shengfensql {
    //private String name;
    private String jiancheng;
    private String shenghui;

    public shengfensql() {
    }

    public shengfensql(String jiancheng, String shenghui) {
        this.jiancheng = jiancheng;
        this.shenghui = shenghui;
    }

    public String getJiancheng() {
        return jiancheng;
    }

    public void setJiancheng(String jiancheng) {
        this.jiancheng = jiancheng;
    }

    public String getShenghui() {
        return shenghui;
    }

    public void setShenghui(String shenghui) {
        this.shenghui = shenghui;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        shengfensql that = (shengfensql) o;
        return Objects.equals(jiancheng, that.jiancheng) && Objects.equals(shenghui, that.shenghui);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jiancheng, shenghui);
    }
}
