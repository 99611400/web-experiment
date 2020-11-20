package tech.haonan.entity;

/**
 * @Author: yhn
 * @Date: 11/12/2020 7:09 PM
 * @Description:
 **/

/*
create table worker(
    workerno int primary key ,
    workname varchar(1000),
    workerage int ,
    workerdesc varchar(1000)
)charset utf8



* */
public class Worker {
    private  Integer workerno;
    private String workname;
    private Integer workerage;
    private String workerdesc;

    public Integer getWorkerno() {
        return workerno;
    }

    public void setWorkerno(Integer workerno) {
        this.workerno = workerno;
    }

    public String getWorkname() {
        return workname;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "workerno=" + workerno +
                ", workname='" + workname + '\'' +
                ", workerage=" + workerage +
                ", workerdesc='" + workerdesc + '\'' +
                '}';
    }

    public void setWorkname(String workname) {
        this.workname = workname;
    }

    public Integer getWorkerage() {
        return workerage;
    }

    public void setWorkerage(Integer workerage) {
        this.workerage = workerage;
    }

    public String getWorkerdesc() {
        return workerdesc;
    }

    public void setWorkerdesc(String workerdesc) {
        this.workerdesc = workerdesc;
    }

    public Worker(Integer workerno, String workname, Integer workerage, String workerdesc) {
        this.workerno = workerno;
        this.workname = workname;
        this.workerage = workerage;
        this.workerdesc = workerdesc;
    }
}
