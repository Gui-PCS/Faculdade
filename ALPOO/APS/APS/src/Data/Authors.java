package Data;

public class Authors {
    private int author_id;
    private String name;
    private String fname;

    public Authors(int author_id, String name, String fname) {
        this.author_id = author_id;
        this.name = name;
        this.fname = fname;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public String getName() {
        return name;
    }

    public String getFname() {
        return fname;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Override
    public String toString() {
        return "Authors{" + "author_id=" + author_id + ", name=" + name + ", fname=" + fname + '}';
    }
}
