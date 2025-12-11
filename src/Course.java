public class Course {
    private String code;
    private String title;
    private int credits;

    public Course(String code, String title, int credits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
    }

    // Getters / Setters
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }

    @Override
    public String toString() {
        return code + " : " + title + " (" + credits + "cr)";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Course)) return false;
        Course c = (Course) obj;
        return this.code.equals(c.code);
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }
}
