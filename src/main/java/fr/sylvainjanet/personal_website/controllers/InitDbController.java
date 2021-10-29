package fr.sylvainjanet.personal_website.controllers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibatis.common.jdbc.ScriptRunner;

import fr.sylvainjanet.personal_website.constants.api.Public;
import fr.sylvainjanet.personal_website.constants.api.uri.PublicUriInitDb;
import fr.sylvainjanet.personal_website.constants.languages.Languages.SupportedLanguages;
import fr.sylvainjanet.personal_website.entities.LanguagedString;
import fr.sylvainjanet.personal_website.entities.WebPageCategoryMain;
import fr.sylvainjanet.personal_website.entities.WebsiteMainMenu;
import fr.sylvainjanet.personal_website.entities.WebsiteMainMenuItem;
import fr.sylvainjanet.personal_website.repositories.LanguagedStringRepository;
import fr.sylvainjanet.personal_website.repositories.WebPageCategoryMainRepository;
import fr.sylvainjanet.personal_website.repositories.WebsiteMainMenuItemRepository;
import fr.sylvainjanet.personal_website.repositories.WebsiteMainMenuRepository;

@RestController
@RequestMapping(PublicUriInitDb.CONTROLLER)
public class InitDbController {

	@Autowired
	private LanguagedStringRepository languagedStringRepository;

	@Autowired
	private WebPageCategoryMainRepository webPageCategoryMainRepository;

	@Autowired
	private WebsiteMainMenuItemRepository websiteMainMenuItemRepository;

	@Autowired
	private WebsiteMainMenuRepository websiteMainMenuRepository;

	@Value("${spring.datasource.driver-class-name}")
	private String jdbcDriver;

	@Value("${spring.datasource.url}")
	private String dbUrl;

	@Value("${spring.datasource.username}")
	private String dbUsername;

	@Value("${spring.datasource.password}")
	private String dbPassword;

	@GetMapping(value = PublicUriInitDb.RESETDB, produces = { "application/json", "application/xml" })
	public ResponseEntity<?> resetDb() {
		String scriptSqlPath = "script_truncate";
		Reader reader = null;
		Connection connection = null;
		try {
			Class.forName(jdbcDriver);
			connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			ScriptRunner scriptRunner = new ScriptRunner(connection, false, false);
			InputStream input = InitDbController.class.getResourceAsStream("/resources/" + scriptSqlPath);
			if (input == null) {
				// this is how we load file within editor (eg eclipse)
				input = InitDbController.class.getClassLoader().getResourceAsStream(scriptSqlPath);
			}
			reader = new BufferedReader(new InputStreamReader(input));
			// reader = new BufferedReader(new
			// FileReader("src/main/resources/"+scriptSqlPath));
			scriptRunner.setLogWriter(null);
			scriptRunner.runScript(reader);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		LanguagedString ls1_1 = new LanguagedString(new HashMap<SupportedLanguages, String>() {
			private static final long serialVersionUID = 9146089942369517544L;

			{
				put(SupportedLanguages.FRENCH, "valeur 1_1");
				put(SupportedLanguages.ENGLISH, "value 1_1");
			}
		});
		LanguagedString ls1_2 = new LanguagedString(new HashMap<SupportedLanguages, String>() {
			private static final long serialVersionUID = 6292166558712874461L;

			{
				put(SupportedLanguages.FRENCH, "valeur 1_2");
				put(SupportedLanguages.ENGLISH, "value 1_2");
			}
		});
		LanguagedString ls2_1 = new LanguagedString(new HashMap<SupportedLanguages, String>() {
			private static final long serialVersionUID = 2523551466465919948L;

			{
				put(SupportedLanguages.FRENCH, "valeur 2_1");
				put(SupportedLanguages.ENGLISH, "value 2_1");
			}
		});
		LanguagedString ls2_2 = new LanguagedString(new HashMap<SupportedLanguages, String>() {
			private static final long serialVersionUID = 420240115271120190L;

			{
				put(SupportedLanguages.FRENCH, "valeur 2_2");
				put(SupportedLanguages.ENGLISH, "value 2_2");
			}
		});
		LanguagedString ls3_1 = new LanguagedString(new HashMap<SupportedLanguages, String>() {
			private static final long serialVersionUID = -8907943915001430429L;

			{
				put(SupportedLanguages.FRENCH, "valeur 3_1");
				put(SupportedLanguages.ENGLISH, "value 3_1");
			}
		});
		LanguagedString ls3_2 = new LanguagedString(new HashMap<SupportedLanguages, String>() {
			private static final long serialVersionUID = 2383879285779473764L;

			{
				put(SupportedLanguages.FRENCH, "valeur 3_2");
				put(SupportedLanguages.ENGLISH, "value 3_2");
			}
		});
		LanguagedString ls4_1 = new LanguagedString(new HashMap<SupportedLanguages, String>() {
			private static final long serialVersionUID = -8907943915001430429L;

			{
				put(SupportedLanguages.FRENCH, "valeur 4_1");
				put(SupportedLanguages.ENGLISH, "value 4_1");
			}
		});
		LanguagedString ls4_2 = new LanguagedString(new HashMap<SupportedLanguages, String>() {
			private static final long serialVersionUID = 2383879285779473764L;

			{
				put(SupportedLanguages.FRENCH, "valeur 4_2");
				put(SupportedLanguages.ENGLISH, "value 4_2");
			}
		});

		LanguagedString ls_mit_1 = new LanguagedString(new HashMap<SupportedLanguages, String>() {
			private static final long serialVersionUID = -5473579365765801112L;

			{
				put(SupportedLanguages.FRENCH, "titre 1");
				put(SupportedLanguages.ENGLISH, "title 1");
			}
		});

		LanguagedString ls_mit_2 = new LanguagedString(new HashMap<SupportedLanguages, String>() {
			private static final long serialVersionUID = 970818789158530257L;

			{
				put(SupportedLanguages.FRENCH, "titre 2");
				put(SupportedLanguages.ENGLISH, "title 2");
			}
		});

		LanguagedString ls_mit_3 = new LanguagedString(new HashMap<SupportedLanguages, String>() {
			private static final long serialVersionUID = 9080418004335389664L;

			{
				put(SupportedLanguages.FRENCH, "titre 3");
				put(SupportedLanguages.ENGLISH, "title 3");
			}
		});

		LanguagedString ls_mit_4 = new LanguagedString(new HashMap<SupportedLanguages, String>() {
			private static final long serialVersionUID = -7769327884238044610L;

			{
				put(SupportedLanguages.FRENCH, "titre 4");
				put(SupportedLanguages.ENGLISH, "title 4");
			}
		});

		WebPageCategoryMain page1 = new WebPageCategoryMain(ls1_1, ls1_2);
		WebPageCategoryMain page2 = new WebPageCategoryMain(ls2_1, ls2_2);
		WebPageCategoryMain page3 = new WebPageCategoryMain(ls3_1, ls3_2);
		WebPageCategoryMain page4 = new WebPageCategoryMain(ls4_1, ls4_2);

		WebsiteMainMenuItem mi1 = new WebsiteMainMenuItem(page1, ls_mit_1);
		WebsiteMainMenuItem mi4 = new WebsiteMainMenuItem(page4, ls_mit_4);
		WebsiteMainMenuItem mi3 = new WebsiteMainMenuItem(new ArrayList<WebsiteMainMenuItem>(Arrays.asList(mi4)), page3,
				ls_mit_3);
		WebsiteMainMenuItem mi2 = new WebsiteMainMenuItem(new ArrayList<WebsiteMainMenuItem>(Arrays.asList(mi3)), page2,
				ls_mit_2);
		WebsiteMainMenuItem mi5 = new WebsiteMainMenuItem(page1, ls_mit_1);
		WebsiteMainMenuItem mi6 = new WebsiteMainMenuItem(new ArrayList<WebsiteMainMenuItem>(Arrays.asList(mi4)), page2,
				ls_mit_2);
		WebsiteMainMenuItem mi7 = new WebsiteMainMenuItem(new ArrayList<WebsiteMainMenuItem>(Arrays.asList(mi3)), page2,
				ls_mit_2);
		
		
		WebsiteMainMenu m1 = new WebsiteMainMenu(new ArrayList<WebsiteMainMenuItem>(Arrays.asList(mi1, mi2,mi5,mi6,mi7)));

		List<WebsiteMainMenu> menus = new ArrayList<WebsiteMainMenu>(Arrays.asList(m1));
		List<WebsiteMainMenuItem> menuitems = new ArrayList<WebsiteMainMenuItem>(Arrays.asList(mi1, mi4, mi3, mi2,mi5,mi6,mi7));
		List<WebPageCategoryMain> pages = new ArrayList<WebPageCategoryMain>(Arrays.asList(page1, page2, page3, page4));
		List<LanguagedString> strings = new ArrayList<LanguagedString>(Arrays.asList(ls1_1, ls1_2, ls2_1, ls2_2, ls3_1,
				ls3_2, ls4_1, ls4_2, ls_mit_1, ls_mit_2, ls_mit_3, ls_mit_4));

		for (LanguagedString s : strings) {
			languagedStringRepository.saveAndFlush(s);
		}

		for (WebPageCategoryMain page : pages) {
			webPageCategoryMainRepository.saveAndFlush(page);
		}

		for (WebsiteMainMenuItem i : menuitems) {
			websiteMainMenuItemRepository.saveAndFlush(i);
		}

		for (WebsiteMainMenu m : menus) {
			websiteMainMenuRepository.saveAndFlush(m);
		}

		return ResponseEntity.status(HttpStatus.OK).body(Public.INITDB_RESET_OK);
	}

}
