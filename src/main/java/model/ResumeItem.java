package model;

import java.util.Date;

/**
 * Entity class for store in DB
 */
public class ResumeItem {

    private long id;
    private String fio;
    private String positionName;
    private String fotoLink;
    private int wageLevel;
    private int age;
    private Date lastVisitDate;
    private String city;
    private String lastPlaceOfWork;
    private String lastPositionName;
    private String lastPlaceDuration;
    private String resumeLink;

    public ResumeItem(long id, String fio, String positionName, String fotoLink, int wageLevel, int age, Date lastVisitDate, String city, String lastPlaceOfWork, String lastPositionName, String lastPlaceDuration, String resumeLink) {
        this.id = id;
        this.fio = fio;
        this.positionName = positionName;
        this.fotoLink = fotoLink;
        this.wageLevel = wageLevel;
        this.age = age;
        this.lastVisitDate = lastVisitDate;
        this.city = city;
        this.lastPlaceOfWork = lastPlaceOfWork;
        this.lastPositionName = lastPositionName;
        this.lastPlaceDuration = lastPlaceDuration;
        this.resumeLink = resumeLink;
    }

    public int getWageLevel() {
        return wageLevel;
    }

    public void setWageLevel(int wageLevel) {
        this.wageLevel = wageLevel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getFotoLink() {
        return fotoLink;
    }

    public void setFotoLink(String fotoLink) {
        this.fotoLink = fotoLink;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getLastVisitDate() {
        return lastVisitDate;
    }

    public void setLastVisitDate(Date lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLastPlaceOfWork() {
        return lastPlaceOfWork;
    }

    public void setLastPlaceOfWork(String lastPlaceOfWork) {
        this.lastPlaceOfWork = lastPlaceOfWork;
    }

    public String getLastPositionName() {
        return lastPositionName;
    }

    public void setLastPositionName(String lastPositionName) {
        this.lastPositionName = lastPositionName;
    }

    public String getLastPlaceDuration() {
        return lastPlaceDuration;
    }

    public void setLastPlaceDuration(String lastPlaceDuration) {
        this.lastPlaceDuration = lastPlaceDuration;
    }

    public String getResumeLink() {
        return resumeLink;
    }

    public void setResumeLink(String resumeLink) {
        this.resumeLink = resumeLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResumeItem that = (ResumeItem) o;

        if (getId() != that.getId()) return false;
        if (getWageLevel() != that.getWageLevel()) return false;
        if (getAge() != that.getAge()) return false;
        if (!getFio().equals(that.getFio())) return false;
        if (!getPositionName().equals(that.getPositionName())) return false;
        if (getFotoLink() != null ? !getFotoLink().equals(that.getFotoLink()) : that.getFotoLink() != null)
            return false;
        if (getLastVisitDate() != null ? !getLastVisitDate().equals(that.getLastVisitDate()) : that.getLastVisitDate() != null)
            return false;
        if (getCity() != null ? !getCity().equals(that.getCity()) : that.getCity() != null) return false;
        if (getLastPlaceOfWork() != null ? !getLastPlaceOfWork().equals(that.getLastPlaceOfWork()) : that.getLastPlaceOfWork() != null)
            return false;
        if (getLastPositionName() != null ? !getLastPositionName().equals(that.getLastPositionName()) : that.getLastPositionName() != null)
            return false;
        if (getLastPlaceDuration() != null ? !getLastPlaceDuration().equals(that.getLastPlaceDuration()) : that.getLastPlaceDuration() != null)
            return false;
        return getResumeLink().equals(that.getResumeLink());
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getFio().hashCode();
        result = 31 * result + getPositionName().hashCode();
        result = 31 * result + (getFotoLink() != null ? getFotoLink().hashCode() : 0);
        result = 31 * result + getWageLevel();
        result = 31 * result + getAge();
        result = 31 * result + (getLastVisitDate() != null ? getLastVisitDate().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + (getLastPlaceOfWork() != null ? getLastPlaceOfWork().hashCode() : 0);
        result = 31 * result + (getLastPositionName() != null ? getLastPositionName().hashCode() : 0);
        result = 31 * result + (getLastPlaceDuration() != null ? getLastPlaceDuration().hashCode() : 0);
        result = 31 * result + getResumeLink().hashCode();
        return result;
    }
}
