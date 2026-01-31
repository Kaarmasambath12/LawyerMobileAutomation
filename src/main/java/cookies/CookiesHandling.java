package cookies;

import browserdriver.DriverFactory;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class CookiesHandling {

    public static Set<Cookie> cookieSet;

    public static void getCookieMethod(){

      cookieSet = DriverFactory.getDriver().manage().getCookies();
      System.out.println(cookieSet.size());

        for (Cookie cookie : cookieSet) {

            System.out.println("The name of the cookie" + cookie.getName());
            System.out.println("The domain of the cookie" + cookie.getDomain());
            System.out.println("The value of the cookie" + cookie.getValue());
            System.out.println("The path of the cookie" + cookie.getPath());
        }
    }

    public static void deleteCookies(String cookieName){

        cookieSet = DriverFactory.getDriver().manage().getCookies();
        System.out.println(cookieSet.size());

        for(Cookie cookie: cookieSet){

            if(cookie.getName().equals(cookieName)){
                DriverFactory.getDriver().manage().deleteCookie(cookie);
                break;
            }
        }
        System.out.println(cookieSet.size());
    }

    public static void addCookie(String value, String name){

        Cookie cookies = new Cookie(name, value);
        DriverFactory.getDriver().manage().addCookie(cookies);

        System.out.println(cookies.getName());

    }

    public static void ClearBrowserCache() throws InterruptedException {

        cookieSet = DriverFactory.getDriver().manage().getCookies();
        System.out.println(cookieSet.size());

        DriverFactory.getDriver().manage().deleteAllCookies();
        Thread.sleep(4000);

        System.out.println(cookieSet.size());

    }



}
