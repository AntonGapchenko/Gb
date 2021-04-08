import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class Tester {

    public static void start(Class classTest) throws InvocationTargetException, IllegalAccessException {
        Method beforeMethod = null;
        Method afterMethod = null;
        ArrayList<Method> testMethods = new ArrayList<>();

        Object object = null;
        try {
            object = classTest.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        for (Method m : classTest.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                testMethods.add(m);
            } else if (m.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeMethod == null) {
                    beforeMethod = m;
                } else {
                    throw new RuntimeException("Должен быть один метод @BeforeSuite");
                }
            } if (m.isAnnotationPresent(AfterSuite.class)) {
                if (afterMethod == null) {
                    afterMethod = m;
                } else {
                    throw new RuntimeException("Должен быть один метод @AfterSuite");
                }
            }
        }

        if (beforeMethod != null) {
            beforeMethod.invoke(object);
        }

        testMethods.sort(Comparator.comparingInt(o -> o.getAnnotation(Test.class).priority()));
        for (Method m : testMethods) {
            m.invoke(object);
        }

        if (afterMethod != null) {
            afterMethod.invoke(object);
        }
    }
}