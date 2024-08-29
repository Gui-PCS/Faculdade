package data;

public class Authors {
    private int id;
    private String fname;
    private String name;

    public Authors(int id, String fname, String name) {
        this.id = id;
        this.fname = fname;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Authors{" + "id=" + id + ", fname=" + fname + ", name=" + name + '}';
    }
    
}
