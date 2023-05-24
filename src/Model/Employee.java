package Model;

import java.util.Date;

public class Employee {

    private String nif;
    private String name;
    private String firstLastname;
    private String secondLastname;
    private String account;
    private int ss_number;
    private int seniority;
    private boolean permanentJob;
    private String dept;
    private String group;

    public Employee(String nif, String name, String firstLastname, String secondLastname, String account,
                    int ss_number, int seniority, boolean permanentJob, String dept, String group) {
        this.nif = nif;
        this.name = name;
        this.firstLastname = firstLastname;
        this.secondLastname = secondLastname;
        this.account = account;
        this.ss_number = ss_number;
        this.seniority = seniority;
        this.permanentJob = permanentJob;
        this.dept = dept;
        this.group = group;
    }

    public String getNIF() {
        return nif;
    }

    public void setNIF(String nif) {
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstLastname() {
        return firstLastname;
    }

    public void setFirstLastname(String firstLastname) {
        this.firstLastname = firstLastname;
    }

    public String getSecondLastname() {
        return secondLastname;
    }

    public void setSecondLastname(String secondLastname) {
        this.secondLastname = secondLastname;
    }

    public int getSS_number() {
        return ss_number;
    }

    public void setSS_number(int ss_number) {
        this.ss_number = ss_number;
    }

    public int getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    public boolean getPermanentJob() {
        return permanentJob;
    }

    public void setPermanentJob(boolean permanentJob) {
        this.permanentJob = permanentJob;
    }

    public String getAccount() {
        return account;
    }

    public String getDept() {
        return dept;
    }

    public String getGroup() {
        return group;
    }
}
