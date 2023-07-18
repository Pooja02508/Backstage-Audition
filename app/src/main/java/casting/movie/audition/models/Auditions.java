package casting.movie.audition.models;

public class Auditions {

    String title,jobs,trainee;
    String image;

    public Auditions(String image) {
        this.image = image;
    }

    public Auditions(String title, String image) {
        this.title = title;
        this.image = image;
    }

    public Auditions(String title, String image,String jobs,String trainee) {
        this.title = title;
        this.image = image;
        this.jobs = jobs;
        this.trainee = trainee;
    }
    public Auditions(String image,String jobs,String trainee) {
        this.image = image;
        this.jobs = jobs;
        this.trainee = trainee;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getJobs() {
        return jobs;
    }

    public void setJobs(String jobs) {
        this.jobs = jobs;
    }

    public String getTrainee() {
        return trainee;
    }

    public void setTrainee(String trainee) {
        this.trainee = trainee;
    }

}
