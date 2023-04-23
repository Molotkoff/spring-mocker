package controller;

public class BaseRestController implements IRestController{
    private String name;

    public BaseRestController(String name) {
        this.name = name;
    }

    public BaseRestController() {

    }

    public String process() {
        return name;
    }
}
