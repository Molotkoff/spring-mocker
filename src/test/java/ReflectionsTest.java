import controller.BaseRestController;
import controller.RestControllerInterceptor;
import lombok.SneakyThrows;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.implementation.MethodDelegation;
import org.junit.Test;
import org.springframework.web.bind.annotation.GetMapping;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class ReflectionsTest {

    @Test
    @SneakyThrows
    public void CreateRestControllerProxy() {
        AnnotationDescription annotation = AnnotationDescription.Latent.Builder.ofType(GetMapping.class).build();

        BaseRestController restController = new BaseRestController("TRATATA");
        BaseRestController object = new ByteBuddy()
                .subclass(BaseRestController.class)
                .method(named("process"))
                .intercept(MethodDelegation.to(new RestControllerInterceptor(restController)))
                .annotateMethod()
                .make()
                .load(BaseRestController.class.getClassLoader())
                .getLoaded()
                .getDeclaredConstructor()
                .newInstance();

        String i = object.process();
        int il = 5;
    }
}
