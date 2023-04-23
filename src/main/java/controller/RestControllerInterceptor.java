package controller;

public class RestControllerInterceptor {
    private BaseRestController restController;

    public RestControllerInterceptor(BaseRestController restController) {
        this.restController = restController;
    }

    public String process() {
        return restController.process().toUpperCase();
    }
}
