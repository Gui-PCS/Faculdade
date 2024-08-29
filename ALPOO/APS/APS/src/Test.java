import Controller.Controller;

public class Test {
    public static void main(String[] args) {
        Model.Model model = new Model.implementation.ModelNotPersistent();
        View.View view = new View.implementation.ViewTerminal();
        new Controller(view, model).init();
    }
    
}
