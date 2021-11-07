
import org.junit.Test;
import org.junit.After;

import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.Before;
import org.junit.rules.Timeout;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * A framework to run public test cases.
 *
 * <p>Purdue University -- CS18000 -- Fall 2021</p>
 *
 * @author Purdue CS
 * @version August 23, 2021
 */
public class RunLocalTest {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestCase.class);
        if (result.wasSuccessful()) {
            System.out.println("Excellent - Test ran successfully");
        } else {
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
        }
    }

    /**
     * A set of public test cases.
     *
     *
     * <p>Purdue University -- CS18000 -- Fall 2021</p>
     *
     * @author Purdue CS
     * @version August 23, 2021
     */
    public static class TestCase {
        private final PrintStream originalOutput = System.out;
        private final InputStream originalSysin = System.in;

        @SuppressWarnings("FieldCanBeLocal")
        private ByteArrayInputStream testIn;

        @SuppressWarnings("FieldCanBeLocal")
        private ByteArrayOutputStream testOut;

        @Before
        public void outputStart() {
            testOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(testOut));
        }

        @After
        public void restoreInputAndOutput() {
            System.setIn(originalSysin);
            System.setOut(originalOutput);
        }

        private String getOutput() {
            return testOut.toString();
        }

        @SuppressWarnings("SameParameterValue")
        private void receiveInput(String str) {
            testIn = new ByteArrayInputStream(str.getBytes());
            System.setIn(testIn);
        }

        @Test(timeout = 1000)
        public void classDeclarationTestCourseCatalog() {
            String className = "CourseCatalog";
            Class<?> clazz;

            try {
                clazz = Class.forName(className);

                int modifiers = clazz.getModifiers();

                Class<?>[] superinterfaces = clazz.getInterfaces();

                assertTrue("Ensure that `" + className + "` is `public`!", Modifier.isPublic(modifiers));

                assertFalse("Ensure that `" + className + "` is NOT `abstract`!", Modifier.isAbstract(modifiers));

                Assert.assertEquals("Ensure that `" + className + "` implements no interfaces!", 0, superinterfaces.length);
            } catch (Exception e) {
                e.printStackTrace();
                Assert.fail("Error: " + e);
            }


        }

        @Test(timeout = 1000)
        public void methodTestCourseCatalogMain() {
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "main";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;

            // Set the class being tested
            String className = "CourseCatalog";
            Class<?> clazz;

            try {
                clazz = Class.forName(className);
                method = clazz.getDeclaredMethod(methodName, String[].class);

                // Perform tests

                modifiers = method.getModifiers();

                actualReturnType = method.getReturnType();

                exceptions = method.getExceptionTypes();

                Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

                Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `static`!", Modifier.isStatic(modifiers));

                Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

                Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + " declares a method named `" + methodName + "` that" +
                        " has 1 parameter!");

                return;
            } catch (Exception e) {
                Assert.fail("Error: " + e);
            } //end try catch
        }

        @Test(timeout = 1000)
        public void methodTestCourseCatalogReadFile() {
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "readFile";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = String[].class;

            // Set the class being tested
            String className = "CourseCatalog";
            Class<?> clazz;

            try {
                clazz = Class.forName(className);
                method = clazz.getDeclaredMethod(methodName, String.class);

                // Perform tests

                modifiers = method.getModifiers();

                actualReturnType = method.getReturnType();

                exceptions = method.getExceptionTypes();

                Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

                Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `static`!", Modifier.isStatic(modifiers));

                Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

                Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method throws 'Exception'!", expectedLength, exceptions.length);

                Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method throws 'Exception'!", Exception.class, exceptions[0]);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + " declares a method named `" + methodName + "` that" +
                        " has 1 parameter!");

                return;
            } catch (Exception e) {
                Assert.fail("Error: " + e);
            } //end try catch
        }

        @Test(timeout = 1000)
        public void methodTestCourseCatalogWriteFile() {
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "writeFile";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;

            // Set the class being tested
            String className = "CourseCatalog";
            Class<?> clazz;

            try {
                clazz = Class.forName(className);
                method = clazz.getDeclaredMethod(methodName, String[].class, String.class);

                // Perform tests

                modifiers = method.getModifiers();

                actualReturnType = method.getReturnType();

                exceptions = method.getExceptionTypes();

                Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

                Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `static`!", Modifier.isStatic(modifiers));

                Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

                Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method throws 'Exception'!", expectedLength, exceptions.length);

                Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method throws 'Exception'!", Exception.class, exceptions[0]);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + " declares a method named `" + methodName + "` that" +
                        " has 2 parameters!");

                return;
            } catch (Exception e) {
                Assert.fail("Error: " + e);
            } //end try catch
        }

        @Test(timeout = 1000)
        public void classDeclarationTestStudent() {
            String className = "Student";
            Class<?> clazz;

            try {
                clazz = Class.forName(className);

                int modifiers = clazz.getModifiers();

                Class<?>[] superinterfaces = clazz.getInterfaces();

                assertTrue("Ensure that `" + className + "` is `public`!", Modifier.isPublic(modifiers));

                assertTrue("Ensure that `" + className + "` is an 'interface'!", Modifier.isInterface(modifiers));

                Assert.assertEquals("Ensure that `" + className + "` implements no interfaces!", 0, superinterfaces.length);
            } catch (Exception e) {
                e.printStackTrace();
                Assert.fail("Error: " + e);
            }


        }

        @Test(timeout = 1000)
        public void classDeclarationTestHighSchoolStudent() {
            String className = "HighSchoolStudent";
            Class<?> clazz;

            try {
                clazz = Class.forName(className);

                int modifiers = clazz.getModifiers();

                Class<?>[] superinterfaces = clazz.getInterfaces();

                assertTrue("Ensure that `" + className + "` is `public`!", Modifier.isPublic(modifiers));

                assertFalse("Ensure that `" + className + "` is NOT `abstract`!", Modifier.isAbstract(modifiers));

                Assert.assertEquals("Ensure that `" + className + "` implements 1 interfaces!", 1, superinterfaces.length);
            } catch (Exception e) {
                e.printStackTrace();
                Assert.fail("Error: " + e);
            }


        }

        @Test(timeout = 1000)
        public void classDeclarationTestCollegeStudent() {
            String className = "CollegeStudent";
            Class<?> clazz;

            try {
                clazz = Class.forName(className);

                int modifiers = clazz.getModifiers();

                Class<?>[] superinterfaces = clazz.getInterfaces();

                assertTrue("Ensure that `" + className + "` is `public`!", Modifier.isPublic(modifiers));

                assertFalse("Ensure that `" + className + "` is NOT `abstract`!", Modifier.isAbstract(modifiers));

                Assert.assertEquals("Ensure that `" + className + "` implements 1 interface!", 1, superinterfaces.length);
            } catch (Exception e) {
                e.printStackTrace();
                Assert.fail("Error: " + e);
            }


        }

        @Test(timeout = 1000)
        public void methodTestStudentFilterCoursesByCatalogTitle() {
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "filterCoursesByCatalogTitle";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = String[].class;

            // Set the class being tested
            String className = "Student";
            Class<?> clazz;

            try {
                clazz = Class.forName(className);
                method = clazz.getDeclaredMethod(methodName, String.class);

                // Perform tests

                modifiers = method.getModifiers();

                actualReturnType = method.getReturnType();

                exceptions = method.getExceptionTypes();

                Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

                Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

                Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method does NOT throw an Exception", expectedLength, exceptions.length);

                Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is abstract!", Modifier.isAbstract(modifiers));
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + " declares a method named `" + methodName + "` that" +
                        " has 1 parameter!");

                return;
            } catch (Exception e) {
                Assert.fail("Error: " + e);
            } //end try catch
        }

        @Test(timeout = 1000)
        public void methodTestStudentFilterCoursesByAcademicLevel() {
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "filterCoursesByAcademicLevel";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = String[].class;

            // Set the class being tested
            String className = "Student";
            Class<?> clazz;

            try {
                clazz = Class.forName(className);
                method = clazz.getDeclaredMethod(methodName);

                // Perform tests

                modifiers = method.getModifiers();

                actualReturnType = method.getReturnType();

                exceptions = method.getExceptionTypes();

                Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

                Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

                Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method does NOT throw an Exception", expectedLength, exceptions.length);

                Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is abstract!", Modifier.isAbstract(modifiers));
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + " declares a method named `" + methodName + "` that" +
                        " has 1 parameter!");

                return;
            } catch (Exception e) {
                Assert.fail("Error: " + e);
            } //end try catch
        }

        @Test(timeout = 1000)
        public void methodTestStudentCanTakeCollegeCourses() {
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "canTakeCollegeCourses";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = boolean.class;

            // Set the class being tested
            String className = "Student";
            Class<?> clazz;

            try {
                clazz = Class.forName(className);
                method = clazz.getDeclaredMethod(methodName);

                // Perform tests

                modifiers = method.getModifiers();

                actualReturnType = method.getReturnType();

                exceptions = method.getExceptionTypes();

                Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

                Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

                Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method does NOT throw an Exception", expectedLength, exceptions.length);

                Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is abstract!", Modifier.isAbstract(modifiers));
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + " declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } catch (Exception e) {
                Assert.fail("Error: " + e);
            } //end try catch
        }

        @Test(timeout = 1000)
        public void methodTestStudentCanTakeHighSchoolCourses() {
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "canTakeHighSchoolCourses";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = boolean.class;

            // Set the class being tested
            String className = "Student";
            Class<?> clazz;

            try {
                clazz = Class.forName(className);
                method = clazz.getDeclaredMethod(methodName);

                // Perform tests

                modifiers = method.getModifiers();

                actualReturnType = method.getReturnType();

                exceptions = method.getExceptionTypes();

                Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

                Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

                Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method does NOT throw an Exception", expectedLength, exceptions.length);

                Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is abstract!", Modifier.isAbstract(modifiers));
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + " declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } catch (Exception e) {
                Assert.fail("Error: " + e);
            } //end try catch
        }

        @Test(timeout = 1_000)
        public void fieldDeclarationTestCollegeStudentName() {
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "name";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Set the class being tested
            String className = "CollegeStudent";
            Class<?> clazz;

            try {
                clazz = Class.forName(className);
                testField = clazz.getDeclaredField(fieldName);

                // Perform tests

                modifiers = testField.getModifiers();

                type = testField.getType();

                Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

                Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `final`!", Modifier.isFinal(modifiers));

                Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

                Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);

            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + " declares a field named `" + fieldName + "`!");

                return;
            } catch (Exception e) {
                e.printStackTrace();
                Assert.fail("Error: " + e);
            } //end try catch


        }

        @Test(timeout = 1_000)
        public void fieldDeclarationTestCollegeStudentCourses() {
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "courses";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String[].class;

            // Set the class being tested
            String className = "CollegeStudent";
            Class<?> clazz;

            try {
                clazz = Class.forName(className);
                testField = clazz.getDeclaredField(fieldName);

                // Perform tests

                modifiers = testField.getModifiers();

                type = testField.getType();

                Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

                Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `final`!", Modifier.isFinal(modifiers));

                Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

                Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);

            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + " declares a field named `" + fieldName + "`!");

                return;
            } catch (Exception e) {
                e.printStackTrace();
                Assert.fail("Error: " + e);
            } //end try catch


        }

        @Test(timeout = 1_000)
        public void parameterizedConstructorDeclarationTestCollegeStudent() {
            Constructor<?> constructor;
            int modifiers;
            Class<?>[] exceptions;
            int expectedLength = 0;
            boolean set;

            // Set the class being tested
            String className = "CollegeStudent";
            Class<?> clazz;

            try {
                clazz = Class.forName(className);
                constructor = clazz.getDeclaredConstructor(String.class, String[].class);

                modifiers = constructor.getModifiers();

                exceptions = constructor.getExceptionTypes();

                Assert.assertTrue("Ensure that `" + className + "'s parameterized constructor is `public`!", Modifier.isPublic(modifiers));

                Assert.assertEquals("Ensure that `" + className + "''s parameterized constructor has no `throws` clauses!", expectedLength, exceptions.length);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "' declares a constructor that is `public` and has two parameters, one String and one String[]!");

                return;
            }  catch (Exception e) {
                Assert.fail("Error: " + e);
            } // end try-catch


        }

        @Test(timeout = 1000)
        public void methodTestCollegeStudentToString() {
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "toString";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = String.class;

            // Set the class being tested
            String className = "CollegeStudent";
            Class<?> clazz;

            try {
                clazz = Class.forName(className);
                method = clazz.getDeclaredMethod(methodName);

                // Perform tests

                modifiers = method.getModifiers();

                actualReturnType = method.getReturnType();

                exceptions = method.getExceptionTypes();

                Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

                Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

                Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method does NOT throw an Exception", expectedLength, exceptions.length);

                Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT abstract!", Modifier.isAbstract(modifiers));
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + " declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } catch (Exception e) {
                Assert.fail("Error: " + e);
            } //end try catch
        }

        @Test(timeout = 1000)
        public void methodTestCollegeStudentEquals() {
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "equals";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = boolean.class;

            // Set the class being tested
            String className = "CollegeStudent";
            Class<?> clazz;

            try {
                clazz = Class.forName(className);
                method = clazz.getDeclaredMethod(methodName, Object.class);

                // Perform tests

                modifiers = method.getModifiers();

                actualReturnType = method.getReturnType();

                exceptions = method.getExceptionTypes();

                Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

                Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

                Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method does NOT throw an Exception", expectedLength, exceptions.length);

                Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT abstract!", Modifier.isAbstract(modifiers));
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + " declares a method named `" + methodName + "` that" +
                        " has 1 parameters!");

                return;
            } catch (Exception e) {
                Assert.fail("Error: " + e);
            } //end try catch
        }

        @Test(timeout = 1000)
        public void methodTestCollegeStudentGetName() {
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "getName";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = String.class;

            // Set the class being tested
            String className = "CollegeStudent";
            Class<?> clazz;

            try {
                clazz = Class.forName(className);
                method = clazz.getDeclaredMethod(methodName);

                // Perform tests

                modifiers = method.getModifiers();

                actualReturnType = method.getReturnType();

                exceptions = method.getExceptionTypes();

                Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

                Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

                Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method does NOT throw an Exception", expectedLength, exceptions.length);

                Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT abstract!", Modifier.isAbstract(modifiers));
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + " declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } catch (Exception e) {
                Assert.fail("Error: " + e);
            } //end try catch
        }

        @Test(timeout = 1000)
        public void methodTestCollegeStudentGetCourses() {
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "getCourses";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = String[].class;

            // Set the class being tested
            String className = "CollegeStudent";
            Class<?> clazz;

            try {
                clazz = Class.forName(className);
                method = clazz.getDeclaredMethod(methodName);

                // Perform tests

                modifiers = method.getModifiers();

                actualReturnType = method.getReturnType();

                exceptions = method.getExceptionTypes();

                Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

                Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

                Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method does NOT throw an Exception", expectedLength, exceptions.length);

                Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT abstract!", Modifier.isAbstract(modifiers));
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + " declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } catch (Exception e) {
                Assert.fail("Error: " + e);
            } //end try catch
        }

        @Test(timeout = 1_000)
        public void fieldDeclarationTestHighSchoolStudentName() {
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "name";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Set the class being tested
            String className = "HighSchoolStudent";
            Class<?> clazz;

            try {
                clazz = Class.forName(className);
                testField = clazz.getDeclaredField(fieldName);

                // Perform tests

                modifiers = testField.getModifiers();

                type = testField.getType();

                Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

                Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `final`!", Modifier.isFinal(modifiers));

                Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

                Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);

            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + " declares a field named `" + fieldName + "`!");

                return;
            } catch (Exception e) {
                e.printStackTrace();
                Assert.fail("Error: " + e);
            } //end try catch


        }

        @Test(timeout = 1_000)
        public void fieldDeclarationTestHighSchoolStudentCourses() {
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "courses";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String[].class;

            // Set the class being tested
            String className = "HighSchoolStudent";
            Class<?> clazz;

            try {
                clazz = Class.forName(className);
                testField = clazz.getDeclaredField(fieldName);

                // Perform tests

                modifiers = testField.getModifiers();

                type = testField.getType();

                Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

                Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is`final`!", Modifier.isFinal(modifiers));

                Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

                Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);

            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + " declares a field named `" + fieldName + "`!");

                return;
            } catch (Exception e) {
                e.printStackTrace();
                Assert.fail("Error: " + e);
            } //end try catch


        }

        @Test(timeout = 1_000)
        public void fieldDeclarationTestHighSchoolStudentApproval() {
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "approval";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = boolean.class;

            // Set the class being tested
            String className = "HighSchoolStudent";
            Class<?> clazz;

            try {
                clazz = Class.forName(className);
                testField = clazz.getDeclaredField(fieldName);

                // Perform tests

                modifiers = testField.getModifiers();

                type = testField.getType();

                Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

                Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `final`!", Modifier.isFinal(modifiers));

                Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

                Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);

            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + " declares a field named `" + fieldName + "`!");

                return;
            } catch (Exception e) {
                e.printStackTrace();
                Assert.fail("Error: " + e);
            } //end try catch


        }

        @Test(timeout = 1_000)
        public void parameterizedConstructorDeclarationTestHighSchoolStudent() {
            Constructor<?> constructor;
            int modifiers;
            Class<?>[] exceptions;
            int expectedLength = 0;
            boolean set;

            // Set the class being tested
            String className = "HighSchoolStudent";
            Class<?> clazz;

            try {
                clazz = Class.forName(className);
                constructor = clazz.getDeclaredConstructor(String.class, String[].class, boolean.class);

                modifiers = constructor.getModifiers();

                exceptions = constructor.getExceptionTypes();

                Assert.assertTrue("Ensure that `" + className + "'s parameterized constructor is `public`!", Modifier.isPublic(modifiers));

                Assert.assertEquals("Ensure that `" + className + "''s parameterized constructor has no `throws` clauses!", expectedLength, exceptions.length);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "' declares a constructor that is `public` and has three parameters, a String, a String[], and a boolean!");

                return;
            }  catch (Exception e) {
                Assert.fail("Error: " + e);
            } // end try-catch


        }

        @Test(timeout = 1000)
        public void methodTestHighSchoolStudentToString() {
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "toString";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = String.class;

            // Set the class being tested
            String className = "HighSchoolStudent";
            Class<?> clazz;

            try {
                clazz = Class.forName(className);
                method = clazz.getDeclaredMethod(methodName);

                // Perform tests

                modifiers = method.getModifiers();

                actualReturnType = method.getReturnType();

                exceptions = method.getExceptionTypes();

                Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

                Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

                Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method does NOT throw an Exception", expectedLength, exceptions.length);

                Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT abstract!", Modifier.isAbstract(modifiers));
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + " declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } catch (Exception e) {
                Assert.fail("Error: " + e);
            } //end try catch
        }

        @Test(timeout = 1000)
        public void methodTestHighSchoolStudentEquals() {
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "equals";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = boolean.class;

            // Set the class being tested
            String className = "HighSchoolStudent";
            Class<?> clazz;

            try {
                clazz = Class.forName(className);
                method = clazz.getDeclaredMethod(methodName, Object.class);

                // Perform tests

                modifiers = method.getModifiers();

                actualReturnType = method.getReturnType();

                exceptions = method.getExceptionTypes();

                Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

                Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

                Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method does NOT throw an Exception", expectedLength, exceptions.length);

                Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT abstract!", Modifier.isAbstract(modifiers));
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + " declares a method named `" + methodName + "` that" +
                        " has 1 parameters!");

                return;
            } catch (Exception e) {
                Assert.fail("Error: " + e);
            } //end try catch
        }

        @Test(timeout = 1000)
        public void methodTestHighSchoolStudentGetName() {
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "getName";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = String.class;

            // Set the class being tested
            String className = "HighSchoolStudent";
            Class<?> clazz;

            try {
                clazz = Class.forName(className);
                method = clazz.getDeclaredMethod(methodName);

                // Perform tests

                modifiers = method.getModifiers();

                actualReturnType = method.getReturnType();

                exceptions = method.getExceptionTypes();

                Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

                Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

                Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method does NOT throw an Exception", expectedLength, exceptions.length);

                Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT abstract!", Modifier.isAbstract(modifiers));
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + " declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } catch (Exception e) {
                Assert.fail("Error: " + e);
            } //end try catch
        }

        @Test(timeout = 1000)
        public void methodTestHighSchoolStudentGetCourses() {
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "getCourses";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = String[].class;

            // Set the class being tested
            String className = "HighSchoolStudent";
            Class<?> clazz;

            try {
                clazz = Class.forName(className);
                method = clazz.getDeclaredMethod(methodName);

                // Perform tests

                modifiers = method.getModifiers();

                actualReturnType = method.getReturnType();

                exceptions = method.getExceptionTypes();

                Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

                Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

                Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method does NOT throw an Exception", expectedLength, exceptions.length);

                Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT abstract!", Modifier.isAbstract(modifiers));
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + " declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } catch (Exception e) {
                Assert.fail("Error: " + e);
            } //end try catch
        }
    }
}

