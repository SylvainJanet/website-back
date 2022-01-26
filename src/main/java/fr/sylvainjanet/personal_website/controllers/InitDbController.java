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
import fr.sylvainjanet.personal_website.constants.languages.Languages.SupportedLanguage;
import fr.sylvainjanet.personal_website.constants.menu.MenuType;
import fr.sylvainjanet.personal_website.entities.LocalizedString;
import fr.sylvainjanet.personal_website.entities.Menu;
import fr.sylvainjanet.personal_website.entities.MenuItem;
import fr.sylvainjanet.personal_website.entities.Page;
import fr.sylvainjanet.personal_website.repositories.LocalizedStringRepository;
import fr.sylvainjanet.personal_website.repositories.MenuItemRepository;
import fr.sylvainjanet.personal_website.repositories.MenuRepository;
import fr.sylvainjanet.personal_website.repositories.PageRepository;

@RestController
@RequestMapping(PublicUriInitDb.CONTROLLER)
public class InitDbController {

	@Autowired
	private LocalizedStringRepository localizedStringRepository;

	@Autowired
	private PageRepository pageRepository;

	@Autowired
	private MenuItemRepository menuItemRepository;

	@Autowired
	private MenuRepository menuRepository;

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

		LocalizedString ls1_1 = new LocalizedString(new HashMap<SupportedLanguage, String>() {
			private static final long serialVersionUID = 9146089942369517544L;

			{
				put(SupportedLanguage.FRENCH, "valeur 1_1");
				put(SupportedLanguage.ENGLISH, "value 1_1");
			}
		});
		LocalizedString ls1_2 = new LocalizedString(new HashMap<SupportedLanguage, String>() {
			private static final long serialVersionUID = 6292166558712874461L;

			{
				put(SupportedLanguage.FRENCH, "valeur 1_2");
				put(SupportedLanguage.ENGLISH, "value 1_2");
			}
		});
		LocalizedString ls2_1 = new LocalizedString(new HashMap<SupportedLanguage, String>() {
			private static final long serialVersionUID = 2523551466465919948L;

			{
				put(SupportedLanguage.FRENCH, "valeur 2_1");
				put(SupportedLanguage.ENGLISH, "value 2_1");
			}
		});
		LocalizedString ls2_2 = new LocalizedString(new HashMap<SupportedLanguage, String>() {
			private static final long serialVersionUID = 420240115271120190L;

			{
				put(SupportedLanguage.FRENCH, "valeur 2_2");
				put(SupportedLanguage.ENGLISH, "value 2_2");
			}
		});
		LocalizedString ls3_1 = new LocalizedString(new HashMap<SupportedLanguage, String>() {
			private static final long serialVersionUID = -8907943915001430429L;

			{
				put(SupportedLanguage.FRENCH, "valeur 3_1");
				put(SupportedLanguage.ENGLISH, "value 3_1");
			}
		});
		LocalizedString ls3_2 = new LocalizedString(new HashMap<SupportedLanguage, String>() {
			private static final long serialVersionUID = 2383879285779473764L;

			{
				put(SupportedLanguage.FRENCH, "valeur 3_2");
				put(SupportedLanguage.ENGLISH, "value 3_2");
			}
		});
		LocalizedString ls4_1 = new LocalizedString(new HashMap<SupportedLanguage, String>() {
			private static final long serialVersionUID = -8907943915001430429L;

			{
				put(SupportedLanguage.FRENCH, "valeur 4_1");
				put(SupportedLanguage.ENGLISH, "value 4_1");
			}
		});
		LocalizedString ls4_2 = new LocalizedString(new HashMap<SupportedLanguage, String>() {
			private static final long serialVersionUID = 2383879285779473764L;

			{
				put(SupportedLanguage.FRENCH, "valeur 4_2");
				put(SupportedLanguage.ENGLISH, "value 4_2");
			}
		});

		LocalizedString ls_mit_1 = new LocalizedString(new HashMap<SupportedLanguage, String>() {
			private static final long serialVersionUID = -5473579365765801112L;

			{
				put(SupportedLanguage.FRENCH, "titre 1");
				put(SupportedLanguage.ENGLISH, "title 1");
			}
		});

		LocalizedString ls_mit_2 = new LocalizedString(new HashMap<SupportedLanguage, String>() {
			private static final long serialVersionUID = 970818789158530257L;

			{
				put(SupportedLanguage.FRENCH, "titre 2");
				put(SupportedLanguage.ENGLISH, "title 2");
			}
		});

		LocalizedString ls_mit_3 = new LocalizedString(new HashMap<SupportedLanguage, String>() {
			private static final long serialVersionUID = 9080418004335389664L;

			{
				put(SupportedLanguage.FRENCH, "titre 3");
				put(SupportedLanguage.ENGLISH, "title 3");
			}
		});

		LocalizedString ls_mit_4 = new LocalizedString(new HashMap<SupportedLanguage, String>() {
			private static final long serialVersionUID = -7769327884238044610L;

			{
				put(SupportedLanguage.FRENCH, "titre 4");
				put(SupportedLanguage.ENGLISH, "title 4");
			}
		});

		Page page1 = new Page(ls1_1, ls1_2);
		Page page2 = new Page(ls2_1, ls2_2);
		Page page3 = new Page(ls3_1, ls3_2);
		Page page4 = new Page(ls4_1, ls4_2);

//		MenuItem mi1 = new MenuItem(page1, ls_mit_1);
//		MenuItem mi4 = new MenuItem(page4, ls_mit_4);
//		MenuItem mi3 = new MenuItem(new ArrayList<MenuItem>(Arrays.asList(mi4)), page3, ls_mit_3);
//		MenuItem mi2 = new MenuItem(new ArrayList<MenuItem>(Arrays.asList(mi3)), page2, ls_mit_2);
//		MenuItem mi5 = new MenuItem(page1, ls_mit_1);
//		MenuItem mi6 = new MenuItem(new ArrayList<MenuItem>(Arrays.asList(mi4)), page2, ls_mit_2);
//		MenuItem mi7 = new MenuItem(new ArrayList<MenuItem>(Arrays.asList(mi3)), page2, ls_mit_2);

		MenuItem mi1 = new MenuItem(new ArrayList<MenuItem>(), 0, 0, 0L, ls_mit_1, page1);
		MenuItem mi2_1 = new MenuItem(new ArrayList<MenuItem>(), 1, 0, 0L, ls_mit_3, page3);
		MenuItem mi2_2 = new MenuItem(new ArrayList<MenuItem>(), 1, 1, 0L, ls_mit_3, page3);
		MenuItem mi2 = new MenuItem(new ArrayList<MenuItem>(Arrays.asList(mi2_1, mi2_2)), 0, 1, 0L, ls_mit_2, page2);
		MenuItem mi3 = new MenuItem(new ArrayList<MenuItem>(), 0, 2, 0L, ls_mit_3, page3);
		MenuItem mi4_1_1 = new MenuItem(new ArrayList<MenuItem>(), 2, 0, 0L, ls_mit_2, page2);
		MenuItem mi4_1 = new MenuItem(new ArrayList<MenuItem>(Arrays.asList(mi4_1_1)), 1, 0, 0L, ls_mit_1, page1);
		MenuItem mi4_2 = new MenuItem(new ArrayList<MenuItem>(), 1, 1, 0L, ls_mit_1, page1);
		MenuItem mi4 = new MenuItem(new ArrayList<MenuItem>(Arrays.asList(mi4_1, mi4_2)), 0, 3, 0L, ls_mit_4, page4);

		Menu m1 = new Menu(new ArrayList<MenuItem>(Arrays.asList(mi1, mi2, mi3, mi4)), MenuType.MAIN_MENU, 0);

		List<Menu> menus = new ArrayList<Menu>(Arrays.asList(m1));
		List<MenuItem> menuitems = new ArrayList<MenuItem>(
				Arrays.asList(mi1, mi2_1, mi2_2, mi2, mi3, mi4_1_1, mi4_1, mi4_2, mi4));
		List<Page> pages = new ArrayList<Page>(Arrays.asList(page1, page2, page3, page4));
		List<LocalizedString> strings = new ArrayList<LocalizedString>(Arrays.asList(ls1_1, ls1_2, ls2_1, ls2_2, ls3_1,
				ls3_2, ls4_1, ls4_2, ls_mit_1, ls_mit_2, ls_mit_3, ls_mit_4));

		for (LocalizedString s : strings) {
			LocalizedString saved = localizedStringRepository.saveAndFlush(s);
			s.setId(saved.getId());
			s.setVersion(saved.getVersion());
		}

		for (Page page : pages) {
			Page saved = pageRepository.saveAndFlush(page);
			page.setId(saved.getId());
			page.setVersion(saved.getVersion());
		}

		for (MenuItem i : menuitems) {
			MenuItem saved = menuItemRepository.saveAndFlush(i);
			i.setId(saved.getId());
			i.setVersion(saved.getVersion());
		}

		for (Menu m : menus) {
			Menu saved = menuRepository.saveAndFlush(m);
			m.setId(saved.getId());
			m.setVersion(saved.getVersion());
		}

		for (MenuItem i : menuitems) {
			i.setMenuId(menus.get(0).getId());
			menuItemRepository.saveAndFlush(i);
		}

		return ResponseEntity.status(HttpStatus.OK).body(Public.INITDB_RESET_OK);
	}

}
