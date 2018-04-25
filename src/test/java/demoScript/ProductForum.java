package demoScript;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

/*import java.util.ArrayList;
import java.util.Collections;
import java.util.List;*/
import java.util.Comparator;
import java.util.Iterator;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;

public class ProductForum {
  public static WebDriver driver;
  public static Location l1;
  public static Location l2;
  public static Location l3;
  public static Location[] loc;
  public static Location[] locs;
  public static Match m;
  public static Comparator<Location> comp;
      
  @Test
  public static void main(String[] args) throws Exception {
	  
	  Screen screen = new Screen();
	  
	  Pattern image1 = new Pattern("C:\\Users\\Me\\eclipse-workspace\\SikuliDemo\\images\\pin1.PNG");
	  //Pattern image2 = new Pattern("C:\\Users\\Me\\eclipse-workspace\\SikuliDemo\\images\\pin2.PNG");
	  //Pattern image3 = new Pattern("C:\\Users\\Me\\eclipse-workspace\\SikuliDemo\\images\\pin3.PNG");
	  Pattern image4 = new Pattern("C:\\Users\\Me\\eclipse-workspace\\SikuliDemo\\images\\signin.PNG");
	  
	  System.setProperty("webdriver.gecko.driver","C:/Users/Me/Downloads/geckodriver-v0.20.1-win64/geckodriver.exe");
	  DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	  capabilities.setCapability("marionette", true);
	  //System.setProperty("webdriver.chrome.driver","C:/Users/Me/Downloads/chromedriver_win32/chromedriver.exe");
	  driver=new FirefoxDriver();
	  //driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://productforums.google.com/forum/#!forum/chrome");
	  
	  Thread.sleep(5000);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,200)", "");
	  
	  
	  //screen.wait(image1, 10);
	  Iterator <Match> It = screen.findAll(image1);
	  /*List<Location> Itr = sortedList(It);
	  //List<Location> Itr = sortedList(It,comp);
	  //screen.click(It.next());
	  screen.click(Itr.get(1));
	  System.out.println(Itr.get(0));*/
	  
	  Match m1 = (Match)It.next();
	  System.out.println(m1.getTarget());
	  l1 = m1.getTarget();
	  if(It.hasNext()) {
	  Match m2 = (Match)It.next();
	  l2 = m2.getTarget();
	  screen.click(l2);
	  }
	  if(It.hasNext()) {
		  Match m3 = (Match)It.next();
		  l3 = m3.getTarget();		 
		  }
	  int y1 = l1.getY();
	  int y2 = l2.getY();
	  int y3 = l3.getY();
	  int[] arr1 = {y1,y2,y3};
	  int[] arr2 = doSelectionSort(arr1);
	  
	  if (arr2[1]==y1) screen.click(l1);
	  if (arr2[1]==y2) screen.click(l2);
	  else screen.click(l3);
	  
	  /*if (y1<y2)
	  {
		  if(y2<y3) screen.click(l2);
		  else if (y1<y3) screen.click(l3);
		  else screen.click(l1);	 
	  }
	  else
	  {
		  if(y1<y3) screen.click(l1);
		  else if (y2<y3) screen.click(l3);
		  else screen.click(l2);
	  }*/
	  
	   /*int i=0;
	   while (Itr.hasNext()) {
	   m = (Match)Itr.next();
	   loc[i] = m.getTarget();
	   System.out.println(loc[0]);
	   i++;
	   }
	   
	   locs = doSelectionSort(loc);
	   screen.click(locs[1]);*/
	    
	  
	  Thread.sleep(5000);
	  /*screen.wait(image4, 10);	  
	  Match match = (Match) screen.find(image4);
	  match.click(image4);*/
	  
	  /*
	  screen.wait(image2, 10);
	  screen.click(image1);
	  screen.click(image2);
	  screen.type(image3, "kd***9720");*/
	  screen.click(image4);
	  
	  driver.quit();
	  
  }
  
  /*public static List<Location> sortedList(Iterator<Match> it, Comparator<Location> comparator) {
      List<Location> list = new ArrayList<Location>();
      while (it.hasNext()) {
          m = (Match)it.next();
          list.add(m.getTarget());
      }

      Collections.sort(list, comparator);
      return list;
  }*/
  
  /*public static List<Location> sortedList(Iterator<Match> it) {
      List<Location> list = new ArrayList<Location>();
      while (it.hasNext()) {
          m = (Match)it.next();
          list.add(m.getTarget());
      }

      Collections.sort(list,new Comparator<Object>() {

			public int compare(Object o1,
					Object o2) {
				return o2.toString().compareTo(o1.toString());
			}
		});
      return list;
  } */
  
  public static int[] doSelectionSort(int[] arr){
         
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index]) 
                    index = j;
      
            int smallerNumber = arr[index];  
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        return arr;
    }
  @BeforeClass
  public void beforeClass() {
  }
  
  @AfterClass
  public void afterClass() {
  }
  
}
