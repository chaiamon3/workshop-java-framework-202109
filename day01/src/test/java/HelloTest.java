import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <description>
 *
 * @author nattawat.k
 * @type PACKAGE_NAME
 * @contact nattawat.k@kbtg.tech
 * @date 9/6/2021 10:41 AM
 */
public class HelloTest {

    @Test
    public void case01() {
        // Arrange
        Hello hello = new Hello();
        // Act
        String actualResult = hello.sayHi("nutzallstar");
        // Assert
        assertEquals("Hello, nutzallstar", actualResult);
    }

}
