package model;


/**
 * Entity class for store in DB
 */
public class ResumeItem {

    private long id;
    private long idOriginal;
    private String fio;
    private int age;
    private String resumeLink;
    private String positionName;
    private String lastVisit;
    private String city;
    private String wageLevel;
    private String education;
    private String experience;
    private String lastPlaceOfWork;
    private String lastPositionName;
    private String lastPlaceDuration;
    private String pictureLink;

    public ResumeItem( long idOriginal, String fio, int age, String resumeLink, String positionName, String lastVisit, String city, String wageLevel, String education, String experience, String lastPlaceOfWork, String lastPositionName, String lastPlaceDuration, String pictureLink) {
        this.idOriginal = idOriginal;
        this.fio = fio;
        this.age = age;
        this.resumeLink = resumeLink;
        this.positionName = positionName;
        this.lastVisit = lastVisit;
        this.city = city;
        this.wageLevel = wageLevel;
        this.education = education;
        this.experience = experience;
        this.lastPlaceOfWork = lastPlaceOfWork;
        this.lastPositionName = lastPositionName;
        this.lastPlaceDuration = lastPlaceDuration;
        this.pictureLink = pictureLink;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResumeItem that = (ResumeItem) o;

        if (id != that.id) return false;
        if (idOriginal != that.idOriginal) return false;
        if (age != that.age) return false;
        if (wageLevel != that.wageLevel) return false;
        if (!fio.equals(that.fio)) return false;
        if (!resumeLink.equals(that.resumeLink)) return false;
        if (!positionName.equals(that.positionName)) return false;
        if (lastVisit != null ? !lastVisit.equals(that.lastVisit) : that.lastVisit != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (education != null ? !education.equals(that.education) : that.education != null) return false;
        if (experience != null ? !experience.equals(that.experience) : that.experience != null) return false;
        if (lastPlaceOfWork != null ? !lastPlaceOfWork.equals(that.lastPlaceOfWork) : that.lastPlaceOfWork != null)
            return false;
        if (lastPositionName != null ? !lastPositionName.equals(that.lastPositionName) : that.lastPositionName != null)
            return false;
        if (lastPlaceDuration != null ? !lastPlaceDuration.equals(that.lastPlaceDuration) : that.lastPlaceDuration != null)
            return false;
        return pictureLink != null ? pictureLink.equals(that.pictureLink) : that.pictureLink == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idOriginal ^ (idOriginal >>> 32));
        result = 31 * result + fio.hashCode();
        result = 31 * result + age;
        result = 31 * result + resumeLink.hashCode();
        result = 31 * result + positionName.hashCode();
        result = 31 * result + (lastVisit != null ? lastVisit.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + wageLevel.hashCode();
        result = 31 * result + (education != null ? education.hashCode() : 0);
        result = 31 * result + (experience != null ? experience.hashCode() : 0);
        result = 31 * result + (lastPlaceOfWork != null ? lastPlaceOfWork.hashCode() : 0);
        result = 31 * result + (lastPositionName != null ? lastPositionName.hashCode() : 0);
        result = 31 * result + (lastPlaceDuration != null ? lastPlaceDuration.hashCode() : 0);
        result = 31 * result + (pictureLink != null ? pictureLink.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ResumeItem{" +
                "id=" + id +
                ", idOriginal=" + idOriginal +
                ", fio='" + fio + '\'' +
                ", age=" + age +
                ", resumeLink='" + resumeLink + '\'' +
                ", positionName='" + positionName + '\'' +
                ", lastVisit='" + lastVisit + '\'' +
                ", city='" + city + '\'' +
                ", wageLevel='" + wageLevel + '\'' +
                ", education='" + education + '\'' +
                ", experience='" + experience + '\'' +
                ", lastPlaceOfWork='" + lastPlaceOfWork + '\'' +
                ", lastPositionName='" + lastPositionName + '\'' +
                ", lastPlaceDuration='" + lastPlaceDuration + '\'' +
                ", pictureLink='" + pictureLink + '\'' +
                '}';
    }
}
