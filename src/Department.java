public class Department {
    private String code;
    private String name;

    public Department(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // Getters / Setters
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return code + " - " + name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Department)) return false;
        Department d = (Department) obj;
        return this.code.equals(d.code);
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }
}
