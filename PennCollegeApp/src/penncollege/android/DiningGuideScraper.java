package penncollege.android;

public class DiningGuideScraper extends WebScraper {

	/**
	 *
	 * Updates the local cache for the dining guide
	 */
	public static void updateLocalDB() {
		String weekURL = "http://www.pct.edu/pctoday/dining_guide/"+DiningGuideScraper.getInside("http://www.pct.edu/pctoday/dining_guide/", "You have JavaScript disabled, you must <a href=\"", "\">view the entire week</a> at once.</p>");
		String menu = DiningGuideScraper.getInside(weekURL,"<div id=\"weekMenu\">","<div class=\"foot\">");
		
	}
	
}
